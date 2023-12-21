package com.collabpro.controllers;

import com.collabpro.datos.DatosRegistro;
import com.collabpro.entities.Roles;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.RolesRepository;
import com.collabpro.repository.UsuariosRepository;
import com.collabpro.security.JwtGenerator;
import com.collabpro.services.ServiceUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/api/auth/registro")
public class RegistroControlador {

    @ModelAttribute("usuario")
    public Usuarios devolverNuevoUsuario(){
        return new Usuarios();
    }

    @GetMapping
    public String mostrarFormulario(){
        return "registro";
    }

}
