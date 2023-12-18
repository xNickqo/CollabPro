package com.collabpro.controllers;

import com.collabpro.entities.Usuarios;
import com.collabpro.repository.UsuariosRepository;
import com.collabpro.services.ServiceUsuarios;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/collabpro/index")
public class Controlador {

    @GetMapping
    public String home(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);

        if (session !=null && session.getAttribute("usuarioAutenticado") != null){
            Usuarios usuario = (Usuarios) session.getAttribute("usuarioAutenticado");
            model.addAttribute("usuarioAutenticado", usuario);
        }

        return "index";
    }



}
