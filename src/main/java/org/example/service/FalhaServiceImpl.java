package org.example.service;

import org.example.model.Equipamento;
import org.example.model.Falha;
import org.example.repository.EquipamentoRepository;
import org.example.repository.EquipamentoRepositoryImpl;
import org.example.repository.FalhaRepository;
import org.example.repository.FalhaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class FalhaServiceImpl implements FalhaService {

    FalhaRepository repository = new FalhaRepositoryImpl();
    EquipamentoRepository repositoryEquip = new EquipamentoRepositoryImpl();

    @Override
    public Falha registrarNovaFalha(Falha falha) throws SQLException {

        Equipamento equipamento = repositoryEquip.buscarEquipamentoPorId(falha.getEquipamentoId());

        if(equipamento == null){
            throw new RuntimeException("Equipamento nao existente");
        }

        return repository.registrarNovaFalha(falha);

    }

    @Override
    public List<Falha> buscarFalhasCriticasAbertas() throws SQLException {



        return repository.buscarFalhasCriticasAbertas();
    }
}
