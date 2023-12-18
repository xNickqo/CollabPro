package com.collabpro.repository;

import com.collabpro.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    //Metodo para buscar un rol por su nombre en nuestra BBDD
    Optional<Roles> findByNombre(String nombre);

}
