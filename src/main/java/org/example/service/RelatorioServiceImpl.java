package org.example.service;

import org.example.DTO.EquipamentoContagemFalhasDTO;
import org.example.DTO.FalhaDetalhadaDTO;
import org.example.DTO.RelatorioParadaDTO;
import org.example.model.Equipamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RelatorioServiceImpl implements RelatorioService {

    @Override
    public List<RelatorioParadaDTO> gerarRelatorioTempoParada(){
        return null;
    }

    @Override
    public List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim){
        return null;
    }

    @Override
    public Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId){
        return null;
    }

    @Override
    public List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPreventiva(int contagemMinimaFalhas){
        return null;
    }


}
