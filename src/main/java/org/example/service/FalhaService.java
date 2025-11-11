package org.example.service;

import org.example.model.Falha;

import java.util.List;

public interface FalhaService {
    Falha registrarNovaFalha(Falha falha);

    List<Falha> buscarFalhasCriticasAbertas();
}
