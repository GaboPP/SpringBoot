package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comite")
public class Comite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comite")
    private int id_comite;
    @Column(name = "Name")
    private String Name;
    @Column(name = "email")
    private String email;    
}