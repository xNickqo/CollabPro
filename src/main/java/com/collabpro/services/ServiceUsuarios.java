package com.collabpro.services;

import com.collabpro.entities.Usuarios;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarios {

    private final UsuariosRepository usuariosRepository;
    @Autowired
    public ServiceUsuarios(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    //Implementa la logica utilizando el repositorio


    //Este metodo ingresa un usuario a la base de datos
    public void ingresarUsuario(String nombre, String correo, String contraseña){
        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);

        usuariosRepository.save(usuario);
        try {
            usuariosRepository.save(usuario);
            System.out.println("Usuario ingresado: " + usuario.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al ingresar el usuario: " + e.getMessage());
        }
    }
}
