package com.collabpro.services;

import com.collabpro.entities.Proyectos;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.ProyectosRepository;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class ServiceProyectos {
    private final ProyectosRepository proyectosRepository;
    private final UsuariosRepository usuariosRepository;

    @Autowired
    public ServiceProyectos(ProyectosRepository proyectosRepository, UsuariosRepository usuariosRepository) {
        this.proyectosRepository = proyectosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    //CREA UN PROYECTO NUEVO y lo añade a una lista de proyectos liderados por el usuario el cual ha creado el metodo
    public Proyectos crearProyecto(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, Usuarios liderProyecto){

        Proyectos proyecto = new Proyectos();

        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setFecha_inicio(fecha_inicio);
        proyecto.setFecha_fin(fecha_fin);
        proyecto.setLiderProyecto(liderProyecto);

        //Añadir proyecto a la lista de proyectos liderados por el usuario
        liderProyecto.getProyectosLiderados().add(proyecto);
        System.out.println(liderProyecto.getProyectosLiderados());

        //Guardar el proyecto y actualizar el usuario en la BBDD
        proyectosRepository.save(proyecto);
        usuariosRepository.save(liderProyecto);

        return proyecto;
    }

    //ELIMINAR UN PROYECTO
    @Transactional
    public void eliminarProyecto(int proyectoId) {
        try {
            Optional<Proyectos> proyectoOptional = proyectosRepository.findById(proyectoId);

            if (proyectoOptional.isPresent()) {
                Proyectos proyecto = proyectoOptional.get();

                //Elimina el proyecto de la lista de Proyectos Liderados
                Usuarios liderProyecto = proyecto.getLiderProyecto();
                if (liderProyecto != null) {
                    liderProyecto.getProyectosLiderados().remove(proyecto);
                    usuariosRepository.save(liderProyecto);
                }

                proyectosRepository.deleteById(proyectoId);
                System.out.println("Proyecto eliminado con éxito: " + proyecto.getNombre());
            } else {
                System.out.println("No se encontró el proyecto con ID: " + proyectoId);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el Proyecto: " + e.getMessage());
        }
    }


}
