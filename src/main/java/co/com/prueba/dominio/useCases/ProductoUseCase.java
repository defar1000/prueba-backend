package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.entities.Producto;
import co.com.prueba.dominio.entities.getways.ProductoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@RequiredArgsConstructor
public class ProductoUseCase {
    private final ProductoRepository productoRepository;

    public Mono<Producto> setStock(int cantidad) {
        return productoRepository.setStock(cantidad);
    }

    public static Comparator<Producto> mayorStockProductoComparator() {
        return (producto1, producto2) -> producto1.getCantidadStock()>producto2.getCantidadStock() ? 1 : -1;
    }
}
