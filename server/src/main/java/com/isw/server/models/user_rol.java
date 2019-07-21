package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user_rol{
    @Id
    @Column(name = "iduser_rol")
    private int iduser_rol;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "id_participante")
    private int id_participante;
    @Column(name = "id_mentor")
    private int id_mentor;
    @Column(name = "id_supervisor")
    private int id_supervisor;
    @Column(name = "rol_name")
    private String rol_name;

    public int getIduser_rol() {
        return iduser_rol;
    }

    public void setIduser_rol(int iduser_rol) {
        this.iduser_rol = iduser_rol;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public int getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(int id_mentor) {
        this.id_mentor = id_mentor;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }
}