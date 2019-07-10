package com.isw.server.models;

import java.io.Serializable;

public class MemberProyectId implements Serializable{
    private int id_proyecto;
    private int id_participante;

    public MemberProyectId(int id_proyecto, int id_participante){
        this.id_participante = id_participante;
        this.id_proyecto = id_proyecto;
    }
}