package com.collabpro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controlador {
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola Mundo esto es un metodo GET";
    }
}
