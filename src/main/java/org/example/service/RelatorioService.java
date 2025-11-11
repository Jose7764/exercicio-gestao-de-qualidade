package org.example.service;

import org.example.DTO.EquipamentoContagemFalhasDTO;
import org.example.DTO.FalhaDetalhadaDTO;
import org.example.DTO.RelatorioParadaDTO;
import org.example.model.Equipamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RelatorioService {
    List<RelatorioParadaDTO> gerarRelatorioTempoParada();

    List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim);

    Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId);

    List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPreventiva(int contagemMinimaFalhas);
}
