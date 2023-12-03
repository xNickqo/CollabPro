package com.collabpro.repository;

import com.collabpro.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByNombre(String nombre);
    Usuarios findById(int usuarioId);
}
