package com.collabpro.services;

import com.collabpro.entities.Proyectos;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.ProyectosRepository;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceProyectos {

    private final ProyectosRepository proyectosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    public ServiceProyectos(ProyectosRepository proyectosRepository) {
        this.proyectosRepository = proyectosRepository;
    }

    //Implementa la logica utilizando el repositorio



    //Este metodo crea un proyecto y lo añade a una lista de proyectos liderados por el usuario el cual ha creado el metodo
    public Proyectos crearProyecto(String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, Usuarios liderProyecto){

        Proyectos proyecto = new Proyectos();

        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setFecha_inicio(fecha_inicio);
        proyecto.setFecha_fin(fecha_fin);
        proyecto.setLiderProyecto(liderProyecto);

        //Añadir proyecto a la lista de proyectos liderados por el usuario
        liderProyecto.getProyectosLiderados().add(proyecto);

        //Guardar el proyecto y actualizar el usuario en la BBDD
        proyectosRepository.save(proyecto);
        usuariosRepository.save(liderProyecto);

        return proyecto;
    }

}
