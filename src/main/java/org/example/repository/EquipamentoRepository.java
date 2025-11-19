package org.example.repository;

import org.example.model.Equipamento;

import java.sql.SQLException;

public interface EquipamentoRepository {

    Equipamento cadastrarEquipamento(Equipamento equipamento) throws SQLException;

    void atualizarEquipamento(int id)throws SQLException;

    Equipamento buscarEquipamentoPorId(int id)throws SQLException;
}
