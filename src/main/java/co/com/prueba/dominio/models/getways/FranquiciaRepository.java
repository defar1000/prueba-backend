package co.com.prueba.dominio.models.getways;

import co.com.prueba.dominio.models.Franquicia;
import co.com.prueba.dominio.models.Sucursal;
import reactor.core.publisher.Mono;

public interface FranquiciaRepository {
    Mono<Franquicia> getFranquicia(String nombre);
    Mono<Franquicia> crearFranquicia(Franquicia nombre);
    Mono<Franquicia> nuevaSucursal(String franquicia, Sucursal sucursal);
}
