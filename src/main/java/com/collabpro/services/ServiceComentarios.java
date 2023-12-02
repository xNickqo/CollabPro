package com.collabpro.services;

import com.collabpro.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceComentarios {

    private final ComentariosRepository comentariosRepository;

    @Autowired
    public ServiceComentarios(ComentariosRepository comentariosRepository) {
        this.comentariosRepository = comentariosRepository;
    }

    //Implementa la logica utilizando el repositorio



}