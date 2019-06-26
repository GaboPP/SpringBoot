package com.isw.server.models;

public class supervisor {
    private int id_supervisor;
    public int proyecto;
    public int permisos; // 0: nulos, 1: básicos, 2:Jefe proyecto, 3: Mentor, 4: Supervisor
    public int reunion;
    public String nombre;
    private String password;    
}