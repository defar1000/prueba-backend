package co.com.prueba.dominio.entities.getways;

import co.com.prueba.dominio.entities.Producto;
import co.com.prueba.dominio.entities.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepository {
    Mono<Sucursal> agregarProducto(Producto producto);
    Mono<Sucursal> eliminarProducto(Producto producto);
}
