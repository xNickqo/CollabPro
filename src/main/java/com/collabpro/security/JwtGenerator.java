package com.collabpro.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    //Metodo para generar el token
    public String generarToken(Authentication authentication){

        String correo = authentication.getName();

        Date tiempoActual = new Date();
        Date expiracionToken = new Date(tiempoActual.getTime() + ConstantesSeguridad.JWT_EXPIRATION_TOKEN);

        //Linea para generar el token
        String token = Jwts.builder()//Construimos un token JWT llamado token
                .setSubject(correo)//Establecemos el nombre del usuario(en este caso el correo) que esta iniciando sesion
                .setIssuedAt(new Date())//Establecemos la fecha de emision del token
                .setExpiration(expiracionToken)//caducidad del token
                .signWith(SignatureAlgorithm.HS512, ConstantesSeguridad.JWT_FIRMA)//utilizamos este metodo para firmar el token
                .compact();

        return token;
    }

    //Metodo para extraer username a partir de token
    public String obtenerCorreoDeJWT(String token){

        Claims claims = Jwts.parser() //Analizar el token
                .setSigningKey(ConstantesSeguridad.JWT_FIRMA)//Establece la clave de firma
                .parseClaimsJws(token)//Se utiliza para verificar la firma del token
                .getBody();

        return claims.getSubject();
    }


    //Metodo para validar token
    public Boolean validarToken(String token){
        try{
            Jwts.parser().setSigningKey(ConstantesSeguridad.JWT_FIRMA).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            throw new AuthenticationCredentialsNotFoundException("Su sesion ha expirado o es incorrecta");
        }
    }


}
