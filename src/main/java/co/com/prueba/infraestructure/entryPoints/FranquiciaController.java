package co.com.prueba.infraestructure.entryPoints;

import co.com.prueba.dominio.models.Franquicia;
import co.com.prueba.dominio.models.Producto;
import co.com.prueba.dominio.models.getways.FranquiciaRepository;
import co.com.prueba.dominio.useCases.FranquiciaUseCase;
import co.com.prueba.infraestructure.entryPoints.models.FranquiciaRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("api/v1/franquicia")
public class FranquiciaController {
    private final FranquiciaUseCase franquiciaUseCase;

    public FranquiciaController(FranquiciaRepository franquiciaRepository) {
        franquiciaUseCase = new FranquiciaUseCase(franquiciaRepository);
    }

    @PutMapping
    public Mono<Franquicia> crearFranquicia(@RequestBody FranquiciaRequest franquiciaRequest) {
        return franquiciaUseCase.crearFranquicia(franquiciaRequest.getNombre());
    }

    @PatchMapping("nuevaSucursal")
    public Mono<Franquicia> nuevaSucursal(@RequestBody FranquiciaRequest franquiciaRequest) {
        return franquiciaUseCase.nuevaSucursal(franquiciaRequest.getNombre(), franquiciaRequest.getNombreSucursal());
    }

    @GetMapping("mayorStockSucursales/{nombreFranquicia}")
    public Mono<Map<String, Producto>> mayorStockEnSucursalesByFranquicia(@PathVariable String nombreFranquicia) {
        return franquiciaUseCase.mayorStockEnSucursalesByFranquicia(nombreFranquicia);
    }
}
