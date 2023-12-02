package com.collabpro.services;

import com.collabpro.repository.EquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEquipos {

    private final EquiposRepository equiposRepository;

    @Autowired
    public ServiceEquipos(EquiposRepository equiposRepository) {
        this.equiposRepository = equiposRepository;
    }

    //Implementa la logica utilizando el repositorio

}


