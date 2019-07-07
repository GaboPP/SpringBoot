package com.isw.server.models;

import java.io.Serializable;

public class MemberProyectId implements Serializable{
    private int id_proyecto;
    private int id_participante;

    public MemberProyectId(int id_proyecto, int id_participante) {
        this.setId_participante(id_participante);
        this.setId_proyecto(id_proyecto);
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }
}