package org.example.repository;

import org.example.model.Equipamento;
import org.example.util.Conexao;

import javax.xml.transform.Result;
import java.sql.*;

public class EquipamentoRepositoryImpl implements EquipamentoRepository {

    @Override
    public Equipamento cadastrarEquipamento (Equipamento equipamento)throws SQLException {

        String query = """
                INSERT INTO Equipamento
                (nome, numeroDeSerie, areaSetor, statusOperacional)
                VALUES (?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){


            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getNumeroDeSerie());
            stmt.setString(3, equipamento.getAreaSetor());
            stmt.setString(4, equipamento.getStatusOperacional());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                equipamento.setId(rs.getInt(1));
            }

            if(equipamento.getNome() == null || equipamento.getNome().isBlank()){
                throw new RuntimeException("O nome do equipamento não pode ser vazio.");
            }
        }
        return equipamento;
    }

    @Override
    public void atualizarEquipamento(int id)throws SQLException{

        String query = """
                UPDATE Equipamento set statusOperacional = 'EM_MANUTENCAO' where id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Equipamento buscarEquipamentoPorId(int id)throws SQLException{

        String query = """
                SELECT nome, numeroDeSerie, areaSetor, statusOperacional 
                FROM Equipamento where id = ?;
                """;

        Equipamento equipamento;
        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();;

            if (rs.next()){

                String nome = rs.getString("nome");
                String numeroSerie = rs.getString("numeroDeSerie");
                String areaSetor = rs.getString("areaSetor");
                String status = rs.getString("statusOperacional");

                equipamento = new Equipamento(nome,numeroSerie,areaSetor,status);


            }else {
                return null;
            }


        }
        
        return equipamento;
    }
}
