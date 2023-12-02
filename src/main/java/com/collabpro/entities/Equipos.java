package com.collabpro.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipos")
    private int idequipos;
    @Column(name = "rol")
    private String rol;


    //Relaciones

    @ManyToOne
    @JoinColumn(name = "idusuarios")
    private Usuarios idusuario;

    @ManyToOne
    @JoinColumn(name = "idproyectos")
    private Proyectos idproyecto;




    //Constructores

    public Equipos() {
    }

    public Equipos(String rol) {
        this.rol = rol;
    }

    //Getters y Setters

    public int getIdequipos() {
        return idequipos;
    }

    public void setIdequipos(int idequipos) {
        this.idequipos = idequipos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
