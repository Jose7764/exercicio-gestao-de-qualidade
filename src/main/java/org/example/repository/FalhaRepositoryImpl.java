package org.example.repository;

import org.example.model.Equipamento;
import org.example.model.Falha;
import org.example.util.Conexao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FalhaRepositoryImpl implements FalhaRepository {

    EquipamentoRepository repositoryEquip = new EquipamentoRepositoryImpl();

    @Override
    public Falha registrarNovaFalha(Falha falha) throws SQLException {

            String query = """
                    INSERT INTO Falha
                    (equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras)
                    VALUES(?,?,?,?,?,?)
                    """;

            try(Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

                stmt.setInt(1, falha.getEquipamentoId());
                stmt.setTimestamp(2, Timestamp.valueOf(falha.getDataHoraOcorrencia()));
                stmt.setString(3, falha.getDescricao());
                stmt.setString(4, falha.getCriticidade());
                stmt.setString(5, falha.getStatus());
                stmt.setDouble(6, falha.getTempoParadaHoras());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    falha.setId(rs.getInt(1));
                }

                repositoryEquip.atualizarEquipamento(falha.getEquipamentoId());


            }

        return falha;
    }

    @Override
    public List<Falha> buscarFalhasCriticasAbertas() throws SQLException {

        String query = """
                SELECT equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras
                FROM Falha 
                where criticidade = "CRITICA"
                AND status = "ABERTA"
                """;

        List<Falha> listFalha = new ArrayList<>();

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int equipamentoID = rs.getInt("equipamentoId");
                LocalDateTime dataHora = rs.getTimestamp("dataHoraOcorrencia").toLocalDateTime();
                String descricao = rs.getString("descricao");
                String criticidade = rs.getString("criticidade");
                String status = rs.getString("status");
                double tempoParada = rs.getDouble("tempoParadaHoras");

                listFalha.add(new Falha(equipamentoID, dataHora, descricao, criticidade, status, tempoParada));
            }

        };
        return listFalha;
    }



}
