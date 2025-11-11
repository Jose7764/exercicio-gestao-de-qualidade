package org.example.model;

import java.util.Date;

public class Falha {

    private int id;
    private int equipamentoId;
    private Date dataHoraOcorrencia;
    private String descircao;
    private String criticidade;
    private String status;
    private double tempoParadaHoras;

    public Falha(int id, int equipamentoId, Date dataHoraOcorrencia, String descircao, String criticidade, String status, double tempoParadaHoras) {
        this.id = id;
        this.equipamentoId = equipamentoId;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
        this.descircao = descircao;
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

    public Date getDataHoraOcorrencia() {
        return dataHoraOcorrencia;
    }

    public void setDataHoraOcorrencia(Date dataHoraOcorrencia) {
        this.dataHoraOcorrencia = dataHoraOcorrencia;
    }

    public String getDescircao() {
        return descircao;
    }

    public void setDescircao(String descircao) {
        this.descircao = descircao;
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
}
