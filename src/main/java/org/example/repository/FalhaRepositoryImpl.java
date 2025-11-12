package org.example.repository;

import org.example.model.Falha;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FalhaRepositoryImpl implements FalhaRepository {


    @Override
    public Falha registrarNovaFalha(Falha falha) throws SQLException {

            String query = """
                    INSERT INTO Falha
                    (equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras)
                    VALUES(?,?,?,?,?,?)
                    """;

            try(Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setInt(1, falha.getEquipamentoId());
                stmt.setTimestamp(2, Timestamp.valueOf(falha.getDataHoraOcorrencia()));
                stmt.setString(3, falha.getDescricao());
                stmt.setString(4, falha.getCriticidade());
                stmt.setString(5, falha.getStatus());
                stmt.setDouble(6, falha.getTempoParadaHoras());

                stmt.executeUpdate();

            }
        return null;
    }

    @Override
    public Falha buscarFalhasCriticasAbertas() throws SQLException {
        return null;
    }
}
