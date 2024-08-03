package daniellopezb.sistemagestionbiblioteca.controllers;

import daniellopezb.sistemagestionbiblioteca.dto.LibroHistorialRequest;
import daniellopezb.sistemagestionbiblioteca.dto.LibroHistorialResponse;
import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.entities.LibroHistorial;
import daniellopezb.sistemagestionbiblioteca.entities.Usuario;
import daniellopezb.sistemagestionbiblioteca.services.LibroHistorialService;
import daniellopezb.sistemagestionbiblioteca.services.LibroService;
import daniellopezb.sistemagestionbiblioteca.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/historial")
@CrossOrigin("http://localhost:4200")
public class LibroHistorialController {

    private final LibroHistorialService libroHistorialService;
    private final LibroService libroService;
    private final UsuarioService usuarioService;

    public LibroHistorialController(LibroHistorialService libroHistorialService, LibroService libroService, UsuarioService usuarioService) {
        this.libroHistorialService = libroHistorialService;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<LibroHistorialResponse> getLibroHistoriales() {
        List<LibroHistorial> libroHistoriales =  libroHistorialService.getLibroHistoriales();
        return libroHistoriales.stream().map(libros -> new LibroHistorialResponse(
                libros.getId(),
                libros.getActionPerformedEnum(),
                libros.getTransactionDate(),
                libros.getLibro(),
                libros.getUsuario()
        )).collect(Collectors.toList());
    }

    @PostMapping
    public LibroHistorialResponse createLibroHistorial(@RequestBody @Valid LibroHistorialRequest libroHistorialRequest) {
        Libro libro = libroService.getLibroById(libroHistorialRequest.libroId());
        Usuario usuario = usuarioService.getUsuarioById(libroHistorialRequest.usuarioId());

        LibroHistorial libroHistorial = new LibroHistorial();
        libroHistorial.setActionPerformedEnum(libroHistorialRequest.actionPerformedEnum());
        libroHistorial.setTransactionDate(libroHistorialRequest.transactionDate());
        libroHistorial.setLibro(libro);
        libroHistorial.setUsuario(usuario);

        LibroHistorial createdLibroHistorial = libroHistorialService.createLibroHistorial(libroHistorial);
        return new LibroHistorialResponse(
                createdLibroHistorial.getId(),
                createdLibroHistorial.getActionPerformedEnum(),
                createdLibroHistorial.getTransactionDate(),
                createdLibroHistorial.getLibro(),
                createdLibroHistorial.getUsuario());
    }

    @GetMapping("findByLibroId/{id}")
    public List<LibroHistorialResponse> findByLibroId(@PathVariable("id") UUID id) {
        List<LibroHistorial> libroHistoriales =  libroHistorialService.findByLibro_Id(id);
        return libroHistoriales.stream().map(libros -> new LibroHistorialResponse(
                libros.getId(),
                libros.getActionPerformedEnum(),
                libros.getTransactionDate(),
                libros.getLibro(),
                libros.getUsuario()
        )).collect(Collectors.toList());
    }
}
