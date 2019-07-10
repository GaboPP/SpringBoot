package com.isw.server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mentor")
    private int id_mentor;
    @Column(name = "Name")
    private String Name;
    @Column(name = "email")
    private String email;
    @Column(name = "experticia")
    public String experticia;
}