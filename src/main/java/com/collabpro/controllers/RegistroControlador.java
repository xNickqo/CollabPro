package com.collabpro.controllers;

import com.collabpro.entities.Usuarios;
import com.collabpro.services.ServiceUsuarios;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroControlador {
    private ServiceUsuarios usuarioServicio;
    private PasswordEncoder passwordEncoder;
    public RegistroControlador(ServiceUsuarios usuarioServicio, PasswordEncoder passwordEncoder) {
        this.usuarioServicio = usuarioServicio;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("usuario")
    public Usuarios devolverNuevoUsuario(){

        return new Usuarios();
    }

    @GetMapping
    public String mostrarFormulario(){

        return "registro";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") Usuarios usuario){
        //Encriptar la contraseña antes de guardarla
        String contraseñaEncriptada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contraseñaEncriptada);

        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/registro?exito";
    }

}
