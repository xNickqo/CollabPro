package com.collabpro.security;

import com.collabpro.entities.Roles;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsuariosRepository usuariosRepository;

    @Autowired
    public CustomUserDetailsService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    //Metodo para traernos una lista de autoridades por medio de una lista de roles
    public Collection<GrantedAuthority> mapToAutorities(List<Roles> roles ){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }

    //Metodo para traer un usuario con todos sus datos por medio de su correo
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        Usuarios usuario = usuariosRepository.findByCorreo(correo).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));

        return new User(usuario.getNombre(), usuario.getContraseña(), mapToAutorities(usuario.getRoles()) );
    }
}
