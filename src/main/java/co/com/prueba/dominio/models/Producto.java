package co.com.prueba.dominio.models;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private String nombre;
    private int cantidadStock;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto producto = (Producto) obj;
        return producto.getNombre().equals(this.nombre);
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + Objects.hashCode(this.nombre);
        return result;
    }
}
