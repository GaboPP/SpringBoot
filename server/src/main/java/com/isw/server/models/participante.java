package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class participante {
    @Id
    @GeneratedValue
    @Column(name = "id_participante")
    public int id_participante;
    @Column(name = "Name", length = 200) 
    public String Name;
    @Column(name = "email") 
    public String email;
    @Column(name = "permisos")     
    public int permisos; // 0: nulos, 1: básicos, 2:Jefe proyecto, 3: Mentor, 4: Supervisor

    public participante() {
        
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }
}