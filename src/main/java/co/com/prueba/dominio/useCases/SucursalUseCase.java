package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SucursalUseCase {
    private final SucursalRepository sucursalRepository;

    public Mono<Sucursal> agregarProducto(String nombreFranquicia, String nombreSucursal, Producto producto) {
        return sucursalRepository.agregarProducto(nombreFranquicia, nombreSucursal, producto);
    }
    public Mono<Sucursal> eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
        return sucursalRepository.eliminarProducto(nombreFranquicia, nombreSucursal, nombreProducto);
    }
}
