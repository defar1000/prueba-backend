package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.getways.ProductoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RequiredArgsConstructor
public class ProductoUseCase {
    private final ProductoRepository productoRepository;

    public Mono<Producto> setStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int cantidad) {
        return productoRepository.setStock(nombreFranquicia, nombreSucursal, nombreProducto, cantidad);
    }

    public static Comparator<Producto> mayorStockProductoComparator() {
        return (producto1, producto2) -> producto1.getCantidadStock()>producto2.getCantidadStock() ? 1 : -1;
    }
}
