package com.collabpro.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Controlador {

    @GetMapping("/CollabPro")
    public String PaginaPrincipal(){
        return "index";// Esto corresponde a la vista llamada "index.html"
    }

}
