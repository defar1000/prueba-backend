package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.entities.Franquicia;
import co.com.prueba.dominio.entities.Producto;
import co.com.prueba.dominio.entities.Sucursal;
import co.com.prueba.dominio.entities.getways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class FranquiciaUseCase {
    private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> crearFranquicia(String nombre) {
        return franquiciaRepository.crearFranquicia(nombre);
    }
    public Mono<Franquicia> nuevaSucursal(Sucursal sucursal) {
        return franquiciaRepository.nuevaSucursal(sucursal);
    }

    public Mono<Map<String, Producto>> mayorStockEnSucursalesByFranquicia(Franquicia franquicia) {
        return franquiciaRepository.getFranquicia(franquicia.getNombre())
                .map(f -> {
                    Map<String, Producto> mapa = new HashMap<>();
                    for(Sucursal sucursal: f.getSucursales()) {
                        Producto producto = Collections.max(sucursal.getProductosOfertados(), ProductoUseCase.mayorStockProductoComparator());
                        mapa.put(sucursal.getNombre(), producto);
                    }
                    return mapa;
                });
    }


}
