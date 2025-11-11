package org.example.repository;

import org.example.model.Equipamento;
import org.example.util.Conexao;

import java.sql.*;

public class EquipamentoRepositoryImpl implements EquipamentoRepository {

    @Override
    public Equipamento cadastrarEquipamento (Equipamento equipamento)throws SQLException {

        String query = """
                INSERT INTO equipamento
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
        }
        return equipamento;
    }
}
