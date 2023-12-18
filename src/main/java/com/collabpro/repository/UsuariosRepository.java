package com.collabpro.repository;

import com.collabpro.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findById(int usuarioId);
    Usuarios findByCorreo(String correo);
}
