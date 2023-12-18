package com.collabpro.services;

import com.collabpro.entities.Proyectos;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.ProyectosRepository;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public boolean autenticarUsuario(String correo, String contraseña) {
        // Buscar al usuario por correo
        Usuarios usuario = usuariosRepository.findByCorreo(correo);
        // Verificar si el usuario existe y si la contraseña coincide
        return usuario != null && usuario.getContraseña().equals(contraseña);
    }


    //INGRESAR USUARIO A LA BBDD
    @Transactional
    public String registrarUsuario(String nombre, String correo, String contraseña){

            // Verificar si los campos requeridos están presentes
            if (nombre == null || correo == null || contraseña == null) {
                return "Todos los campos son obligatorios. Por favor, completa el formulario.";
            }

            try {
                // Verificar si el correo ya está registrado
                if (usuariosRepository.findByCorreo(correo) != null) {
                    System.out.println("Intento de registro con correo duplicado: " + correo);
                    return "El correo ya está registrado. Por favor, utiliza otro correo.";
                }

                // Crear un nuevo usuario
                Usuarios usuario = new Usuarios();
                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                usuario.setContraseña(contraseña);

                // Guardar el usuario en la base de datos
                usuariosRepository.save(usuario);

                return "Registro exitoso. Ahora puedes iniciar sesión.";
            } catch (Exception e) {
                System.out.println("Error al ingresar el usuario: " + e.getMessage());
                return "Correo repetido. Por favor, intenta de nuevo.";
            }
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
