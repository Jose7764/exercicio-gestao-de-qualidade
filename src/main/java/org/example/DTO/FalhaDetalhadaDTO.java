package org.example.DTO;

import java.util.Date;

public class FalhaDetalhadaDTO {

    private int equipamentoID;
    private Date dataHoraOcorrencia;
    private String descricao;
    private String criticidade;
    private String status;
    private double tempopParadaHoras;

    public FalhaDetalhadaDTO(int equipamentoID, Date dataHoraOcorrencia, String descricao, String criticidade, String status, double tempopParadaHoras) {
        this.equipamentoID = equipamentoID;
        this.dataHoraOcorrencia = dataHoraOcorrencia;
        this.descricao = descricao;
        this.criticidade = criticidade;
        this.status = status;
        this.tempopParadaHoras = tempopParadaHoras;
    }

    public int getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(int equipamentoID) {
        this.equipamentoID = equipamentoID;
    }

    public Date getDataHoraOcorrencia() {
        return dataHoraOcorrencia;
    }

    public void setDataHoraOcorrencia(Date dataHoraOcorrencia) {
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

    public double getTempopParadaHoras() {
        return tempopParadaHoras;
    }

    public void setTempopParadaHoras(double tempopParadaHoras) {
        this.tempopParadaHoras = tempopParadaHoras;
    }

    @Override
    public String toString() {
        return "FalhaDetalhadaDTO{" +
                "equipamentoID=" + equipamentoID +
                ", dataHoraOcorrencia=" + dataHoraOcorrencia +
                ", descricao='" + descricao + '\'' +
                ", criticidade='" + criticidade + '\'' +
                ", status='" + status + '\'' +
                ", tempopParadaHoras=" + tempopParadaHoras +
                '}';
    }
}