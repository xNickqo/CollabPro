package com.collabpro.repository;

import com.collabpro.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Integer> {
}
