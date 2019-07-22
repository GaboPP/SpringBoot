package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public class proyecto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private int id_proyecto;
    @Column(name = "id_comite", nullable = true)
    private Integer id_comite;
    @Column(name = "id_mentor", nullable = true)
    private Integer id_mentor;
    @Column(name = "id_jefe", nullable = true)
    private Integer id_jefe;
    @Column(name = "nombre_proyecto", nullable = false)
    private String nombre_proyecto;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "state", nullable = false)
    private int state; // Donde 1: espera, 2: aprobado, 3: Rechazado
    @Column(name = "tipo", nullable = false)
    private int tipo; // Externo o interno

    public proyecto() {
        this.state = 1;
        this.tipo = 0;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Integer getId_comite() {
        return id_comite;
    }

    public void setId_comite(Integer id_comite) {
        this.id_comite = id_comite;
    }

    public Integer getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(Integer id_mentor) {
        this.id_mentor = id_mentor;
    }

    public Integer getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(Integer id_jefe) {
        this.id_jefe = id_jefe;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


