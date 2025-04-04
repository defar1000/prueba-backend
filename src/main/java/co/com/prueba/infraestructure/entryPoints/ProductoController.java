package co.com.prueba.infraestructure.entryPoints;

import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.getways.ProductoRepository;
import co.com.prueba.dominio.useCases.ProductoUseCase;
import co.com.prueba.infraestructure.entryPoints.models.ProductoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("api/v1/producto")
@RequiredArgsConstructor
public class ProductoController {
    private ProductoUseCase productoUseCase;

    public ProductoController(ProductoRepository productoRepository) {
        productoUseCase = new ProductoUseCase(productoRepository);
    }

    @PatchMapping("setStock")
    public Mono<Producto> setStock(@RequestBody ProductoRequest productoRequest) {
        return productoUseCase.setStock(productoRequest.getNombreFranquicia(),
                productoRequest.getNombreSucursal(),
                productoRequest.getNombreProducto(),
                productoRequest.getCantidad());
    }

}
