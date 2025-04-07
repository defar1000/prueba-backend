package co.com.prueba.dominio.useCases;

import co.com.prueba.dominio.models.Franquicia;
import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RequiredArgsConstructor
public class FranquiciaUseCase {
    private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> crearFranquicia(String nombre) {
        Franquicia franquicia = Franquicia.builder().nombre(nombre).sucursales(new HashSet<>()).build();
        return franquiciaRepository.crearFranquicia(franquicia);
    }
    public Mono<Franquicia> nuevaSucursal(String nombreFranquicia, String nombreSucursal) {
        Sucursal sucursal = Sucursal.builder().nombre(nombreSucursal).productosOfertados(new HashSet<>()).build();
        return franquiciaRepository.nuevaSucursal(nombreFranquicia, sucursal);
    }

    public Mono<Map<String, Producto>> mayorStockEnSucursalesByFranquicia(String nombreFranquicia) {
        return franquiciaRepository.getFranquicia(nombreFranquicia)
                .mapNotNull(f -> {
                    Map<String, Producto> mapa = new HashMap<>();
                    for(Sucursal sucursal: f.getSucursales()) {
                        if (sucursal.getProductosOfertados().isEmpty()) continue;
                        Producto producto = Collections.max(sucursal.getProductosOfertados(), ProductoUseCase.mayorStockProductoComparator());
                        mapa.put(sucursal.getNombre(), producto);
                    }
                    return mapa;
                });
    }


}
