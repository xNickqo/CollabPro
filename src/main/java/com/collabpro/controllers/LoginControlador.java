package com.collabpro.controllers;


import com.collabpro.datos.DatosAuthRespuesta;
import com.collabpro.datos.DatosLogin;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/auth/login")
public class LoginControlador {



    @GetMapping()
    public String iniciarSesion() {
        return "login";
    }


}
