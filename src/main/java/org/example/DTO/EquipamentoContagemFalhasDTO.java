package org.example.DTO;

public class EquipamentoContagemFalhasDTO {

    private int equipamentoID;
    private int quantidadeFalhas;

    public EquipamentoContagemFalhasDTO(int equipamentoID, int quantidadeFalhas) {
        this.equipamentoID = equipamentoID;
        this.quantidadeFalhas = quantidadeFalhas;
    }

    public int getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(int equipamentoID) {
        this.equipamentoID = equipamentoID;
    }

    public int getQuantidadeFalhas() {
        return quantidadeFalhas;
    }

    public void setQuantidadeFalhas(int quantidadeFalhas) {
        this.quantidadeFalhas = quantidadeFalhas;
    }

    @Override
    public String toString() {
        return "EquipamentoContagemFalhasDTO{" +
                "equipamentoID=" + equipamentoID +
                ", quantidadeFalhas=" + quantidadeFalhas +
                '}';
    }
}