package com.collabpro.services;

import com.collabpro.entities.Proyectos;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.ProyectosRepository;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuarios{

    private final UsuariosRepository usuariosRepository;
    private final ProyectosRepository proyectosRepository;
    @Autowired
    public ServiceUsuarios(UsuariosRepository usuariosRepository, ProyectosRepository proyectosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.proyectosRepository = proyectosRepository;
    }

    //INGRESAR USUARIO A LA BBDD
    public void ingresarUsuario(String nombre, String correo, String contraseña){
        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContraseña(contraseña);

        try {
            usuariosRepository.save(usuario);
            System.out.println("Usuario ingresado: " + usuario.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al ingresar el usuario: " + e.getMessage());
        }
    }

    //GUARDAR USUARIO
    public Usuarios guardarUsuario(Usuarios usuario){
        usuario.getNombre();
        usuario.getCorreo();
        usuario.getContraseña();

        return usuariosRepository.save(usuario);
    }

    //OBTENER PROYECTOS ASOCIADOS A UN USUARIO(IDUSUARIO)
    public List<Proyectos> obtenerProyectosAsociados(int idUsuario) {
        // Obtener el usuario por ID
        Usuarios usuario = usuariosRepository.findById(idUsuario);
        System.out.println("El usuario con ID "+ idUsuario +" es "+usuario.getNombre());
        if (usuario != null) {
            // Asegurarse de que la colección esté cargada
            usuario.getProyectosLiderados().size();

            // Obtener y devolver la lista de proyectos asociados al usuario
            List<Proyectos> proyectosAsociados = usuario.getProyectosLiderados();
            System.out.println("Lista Obtenida"+proyectosAsociados.toString());
            return proyectosAsociados;
        } else {
            // Manejar el caso en el que el usuario no existe
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + idUsuario);
        }
    }


    //Este metodo es para buscar objetos usuario por ID
    public Usuarios buscarUsuarioPorId(int usuarioId){
        return usuariosRepository.findById(usuarioId);
    }



    //ELIMINAR USUARIO
    public void eliminarUsuario(int usuarioId){
        Usuarios usuario = usuariosRepository.findById(usuarioId);

        try {
            if (usuario!=null) {
                usuario.getProyectosLiderados().forEach(proyectosRepository::delete);
                usuariosRepository.delete(usuario);
                System.out.println("Usuario eliminado: " + usuario.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }



}
