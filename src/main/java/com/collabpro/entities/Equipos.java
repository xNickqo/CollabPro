package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipo_id")
    private int equipoId;
    @Column(name = "rol")
    private String rol;


    //Relaciones

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyecto;




    //Constructores


    public Equipos() {
    }

    public Equipos(String rol, Usuarios usuario, Proyectos proyecto) {
        this.rol = rol;
        this.usuario = usuario;
        this.proyecto = proyecto;
    }


    //Getters y Setters

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Proyectos getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }
}
