package org.example.repository;

import org.example.model.Falha;

import java.sql.SQLException;

public interface FalhaRepository {
    Falha registrarNovaFalha() throws SQLException;

    Falha buscarFalhasCriticasAbertas() throws SQLException;
}
