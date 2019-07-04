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
    @Column(name = "state")
    private int state; // Donde 1: espera, 2: aprobado, 3: Rechazado   
    @Column(name = "task")
    private int task; 
    @Column(name = "avance")
    private int avance;
    @Column(name = "boss")
    private int boss;
    @Column(name = "miembro")
    private int miembro;
    @Column(name = "tipo")
    private String tipo; // Externo o interno

    public proyecto() {
        this.state = 1;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMiembro() {
        return miembro;
    }

    public void setMiembro(int miembro) {
        this.miembro = miembro;
    }

    public int getBoss() {
        return boss;
    }

    public void setBoss(int boss) {
        this.boss = boss;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}


