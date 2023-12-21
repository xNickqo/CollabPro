package com.collabpro.datos;

import lombok.Data;

//Esta clase devuelve la informacion con el token y el tipo que tenga este
@Data
public class DatosAuthRespuesta {
    private String accessToken;
    private String tokenType = "Bearer ";

    public DatosAuthRespuesta(String accessToken){
        this.accessToken = accessToken;
    }
}
