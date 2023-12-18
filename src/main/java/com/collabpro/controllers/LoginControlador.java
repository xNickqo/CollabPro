package com.collabpro.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class LoginControlador {

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/collabpro")
    public String paginaPrincipal() {

        return "redirect:/login";

    }
}
