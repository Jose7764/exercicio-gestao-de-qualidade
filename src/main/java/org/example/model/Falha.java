package org.example.model;

import java.time.LocalDateTime;

public class Falha {

    private int id;
    private int equipamentoId;
    private LocalDateTime dataHoraOcorrencia;
    private String descricao;
    private String criticidade;
    private String status;
    private double tempoParadaHoras;


    public Falha() {
    }


    public Falha(int equipamentoId, LocalDateTime dataHoraOcorrencia, String descricao, String criticidade, String status, double tempoParadaHoras) {
        this.equipamentoId = equipamentoId;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
        this.descricao = descricao;
        this.criticidade = criticidade;
        this.status = status;
        this.tempoParadaHoras = tempoParadaHoras;
    }


    public Falha(int id, int equipamentoId, LocalDateTime dataHoraOcorrencia, String descricao, String criticidade, String status, double tempoParadaHoras) {
        this.id = id;
        this.equipamentoId = equipamentoId;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
        this.descricao = descricao;
        this.criticidade = criticidade;
        this.status = status;
        this.tempoParadaHoras = tempoParadaHoras;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public LocalDateTime getDataHoraOcorrencia() {
        return dataHoraOcorrencia;
    }

    public void setDataHoraOcorrencia(LocalDateTime dataHoraOcorrencia) {
        this.dataHoraOcorrencia = dataHoraOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTempoParadaHoras() {
        return tempoParadaHoras;
    }

    public void setTempoParadaHoras(double tempoParadaHoras) {
        this.tempoParadaHoras = tempoParadaHoras;
    }

    @Override
    public String toString() {
        return "Falha{" +
                "id=" + id +
                ", equipamentoId=" + equipamentoId +
                ", dataHoraOcorrencia=" + dataHoraOcorrencia +
                ", descricao='" + descricao + '\'' +
                ", criticidade='" + criticidade + '\'' +
                ", status='" + status + '\'' +
                ", tempoParadaHoras=" + tempoParadaHoras +
                '}';
    }
}
