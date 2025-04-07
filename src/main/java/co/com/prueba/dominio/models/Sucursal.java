package co.com.prueba.dominio.models;

import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {
    private String nombre;
    private Set<Producto> productosOfertados;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sucursal sucursal)) return false;
        return sucursal.getNombre().equals(this.nombre);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(nombre);
        return result;
    }
}
