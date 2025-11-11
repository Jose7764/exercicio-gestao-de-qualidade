package org.example.service;

import org.example.model.Equipamento;
import org.example.model.Falha;
import org.example.util.Conexao;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste de Integração - FalhaService com Banco Real")
public class FalhaServiceIntegrationTest {

    private FalhaService falhaService;
    private EquipamentoService equipamentoService;

    private static final String SQL_DROP_FALHA = "DROP TABLE IF EXISTS Falha;";
    private static final String SQL_DROP_EQUIPAMENTO = "DROP TABLE IF EXISTS Equipamento;";
    private static final String SQL_DROP_ACAO = "DROP TABLE IF EXISTS AcaoCorretiva;";

    private static final String SQL_CREATE_EQUIPAMENTO =
            "CREATE TABLE Equipamento (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "numeroDeSerie VARCHAR(100) NOT NULL UNIQUE, " +
                    "areaSetor VARCHAR(100) NOT NULL, " +
                    "statusOperacional VARCHAR(50) NOT NULL, " +
                    "CONSTRAINT chk_status_equipamento CHECK (statusOperacional IN ('OPERACIONAL', 'EM_MANUTENCAO', 'INATIVO'))" +
                    ");";

    private static final String SQL_CREATE_FALHA =
            "CREATE TABLE Falha (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "equipamentoId BIGINT NOT NULL, " +
                    "dataHoraOcorrencia DATETIME NOT NULL, " +
                    "descricao TEXT NOT NULL, " +
                    "criticidade VARCHAR(50) NOT NULL, " +
                    "status VARCHAR(50) NOT NULL, " +
                    "tempoParadaHoras DECIMAL(10, 2) DEFAULT 0.00, " +
                    "CONSTRAINT chk_criticidade_falha CHECK (criticidade IN ('BAIXA', 'MEDIA', 'ALTA', 'CRITICA')), " +
                    "CONSTRAINT chk_status_falha CHECK (status IN ('ABERTA', 'EM_ANDAMENTO', 'RESOLVIDA')), " +
                    "CONSTRAINT fk_falha_equipamento FOREIGN KEY (equipamentoId) REFERENCES Equipamento(id) ON DELETE RESTRICT" +
                    ");";

    private static final String SQL_CREATE_ACAO =
            "CREATE TABLE AcaoCorretiva (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "falhaId BIGINT NOT NULL, " +
                    "dataHoraInicio DATETIME NOT NULL, " +
                    "dataHoraFim DATETIME NOT NULL, " +
                    "responsavel VARCHAR(255) NOT NULL, " +
                    "descricaoAcao TEXT NOT NULL, " +
                    "CONSTRAINT fk_acao_falha FOREIGN KEY (falhaId) REFERENCES Falha(id) ON DELETE RESTRICT" +
                    ");";

    private static final String SQL_DELETE_ACAO = "DELETE FROM AcaoCorretiva;";
    private static final String SQL_DELETE_FALHA = "DELETE FROM Falha;";
    private static final String SQL_DELETE_EQUIP = "DELETE FROM Equipamento;";

