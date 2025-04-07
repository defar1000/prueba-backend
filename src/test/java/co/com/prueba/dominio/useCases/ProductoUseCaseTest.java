package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.getways.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class ProductoUseCaseTest {

    ProductoUseCase productoUseCase;
    ProductoRepository productoRepository;

    @BeforeEach
    void init() {
        productoRepository = mock();
        productoUseCase = new ProductoUseCase(productoRepository);
    }

    @Test
    void setStock() {
        when(productoRepository.setStock(anyString(), anyString(), anyString(), anyInt())).thenReturn(Mono.just(getProducto()));

        Mono<Producto> mono = productoUseCase.setStock(anyString(), anyString(), anyString(), anyInt());

        StepVerifier.create(mono)
                .expectNext(getProducto())
                .expectComplete()
                .verify();
    }

    Producto getProducto(){
        return new Producto("Producto", 10);
    }
}