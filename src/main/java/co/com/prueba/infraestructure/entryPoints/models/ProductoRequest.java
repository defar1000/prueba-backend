package co.com.prueba.infraestructure.entryPoints.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {
    private String nombreFranquicia;
    private String nombreSucursal;
    private String nombreProducto;
    private int cantidad;
}
