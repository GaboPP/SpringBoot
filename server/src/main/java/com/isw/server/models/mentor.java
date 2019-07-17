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
  
    public int getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(int id_mentor) {
        this.id_mentor = id_mentor;
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

    public String getExperticia() {
        return experticia;
    }

    public void setExperticia(String experticia) {
        this.experticia = experticia;
    }
}