package org.example.model;

import java.time.LocalDateTime;
import java.util.Date;

public class AcaoCorretiva {

    private int id;
    private int falhaId;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private String responsavel;
    private String descricaoAcao;

    public AcaoCorretiva(int id, int falhaId, Date dataHoraInicio, Date dataHoraFim, String responsavel, String descricaoAcao) {
        this.id = id;
        this.falhaId = falhaId;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.responsavel = responsavel;
        this.descricaoAcao = descricaoAcao;
    }

    public AcaoCorretiva(Long falhaId, LocalDateTime now, LocalDateTime now1, String tecnicoX, String trocaDePeça) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFalhaId() {
        return falhaId;
    }

    public void setFalhaId(int falhaId) {
        this.falhaId = falhaId;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
    }
}
