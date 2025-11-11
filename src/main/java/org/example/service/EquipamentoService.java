package org.example.service;

import org.example.model.Equipamento;

public interface EquipamentoService {
    Equipamento criarEquipamento(Equipamento equipamento);

    Equipamento buscarEquipamentoporId(long id);
}
