package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private int id_proyecto;
    @Column(name = "id_comite", nullable = true)
    private int id_comite;
    @Column(name = "id_mentor", nullable = true)
    private int id_mentor;
    @Column(name = "id_jefe", nullable = true)
    private int id_jefe;
    @Column(name = "state", nullable = false)
    private int state; // Donde 1: espera, 2: aprobado, 3: Rechazado
    @Column(name = "tipo", nullable = false)
    private String tipo; // Externo o interno

    public Proyecto() {
        this.state = 1;
    }
}


