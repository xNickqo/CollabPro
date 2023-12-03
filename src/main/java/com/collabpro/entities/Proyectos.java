package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="proyectos")
public class Proyectos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="proyecto_id")
    private int proyectoId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="fecha_inicio")
    private Date fecha_inicio;
    @Column(name="fecha_fin")
    private Date fecha_fin;


    //Relaciones salientes
    @ManyToOne
    @JoinColumn(name = "lider_proyecto_id")
    private Usuarios liderProyecto;


    //Relaciones entrantes
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Tareas> tareas;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;


    //Constructores
    public Proyectos(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;

    }
    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, Usuarios liderProyecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.liderProyecto = liderProyecto;
    }

    //Getters y setters


    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
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

    public List<Tareas> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tareas> tareas) {
        this.tareas = tareas;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }


    //ToString

    @Override
    public String toString() {
        return "Proyectos{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", liderProyecto=" + liderProyecto +
                '}';
    }
}
