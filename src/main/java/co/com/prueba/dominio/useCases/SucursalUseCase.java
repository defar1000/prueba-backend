package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.entities.Producto;
import co.com.prueba.dominio.entities.Sucursal;
import co.com.prueba.dominio.entities.getways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SucursalUseCase {
    private final SucursalRepository sucursalRepository;

    Mono<Sucursal> agregarProducto(Producto producto) {
        return sucursalRepository.agregarProducto(producto);
    }
    Mono<Sucursal> eliminarProducto(Producto producto) {
        return sucursalRepository.eliminarProducto(producto);
    }
}
