package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.entities.Franquicia;
import co.com.prueba.dominio.entities.Producto;
import co.com.prueba.dominio.entities.Sucursal;
import co.com.prueba.dominio.entities.getways.FranquiciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        when(franquiciaRepository.nuevaSucursal(any())).thenReturn(Mono.just(getFranquicia()));

        Mono<Franquicia> mono = franquiciaUseCase.nuevaSucursal(any());

        StepVerifier.create(mono)
                .expectNext(getFranquicia())
                .expectComplete()
                .verify();
    }

    @Test
    void mayorStockEnSucursalesByFranquicia() {
        when(franquiciaRepository.getFranquicia(any())).thenReturn(Mono.just(getFranquicia()));

        Mono<Map<String, Producto>> mono = franquiciaUseCase.mayorStockEnSucursalesByFranquicia(getFranquicia());

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

    List<Sucursal> getSucursales(){
        String SUCURSAL = "Sucursal";
        List<Sucursal> lista = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            lista.add(newSucursal(SUCURSAL+i));
        }
        return lista;
    }

    Sucursal newSucursal(String name){
        return new Sucursal(name, getProductos());
    }

    List<Producto> getProductos(){
        String PRODUCTO = "Producto";
        List<Producto> lista = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(newProducto(PRODUCTO+i,i));
        }
        return lista;
    }

    Producto newProducto(String name, int stock){
        return new Producto(name, stock);
    }
}