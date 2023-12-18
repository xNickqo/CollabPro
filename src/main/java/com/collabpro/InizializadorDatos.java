package com.collabpro;

import com.collabpro.entities.Usuarios;
import com.collabpro.services.ServiceProyectos;
import com.collabpro.services.ServiceUsuarios;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InizializadorDatos implements CommandLineRunner {
    private final ServiceUsuarios serviceUsuarios;
    private final ServiceProyectos serviceProyectos;
    public InizializadorDatos(ServiceUsuarios serviceUsuarios, ServiceProyectos serviceProyectos) {
        this.serviceUsuarios = serviceUsuarios;
        this.serviceProyectos = serviceProyectos;
    }

    @Override
    public void run(String... args) throws Exception {
        //ELIMINAR USUARIO
        //serviceUsuarios.eliminarUsuario(3);


        //AGREGAR USUARIO
        /*Usuarios usuario = new Usuarios();
        usuario.setNombre("carmen");
        usuario.setCorreo("carmensita@gmail.com");
        usuario.setContraseña("123");
        serviceUsuarios.ingresarUsuario(usuario);*/

        //CREAR PROYECTO
        /*Usuarios liderProyecto = serviceUsuarios.buscarUsuarioPorId(5);
        serviceProyectos.crearProyecto(
                "Proyecto Manolo",
                "Proyecto personal del SR Manolo",
                new Date(2023,01,12),
                new Date(2023,06,12),
                liderProyecto );*/


        //ELIMINAR PROYECTO
        //serviceProyectos.eliminarProyecto(8);


        //PROYECTOS ASOCIADOS A UN USUARIO POR SU ID
        //serviceUsuarios.obtenerProyectosAsociados(1);
    }
}
