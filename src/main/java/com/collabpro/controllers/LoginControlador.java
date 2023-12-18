package com.collabpro.controllers;

import com.collabpro.entities.Usuarios;
import com.collabpro.repository.UsuariosRepository;
import com.collabpro.services.ServiceUsuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/collabpro/login")
public class LoginControlador {
    private ServiceUsuarios serviceUsuarios;
    private UsuariosRepository usuariosRepository;

    @Autowired
    public LoginControlador(ServiceUsuarios serviceUsuarios, UsuariosRepository usuariosRepository) {
        this.serviceUsuarios = serviceUsuarios;
        this.usuariosRepository = usuariosRepository;
    }




    @PostMapping
    public String procesarFormularioLogin(
            @RequestParam String correo,
            @RequestParam String contraseña,
            HttpSession session,
            Model model) {

        boolean autenticado = serviceUsuarios.autenticarUsuario(correo, contraseña);

        if (autenticado){
            Usuarios usuario = usuariosRepository.findByCorreo(correo);
            session.setAttribute("usuarioAutenticado", usuario);
            return "redirect:/collabpro/index";
        }else {
            model.addAttribute("error", "Credenciales Incorrectas");
            return "login";
        }

    }


    @GetMapping
    public String verLogin(){
        return "login";
    }
}
