package co.com.prueba.dominio.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Sucursal {
    private String nombre;
    private List<Producto> productosOfertados;
}
