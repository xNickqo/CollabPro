package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tareas")
public class Tareas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="tarea_id")
    private int tareaId;
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



    //Relaciones salientes
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyecto;
    @ManyToOne
    @JoinColumn(name = "asignado_a")
    private Usuarios asignadoA;

    //Relaciones Entrantes
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;

    //Constructores
    public Tareas() {
    }
    public Tareas(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    //Getters y Setters

    public int getIdtareas() {
        return tareaId;
    }

    public void setIdtareas(int idtareas) {
        this.tareaId = tareaId;
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
