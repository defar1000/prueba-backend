package co.com.prueba.dominio.entities.getways;

import co.com.prueba.dominio.entities.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> setStock(int cantidad);
}
