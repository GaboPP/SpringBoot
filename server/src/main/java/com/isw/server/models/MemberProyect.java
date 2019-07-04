package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_proyect")
public class MemberProyect{
    @Id
    @Column(name = "id_proyecto")
    private int id_proyecto;
    @Id
    @Column(name = "id_participante")
    private int id_participante;
    @Column(name = "jefe")
    private int jefe;
}