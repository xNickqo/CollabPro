package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="proyectos")
public class Proyectos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idproyectos")
    private int idproyectos;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="fecha_inicio")
    private Date fecha_inicio;
    @Column(name="fecha_fin")
    private Date fecha_fin;


    //Relaciones
    @ManyToOne
    @JoinColumn(name = "lider_proyecto_id")
    private Usuarios liderProyecto;

    @OneToMany(mappedBy = "proyecto")
    private List<Tareas> tareas;

    //Constructores
    public Proyectos(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;

    }
    public Proyectos() {
    }

    //Getters y setters

    public int getIdproyectos() {
        return idproyectos;
    }

    public void setIdproyectos(int idproyectos) {
        this.idproyectos = idproyectos;
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


    public Usuarios getLiderProyecto() {
        return liderProyecto;
    }

    public void setLiderProyecto(Usuarios liderProyecto) {
        this.liderProyecto = liderProyecto;
    }
}
