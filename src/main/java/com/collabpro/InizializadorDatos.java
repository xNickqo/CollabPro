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
        //metodo para agregar usuarios a la base de datos
        //serviceUsuarios.ingresarUsuario("Nicolas", "nikolaslf007@gmail.com","123");


        //metodo crear proyecto
        /*Usuarios liderProyecto = serviceUsuarios.buscarUsuarioPorId(1);
        serviceProyectos.crearProyecto(
                "Proyecto Spring JPA",
                "Es un proyecto en el que se aprende Spring JPA",
                new Date(2023,01,12),
                new Date(2023,06,12),
                liderProyecto );        */

        //Metodo para obtener los proyectos asociados a un usuario
        //serviceUsuarios.obtenerProyectosAsociados(1);
    }
}
