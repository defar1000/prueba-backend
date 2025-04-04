package co.com.prueba.infraestructure.entryPoints.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FranquiciaRequest {
    private String nombre;
    private String nombreSucursal;
}
