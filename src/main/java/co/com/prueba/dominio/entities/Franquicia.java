package co.com.prueba.dominio.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Franquicia {
    private String nombre;
    private List<Sucursal> sucursales;
}
