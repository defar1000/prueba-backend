package co.com.prueba.dominio.models;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Franquicia {
    private String id;
    private String nombre;
    private Set<Sucursal> sucursales;

    public Franquicia actualizarStock(String nombreSucursal, String nombreProducto, int cantidad) {
        Producto producto = getProducto(nombreSucursal, nombreProducto);
        producto.setCantidadStock(cantidad);
        return this;
    }

    public Producto getProducto(String nombreSucursal, String nombreProducto) {
        for (Producto producto: getSucursal(nombreSucursal).getProductosOfertados()) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }
        return Producto.builder().build();
    }

    public Franquicia addProducto(String nombreSucursal, Producto producto) {
        getSucursal(nombreSucursal).getProductosOfertados().add(producto);
        return this;
    }

    public Sucursal getSucursal(String nombreSucursal) {
        for(Sucursal sucursal: sucursales) {
            if (sucursal.getNombre().equals(nombreSucursal)){
                return sucursal;
            }
        }
        return Sucursal.builder().build();
    }

    public Franquicia removeProducto(String nombreSucursal, String nombreProducto) {
        getSucursal(nombreSucursal).getProductosOfertados().remove(Producto.builder().nombre(nombreProducto).build());
        return this;
    }
}
