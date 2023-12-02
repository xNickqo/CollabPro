package com.collabpro.repository;

import com.collabpro.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepository extends JpaRepository<Tareas, Integer> {
}
