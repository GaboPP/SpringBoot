package com.isw.server.models;

import java.io.Serializable;

public class MemberProyectId implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id_proyecto;
    private int id_participante;
    public MemberProyectId(){
    }
    public MemberProyectId(int id_proyecto, int id_participante) {
        this.setId_participante(id_participante);
        this.setId_proyecto(id_proyecto);
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_participante;
        result = prime * result + id_proyecto;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MemberProyectId other = (MemberProyectId) obj;
        if (id_participante != other.id_participante)
            return false;
        if (id_proyecto != other.id_proyecto)
            return false;
        return true;
    }
}