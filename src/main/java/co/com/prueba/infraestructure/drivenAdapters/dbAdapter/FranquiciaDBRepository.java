package co.com.prueba.infraestructure.drivenAdapters.dbAdapter;

import co.com.prueba.dominio.models.Franquicia;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FranquiciaDBRepository extends ReactiveMongoRepository<Franquicia, String> {
    Mono<Franquicia> findByNombre(String nombre);
}
