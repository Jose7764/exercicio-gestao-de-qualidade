package org.example.model;

public class Equipamento {

    private int id;
    private String nome;
    private String numeroDeSerie;
    private String areaSetor;
    private String statusOperacional;

    public Equipamento(int id, String nome, String numeroDeSerie, String areaSetor, String statusOperacional) {
        this.id = id;
        this.nome = nome;
        this.numeroDeSerie = numeroDeSerie;
        this.areaSetor = areaSetor;
        this.statusOperacional = statusOperacional;
    }

    public Equipamento( String nome, String numeroDeSerie, String areaSetor, String statusOperacional) {
        this.nome = nome;
        this.numeroDeSerie = numeroDeSerie;
        this.areaSetor = areaSetor;
        this.statusOperacional = statusOperacional;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public String getAreaSetor() {
        return areaSetor;
    }

    public String getStatusOperacional() {
        return statusOperacional;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public void setAreaSetor(String areaSetor) {
        this.areaSetor = areaSetor;
    }

    public void setStatusOperacional(String statusOperacional) {
        this.statusOperacional = statusOperacional;
    }
}
