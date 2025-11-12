package org.example.repository;

import org.example.model.Falha;

import java.sql.SQLException;

public interface FalhaRepository {
    Falha registrarNovaFalha(Falha falha) throws SQLException;

    Falha buscarFalhasCriticasAbertas() throws SQLException;
}