    @BeforeAll
    static void setupDatabase() throws Exception {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL_DROP_ACAO);
            stmt.execute(SQL_DROP_FALHA);
            stmt.execute(SQL_DROP_EQUIPAMENTO);
            stmt.execute(SQL_CREATE_EQUIPAMENTO);
            stmt.execute(SQL_CREATE_FALHA);
            stmt.execute(SQL_CREATE_ACAO);
            System.out.println("Tabelas criadas com sucesso para o teste de integração.");
        }
    }

    @AfterAll
    static void tearDownDatabase() throws Exception {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL_DROP_ACAO);
            stmt.execute(SQL_DROP_FALHA);
            stmt.execute(SQL_DROP_EQUIPAMENTO);
            System.out.println("Tabelas removidas após os testes.");
        }
    }

    @BeforeEach
    void setupTest() throws Exception {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
            stmt.executeUpdate(SQL_DELETE_ACAO);
            stmt.executeUpdate(SQL_DELETE_FALHA);
            stmt.executeUpdate(SQL_DELETE_EQUIP);
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
        }
        equipamentoService = new EquipamentoServiceImpl();
        falhaService = new FalhaServiceImpl();
    }

    @Test
    @DisplayName("Deve registrar uma nova falha e deixá-la com status ABERTA")
    void testRegistrarFalha_Sucesso() throws Exception {
        Equipamento eq = new Equipamento("Compressor A", "COMP123", "Setor 1", "OPERACIONAL");
        eq = equipamentoService.criarEquipamento(eq);

        Falha f = new Falha(eq.getId(), LocalDateTime.now(), "Falha no motor", "MEDIA", "ABERTA", 0);
        Falha salva = falhaService.registrarNovaFalha(f);

        assertNotNull(salva);
        assertTrue(salva.getId() > 0);
        assertEquals("ABERTA", salva.getStatus());

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Falha WHERE id = " + salva.getId())) {
            assertTrue(rs.next());
            assertEquals("MEDIA", rs.getString("criticidade"));
        }
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar registrar falha em equipamento inexistente")
    void testRegistrarFalha_EquipamentoInvalido() {
        Falha f = new Falha(999, LocalDateTime.now(), "Falha misteriosa", "BAIXA", "ABERTA", 0);
        assertThrows(RuntimeException.class, () -> falhaService.registrarNovaFalha(f));
    }

    @Test
    @DisplayName("Deve registrar falha crítica e atualizar equipamento para EM_MANUTENCAO")
    void testRegistrarFalhaCritica_AtualizaStatusEquipamento() throws Exception {
        Equipamento eq = new Equipamento("Esteira X", "EST123", "Linha 3", "OPERACIONAL");
        eq = equipamentoService.criarEquipamento(eq);

        Falha f = new Falha(eq.getId(), LocalDateTime.now(), "Falha grave no motor", "CRITICA", "ABERTA", 0);
        falhaService.registrarNovaFalha(f);

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT statusOperacional FROM Equipamento WHERE id = " + eq.getId())) {
            assertTrue(rs.next());
            assertEquals("EM_MANUTENCAO", rs.getString("statusOperacional"));
        }
    }

    @Test
    @DisplayName("Deve buscar todas as falhas críticas abertas")
    void testBuscarFalhasCriticasAbertas() throws Exception {
        Equipamento eq = new Equipamento("Torno CNC", "CNC123", "Usinagem", "OPERACIONAL");
        eq = equipamentoService.criarEquipamento(eq);

        falhaService.registrarNovaFalha(new Falha(eq.getId(), LocalDateTime.now(), "Curto elétrico", "CRITICA", "ABERTA", 0));
        falhaService.registrarNovaFalha(new Falha(eq.getId(), LocalDateTime.now(), "Ruído leve", "BAIXA", "ABERTA", 0));

        List<Falha> criticas = falhaService.buscarFalhasCriticasAbertas();

        assertNotNull(criticas);
        assertEquals(1, criticas.size());
        assertEquals("CRITICA", criticas.get(0).getCriticidade());
    }

    @Test
    @Order(1)
    void deveCadastrarEquipamento() throws Exception {
        Equipamento e = new Equipamento("Compressor", "CMP-1001", "Setor A", "OPERACIONAL");
        Equipamento salvo = equipamentoService.criarEquipamento(e);

        assertNotNull(salvo);
        assertTrue(salvo.getId() > 0);
        assertEquals("Compressor", salvo.getNome());
    }

    @Test
    @Order(2)
    void deveBuscarEquipamentoPorId() throws Exception {
        Equipamento e = new Equipamento("Esteira", "EST-2001", "Linha 2", "OPERACIONAL");
        Equipamento salvo = equipamentoService.criarEquipamento(e);

        Equipamento buscado = equipamentoService.buscarEquipamentoporId(salvo.getId());
        assertNotNull(buscado);
        assertEquals("Esteira", buscado.getNome());
    }

    @Test
    @Order(3)
    void naoDeveCadastrarEquipamentoComNomeVazio() {
        Equipamento e = new Equipamento("", "S/N", "Setor C", "OPERACIONAL");
        assertThrows(RuntimeException.class, () -> equipamentoService.criarEquipamento(e));
    }
}
