package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tareas")
public class Tareas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idtareas")
    private int idtareas;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="fecha_inicio")
    private Date fecha_inicio;
    @Column(name="fecha_fin")
    private Date fecha_fin;
    @Column(name="estado")
    private String estado;



    //Relaciones
    @ManyToOne
    @JoinColumn(name = "idproyecto")
    private Proyectos idproyecto;

    @ManyToOne
    @JoinColumn(name = "asignado_a")
    private Usuarios asignadoA;

    //Constructores

    public Tareas() {
    }

    public Tareas(int idtareas, String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, String estado) {
        this.idtareas = idtareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    //Getters y Setters

    public int getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(int idtareas) {
        this.idtareas = idtareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
