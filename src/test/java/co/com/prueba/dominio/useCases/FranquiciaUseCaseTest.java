package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Franquicia;
import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.FranquiciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.*;

import static org.mockito.Mockito.*;

class FranquiciaUseCaseTest {

    FranquiciaUseCase franquiciaUseCase;
    FranquiciaRepository franquiciaRepository;

    @BeforeEach
    void init() {
        franquiciaRepository = mock();
        franquiciaUseCase = new FranquiciaUseCase(franquiciaRepository);
    }

    @Test
    void crearFranquicia() {
        when(franquiciaRepository.crearFranquicia(any())).thenReturn(Mono.just(getFranquicia()));

        Mono<Franquicia> mono = franquiciaUseCase.crearFranquicia(anyString());

        StepVerifier.create(mono)
                .expectNext(getFranquicia())
                .expectComplete()
                .verify();
    }

    @Test
    void nuevaSucursal() {
        when(franquiciaRepository.nuevaSucursal(anyString(), any())).thenReturn(Mono.just(getFranquicia()));

        Mono<Franquicia> mono = franquiciaUseCase.nuevaSucursal(anyString(), any());

        StepVerifier.create(mono)
                .expectNext(getFranquicia())
                .expectComplete()
                .verify();
    }

    @Test
    void mayorStockEnSucursalesByFranquicia() {
        when(franquiciaRepository.getFranquicia(any())).thenReturn(Mono.just(getFranquicia()));

        Mono<Map<String, Producto>> mono = franquiciaUseCase.mayorStockEnSucursalesByFranquicia(anyString());

        StepVerifier.create(mono)
                .expectNext(getMapaConMayorStock())
                .expectComplete()
                .verify();
    }

    Map<String, Producto> getMapaConMayorStock(){
        Map<String, Producto> mapa = new HashMap<>();
        String SUCURSAL = "Sucursal";
        for (int i = 1; i <= 5; i++) {
            mapa.put(SUCURSAL+i, newProducto("Producto10", 10));
        }
        return mapa;
    }

    Franquicia getFranquicia(){
        return Franquicia.builder()
                .nombre("Franquicia")
                .sucursales(getSucursales())
                .build();
    }

    Set<Sucursal> getSucursales(){
        String SUCURSAL = "Sucursal";
        Set<Sucursal> lista = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            lista.add(newSucursal(SUCURSAL+i));
        }
        return lista;
    }

    Sucursal newSucursal(String name){
        return new Sucursal(name, getProductos());
    }

    Set<Producto> getProductos(){
        String PRODUCTO = "Producto";
        Set<Producto> lista = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(newProducto(PRODUCTO+i,i));
        }
        return lista;
    }

    Producto newProducto(String name, int stock){
        return new Producto(name, stock);
    }
}