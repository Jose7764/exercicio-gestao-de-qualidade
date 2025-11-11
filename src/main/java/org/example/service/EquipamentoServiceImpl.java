package org.example.service;

import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepository;
import org.example.repository.EquipamentoRepositoryImpl;

import java.sql.SQLException;

public class EquipamentoServiceImpl implements EquipamentoService {

    EquipamentoRepository repository = new EquipamentoRepositoryImpl();

    @Override
    public Equipamento criarEquipamento(Equipamento equipamento) throws SQLException {

        repository.cadastrarEquipamento(equipamento);

    return equipamento;
    }

    @Override
    public Equipamento buscarEquipamentoporId(int id){
        return null;
    }

}
