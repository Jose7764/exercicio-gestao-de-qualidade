package org.example.DTO;

public class RelatorioParadaDTO {

    private int falhaID;
    private int equipamentoID;
    private double tempoParadaHoras;

    public RelatorioParadaDTO(int falhaID, int equipamentoID, double tempoParadaHoras) {
        this.falhaID = falhaID;
        this.equipamentoID = equipamentoID;
        this.tempoParadaHoras = tempoParadaHoras;
    }

    public int getFalhaID() {
        return falhaID;
    }

    public void setFalhaID(int falhaID) {
        this.falhaID = falhaID;
    }

    public int getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(int equipamentoID) {
        this.equipamentoID = equipamentoID;
    }

    public double getTempoParadaHoras() {
        return tempoParadaHoras;
    }

    public void setTempoParadaHoras(double tempoParadaHoras) {
        this.tempoParadaHoras = tempoParadaHoras;
    }

    @Override
    public String toString() {
        return "RelatorioParadaDTO{" +
                "falhaID=" + falhaID +
                ", equipamentoID=" + equipamentoID +
                ", tempoParadaHoras=" + tempoParadaHoras +
                '}';
    }
}

