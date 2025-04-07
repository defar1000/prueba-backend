package co.com.prueba.infraestructure.entryPoints;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.Sucursal;
import co.com.prueba.dominio.models.getways.SucursalRepository;
import co.com.prueba.dominio.useCases.SucursalUseCase;
import co.com.prueba.infraestructure.entryPoints.models.ProductoRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/sucursal")
public class SucursalController {
    private final SucursalUseCase sucursalUseCase;

    public SucursalController(SucursalRepository sucursalRepository) {
        sucursalUseCase = new SucursalUseCase(sucursalRepository);
    }

    @PatchMapping("{nombreFranquicia}/{nombreSucursal}/agregarProducto")
    public Mono<Sucursal> agregarProducto(@PathVariable String nombreFranquicia,
                                          @PathVariable String nombreSucursal,
                                          @RequestBody ProductoRequest productoRequest) {
        Producto producto = Producto.builder().nombre(productoRequest.getNombreProducto()).cantidadStock(productoRequest.getCantidad()).build();
        return sucursalUseCase.agregarProducto(nombreFranquicia, nombreSucursal, producto);
    }

    @PatchMapping("{nombreFranquicia}/{nombreSucursal}/eliminarProducto/{nombreProducto}")
    public Mono<Sucursal> eliminarProducto(@PathVariable String nombreFranquicia,
                                          @PathVariable String nombreSucursal,
                                          @PathVariable String nombreProducto) {
        return sucursalUseCase.eliminarProducto(nombreFranquicia, nombreSucursal, nombreProducto);
    }
}
