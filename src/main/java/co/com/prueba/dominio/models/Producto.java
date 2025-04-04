package co.com.prueba.dominio.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Producto {
    private String nombre;
    private int cantidadStock;
}
