package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "member_proyect")
@IdClass(MemberProyectId.class)
public class MemberProyect{
    @Id
    @Column(name = "id_proyecto")
    private int id_proyecto;
    @Id
    @Column(name = "id_participante")
    private int id_participante;
    @Column(name = "jefe")
    private int jefe;
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

    public int getJefe() {
        return jefe;
    }

    public void setJefe(int jefe) {
        this.jefe = jefe;
    }
}