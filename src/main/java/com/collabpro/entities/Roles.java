package com.collabpro.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int rolId;
    @Column(name = "nombre")
    private String nombre;


    //Constructores
    public Roles() {
    }
    public Roles(int rolId, String nombre) {
        this.rolId = rolId;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //ToString



}
