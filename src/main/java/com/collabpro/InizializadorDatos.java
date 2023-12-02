package com.collabpro;

import com.collabpro.services.ServiceUsuarios;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InizializadorDatos implements CommandLineRunner {

    private final ServiceUsuarios serviceUsuarios;

    public InizializadorDatos(ServiceUsuarios serviceUsuarios) {
        this.serviceUsuarios = serviceUsuarios;
    }

    @Override
    public void run(String... args) throws Exception {
        serviceUsuarios.ingresarUsuario("Nicolas", "nikolaslf007@gmail.com","123");
    }
}
