package com.collabpro.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="correo")
    private String correo;
    @Column(name="contraseña")
    private String contraseña;


    @OneToMany(mappedBy = "liderProyecto", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Proyectos> proyectosLiderados;

    @OneToMany(mappedBy = "asignadoA", cascade = CascadeType.ALL)
    private List<Tareas> tareasAsignadas;


    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    )
    private List<Roles> roles = new ArrayList<>();



    //Constructores
    public Usuarios() {
    }
    public Usuarios(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    //Getters y Setters

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public List<Proyectos> getProyectosLiderados() {
        return proyectosLiderados;
    }

    public void setProyectosLiderados(List<Proyectos> proyectosLiderados) {
        this.proyectosLiderados = proyectosLiderados;
    }


    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }


    public List<Tareas> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<Tareas> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }


}
