package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcomentarios")
    private int idcomentarios;
    @Column(name="contenido")
    private String contenido;
    @Column(name="fecha_creacion")
    private Date fecha_creacion;

    //Relaciones

    @ManyToOne
    @JoinColumn(name = "idusuarios")
    private Usuarios idusuarios;

    @ManyToOne
    @JoinColumn(name = "idproyectos")
    private Proyectos idproyectos;

    @ManyToOne
    @JoinColumn(name = "idtareas")
    private Tareas idtareas;


    //Constructores

    public Comentarios() {
    }

    public Comentarios(int idcomentarios, String contenido, Date fecha_creacion) {
        this.idcomentarios = idcomentarios;
        this.contenido = contenido;
        this.fecha_creacion = fecha_creacion;
    }

    //Getters and Setters

    public int getIdcomentarios() {
        return idcomentarios;
    }

    public void setIdcomentarios(int idcomentarios) {
        this.idcomentarios = idcomentarios;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
