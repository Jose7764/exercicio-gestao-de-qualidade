package org.example.repository;

import org.example.model.Equipamento;

import java.sql.SQLException;

public interface EquipamentoRepository {

    Equipamento cadastrarEquipamento(Equipamento equipamento) throws SQLException;


}
