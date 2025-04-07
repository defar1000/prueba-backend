package co.com.prueba.infraestructure.drivenAdapters.dbAdapter;

import co.com.prueba.dominio.models.Franquicia;
import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.FranquiciaRepository;
import co.com.prueba.dominio.models.getways.ProductoRepository;
import co.com.prueba.dominio.models.getways.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranquiciaRepositoryAdapter implements FranquiciaRepository, SucursalRepository, ProductoRepository {

    private final FranquiciaDBRepository franquiciaDBRepository;
    @Override
    public Mono<Franquicia> getFranquicia(String nombre) {
        return franquiciaDBRepository.findByNombre(nombre);
    }

    @Override
    public Mono<Franquicia> crearFranquicia(Franquicia nombre) {
        return franquiciaDBRepository.findByNombre(nombre.getNombre()).switchIfEmpty(franquiciaDBRepository.save(nombre));
    }

    @Override
    public Mono<Franquicia> nuevaSucursal(String franquicia, Sucursal sucursal) {
        return franquiciaDBRepository.findByNombre(franquicia)
                .flatMap(f -> {
                    f.getSucursales().add(sucursal);
                    return franquiciaDBRepository.save(f);
                }) ;
    }

    @Override
    public Mono<Producto> setStock(String nombreFranquicia, String nombreSucursal, String nombreProducto, int cantidad) {
        return franquiciaDBRepository.findByNombre(nombreFranquicia)
                .flatMap(franquicia -> franquiciaDBRepository.save(franquicia.actualizarStock(nombreSucursal, nombreProducto, cantidad)))
                .map(franquicia -> franquicia.getProducto(nombreSucursal, nombreProducto));
    }

    @Override
    public Mono<Sucursal> agregarProducto(String nombreFranquicia, String nombreSucursal, Producto producto) {
        return franquiciaDBRepository.findByNombre(nombreFranquicia)
                .flatMap(franquicia -> franquiciaDBRepository.save(franquicia.addProducto(nombreSucursal, producto)))
                .map(franquicia -> franquicia.getSucursal(nombreSucursal));
    }

    @Override
    public Mono<Sucursal> eliminarProducto(String nombreFranquicia, String nombreSucursal, String nombreProducto) {
        return franquiciaDBRepository.findByNombre(nombreFranquicia)
                .flatMap(franquicia -> franquiciaDBRepository.save(franquicia.removeProducto(nombreSucursal, nombreProducto)))
                .map(franquicia -> franquicia.getSucursal(nombreSucursal));
    }
}
