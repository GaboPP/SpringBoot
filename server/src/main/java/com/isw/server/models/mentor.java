package com.isw.server.models;



public class mentor {
    private int mentor_id;
    public int proyecto;
    public String nombre;
    public int permisos; // 0: nulos, 1: básicos, 2:Jefe proyecto, 3: Mentor, 4: Supervisor
    private String password;    
}