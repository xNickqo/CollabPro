package com.collabpro.controllers;

import com.collabpro.datos.DatosAuthRespuesta;
import com.collabpro.datos.DatosLogin;
import com.collabpro.datos.DatosRegistro;
import com.collabpro.entities.Roles;
import com.collabpro.entities.Usuarios;
import com.collabpro.repository.RolesRepository;
import com.collabpro.repository.UsuariosRepository;
import com.collabpro.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth/")
public class RestControllerAuth {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private UsuariosRepository usuariosRepository;
    private RolesRepository rolesRepository;
    private JwtGenerator jwtGenerator;

    @Autowired
    public RestControllerAuth(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UsuariosRepository usuariosRepository, RolesRepository rolesRepository, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.usuariosRepository = usuariosRepository;
        this.rolesRepository = rolesRepository;
        this.jwtGenerator = jwtGenerator;
    }


    //Metodo para poder registrar usuarios con rol USER
    @PostMapping("registro")
    public ResponseEntity<String> registro(@RequestBody DatosRegistro datosRegistro){
        if (usuariosRepository.existsByCorreo(datosRegistro.getCorreo())){
            return new ResponseEntity<>("El correo ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }
        Usuarios usuarios = new Usuarios();

        usuarios.setNombre(datosRegistro.getNombre());
        usuarios.setCorreo(datosRegistro.getCorreo());
        usuarios.setContraseña(passwordEncoder.encode(datosRegistro.getContraseña()));

        Roles roles = rolesRepository.findByNombre("USER").get();

        usuarios.setRoles(Collections.singletonList(roles));

        usuariosRepository.save(usuarios);

        return new ResponseEntity<>("Registro de usuario exitoso", HttpStatus.OK);
    }

    //ADMIN
    @PostMapping("registroAdmin")
    public ResponseEntity<String> registroAdmin(@RequestBody DatosRegistro datosRegistro){
        if (usuariosRepository.existsByCorreo(datosRegistro.getCorreo())){
            return new ResponseEntity<>("El correo ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }
        Usuarios usuarios = new Usuarios();
        usuarios.setCorreo(datosRegistro.getCorreo());
        usuarios.setContraseña(passwordEncoder.encode(datosRegistro.getContraseña()));
        Roles roles = rolesRepository.findByNombre("ADMIN").get();
        usuarios.setRoles(Collections.singletonList(roles));
        usuariosRepository.save(usuarios);
        return new ResponseEntity<>("Registro de usuario ADMIN exitoso", HttpStatus.OK);
    }

    //Metodo para poder loggear un usuario y obtener un token
    @PostMapping("login")
    public ResponseEntity<DatosAuthRespuesta> login(@RequestBody DatosLogin datosLogin){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                datosLogin.getCorreo(), datosLogin.getContraseña()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generarToken(authentication);

        return new ResponseEntity<>(new DatosAuthRespuesta(token), HttpStatus.OK);
    }

}
