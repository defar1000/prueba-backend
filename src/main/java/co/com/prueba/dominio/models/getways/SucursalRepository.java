package co.com.prueba.dominio.models.getways;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepository {
    Mono<Sucursal> agregarProducto(String nombreFranquicia, String nombreSucursal, Producto producto);
    Mono<Sucursal> eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto);
}
