package org.example.service;

import org.example.model.Falha;
import org.example.repository.FalhaRepository;
import org.example.repository.FalhaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class FalhaServiceImpl implements FalhaService {

    FalhaRepository repository = new FalhaRepositoryImpl();

    @Override
    public Falha registrarNovaFalha(Falha falha) throws SQLException {

        repository.registrarNovaFalha(falha);

        return null;
    }

    @Override
    public List<Falha> buscarFalhasCriticasAbertas() {
        return List.of();
    }
}
