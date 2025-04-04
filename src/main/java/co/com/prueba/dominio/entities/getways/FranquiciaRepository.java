package co.com.prueba.dominio.entities.getways;

import co.com.prueba.dominio.entities.Franquicia;
import co.com.prueba.dominio.entities.Sucursal;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {
    Mono<Franquicia> getFranquicia(String nombre);
    Mono<Franquicia> crearFranquicia(String nombre);
    Mono<Franquicia> nuevaSucursal(Sucursal sucursal);
}
