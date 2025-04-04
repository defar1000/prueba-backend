package co.com.prueba.dominio.models.getways;

import co.com.prueba.dominio.models.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> setStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int cantidad);
}
