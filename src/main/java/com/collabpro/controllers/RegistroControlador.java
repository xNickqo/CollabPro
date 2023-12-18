package com.collabpro.controllers;

import com.collabpro.entities.Usuarios;
import com.collabpro.repository.UsuariosRepository;
import com.collabpro.services.ServiceUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collabpro/registro")
public class RegistroControlador {

    @Autowired
    private ServiceUsuarios serviceUsuarios;

    @PostMapping
    public String procesarFormulario(@RequestParam String nombre,
                                     @RequestParam String correo,
                                     @RequestParam String contraseña,
                                     Model model){

        String mensaje = serviceUsuarios.registrarUsuario(nombre, correo, contraseña);

        model.addAttribute("mensaje", mensaje);

        return "registro";
    }

    @GetMapping
    public String verRegistro(){
        return "registro";
    }


}
