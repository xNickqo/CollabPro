package com.collabpro.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuarios> usuarios;

    // Getters y Setters
}
