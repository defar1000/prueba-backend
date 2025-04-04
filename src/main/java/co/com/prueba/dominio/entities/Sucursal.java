package co.com.prueba.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    private String nombre;
    private List<Producto> productosOfertados;
}
