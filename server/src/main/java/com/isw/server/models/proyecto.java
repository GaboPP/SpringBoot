package com.isw.server.models;

public class proyecto{
    private int id_proyecto;
    public int state; // Donde 1: espera, 2: aprobado, 3: Rechazado
    public int task;
    public int avance;
    public int boss;
    public int miembro;
    public String tipo; // Externo o interno
}