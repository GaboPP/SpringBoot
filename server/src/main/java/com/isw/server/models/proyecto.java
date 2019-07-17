package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class proyecto{
    @Id
    @GeneratedValue
    @Column(name = "id_proyecto")
    private int id_proyecto;
    @Column(name = "nombre", length = 45) 
  
    private String nombre;
    @Column(name = "id_mentor", nullable = true)
    private Integer id_mentor;
    @Column(name = "id_comite", nullable = true)
    private Integer id_comite;
    @Column(name = "id_jefe", nullable = true)
    private Integer boss;
    @Column(name = "tipo")
    private String tipo; // 0:Externo o  1:interno
    @Column(name = "state")  
    private int state; // Donde 1: espera, 2: aprobado, 3: Rechazado
    @Column(name = "comentario", length = 500) 
    private String comentario;
    @Column(name = "detalle")
    private String detalle;
    
    public proyecto() {
        this.state = 1;
    }
    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(Integer id_mentor) {
        this.id_mentor = id_mentor;
    }

    public Integer getId_comite() {
        return id_comite;
    }

    public void setId_comite(Integer id_comite) {
        this.id_comite = id_comite;
    }

    public Integer getBoss() {
        return boss;
    }
    public void setBoss(Integer boss) {
        this.boss = boss;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}