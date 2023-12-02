package com.collabpro.services;

import com.collabpro.repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTareas {

    private final TareasRepository tareasRepository;

    @Autowired
    public ServiceTareas(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }

    //Implementa la logica utilizando el repositorio

}
