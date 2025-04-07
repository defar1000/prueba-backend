package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.SucursalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class SucursalUseCaseTest {

    SucursalUseCase sucursalUseCase;
    SucursalRepository sucursalRepository;

    @BeforeEach
    void init() {
        sucursalRepository = mock();
        sucursalUseCase = new SucursalUseCase(sucursalRepository);
    }

    @Test
    void agregarProducto() {
        when(sucursalRepository.agregarProducto(anyString(), anyString(), any())).thenReturn(Mono.just(getSucursal()));

        Mono<Sucursal> mono = sucursalUseCase.agregarProducto(anyString(), anyString(), any());

        StepVerifier.create(mono)
                .expectNext(getSucursal())
                .expectComplete()
                .verify();
    }

    @Test
    void eliminarProducto() {
        when(sucursalRepository.eliminarProducto(anyString(), anyString(), anyString())).thenReturn(Mono.just(getSucursal()));

        Mono<Sucursal> mono = sucursalUseCase.eliminarProducto(anyString(), anyString(), anyString());

        StepVerifier.create(mono)
                .expectNext(getSucursal())
                .expectComplete()
                .verify();
    }

    Sucursal getSucursal(){
        return new Sucursal("Sucursal", getProductos());
    }

    Set<Producto> getProductos(){
        String PRODUCTO = "Producto";
        Set<Producto> set = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            set.add(newProducto(PRODUCTO+i,i));
        }
        return set;
    }

    Producto newProducto(String name, int stock){
        return new Producto(name, stock);
    }
}