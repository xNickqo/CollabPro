package com.collabpro.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

//La funcion de esta clase sera validar la informacion del token y si esta es exitosa establecera la autenticacion de un usuario en la solicitud
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtGenerator jwtGenerator;



    private String obtenerTokenDeSolicitud(HttpServletRequest request){

        String bearerToken = request.getHeader("Autorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            //Aca se encuentra el token JWT, se devuelve una subcadena de "bearerToken" que comienza despues de los primeros 7 caracteres hasta el dinal de la cadena
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

    @Override                   //Solicitud entrante
    protected void doFilterInternal(HttpServletRequest request,
                                    //Respuesta saliente
                                    HttpServletResponse response,
                                    //Mecanismo para invocar el siguiente filtro en la siguiente cadena de filtros
                                    FilterChain filterChain) throws ServletException, IOException {
        //Obtenemos los datos del token
        String token = obtenerTokenDeSolicitud(request);
        //Validamos la informacion del token
        if(StringUtils.hasText(token) && jwtGenerator.validarToken(token)){
            //Asignamos el correo contenido en el objeto token y lo pasamos a nuestra variable "correo"
            String correo = jwtGenerator.obtenerCorreoDeJWT(token);
            //Creamos el objeto userdetais el cual conendra todos los detalles dde nuestro correo, pw y roles segun el metodo nombrado
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(correo);
            //Cargamos una lista con los roles de nuestra BD
            List<String> userRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

            //Validar si esta lista tiene los siguientes roles
            if (userRoles.contains("USER") || userRoles.contains("ADMIN")){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request,response);

    }
}
