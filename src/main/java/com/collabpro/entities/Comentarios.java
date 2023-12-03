package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comentario_id")
    private int comentariosId;
    @Column(name="contenido")
    private String contenido;
    @Column(name="fecha_creacion")
    private Date fecha_creacion;

    //Relaciones

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyecto;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tareas tarea;


    //Constructores

    public Comentarios() {
    }

    public Comentarios(String contenido, Date fecha_creacion) {
        this.contenido = contenido;
        this.fecha_creacion = fecha_creacion;
    }

    //Getters and Setters

    public int getComentariosId() {
        return comentariosId;
    }
    public void setComentariosId(int comentariosId) {
        this.comentariosId = comentariosId;
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

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }
}
