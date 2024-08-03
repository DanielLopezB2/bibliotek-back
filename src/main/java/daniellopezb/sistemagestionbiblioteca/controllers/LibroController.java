package daniellopezb.sistemagestionbiblioteca.controllers;


import daniellopezb.sistemagestionbiblioteca.dto.DeleteResponse;
import daniellopezb.sistemagestionbiblioteca.dto.LibroResponse;
import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;
import daniellopezb.sistemagestionbiblioteca.services.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/libros")
@CrossOrigin("http://localhost:4200")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroResponse> getLibros() {
        List<Libro> libros =  libroService.getLibros();
        return libros.stream().map(libro -> new LibroResponse(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getYear(),
                libro.getIsAvailable(),
                libro.getBookActualStatusEnum(),
                libro.getLibroHistorial()
                )).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public LibroResponse getLibroById(@PathVariable("id") UUID id) {
        Libro libro = libroService.getLibroById(id);
        return new LibroResponse(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getYear(), libro.getIsAvailable(), libro.getBookActualStatusEnum(), libro.getLibroHistorial());
    }

    @PostMapping
    public LibroResponse createLibro(@RequestBody Libro libro) {
        Libro createdLibro = libroService.createLibro(libro);
        return new LibroResponse(createdLibro.getId(), createdLibro.getTitulo(), createdLibro.getAutor(), createdLibro.getYear(), createdLibro.getIsAvailable(), libro.getBookActualStatusEnum(), createdLibro.getLibroHistorial());
    }

    @PutMapping("{id}")
    public LibroResponse updateLibro(@PathVariable("id") UUID id, @RequestBody Libro libro) {
        Libro updatedLibro = libroService.updateLibro(id, libro);
        return new LibroResponse(updatedLibro.getId(), updatedLibro.getTitulo(), updatedLibro.getAutor(), updatedLibro.getYear(), updatedLibro.getIsAvailable(), libro.getBookActualStatusEnum(), updatedLibro.getLibroHistorial());
    }

    @DeleteMapping("{id}")
    public DeleteResponse deleteLibro(@PathVariable("id") UUID id) {
        libroService.deleteLibro(id);
        return new DeleteResponse("Libro eliminado correctamente");
    }

    @GetMapping("findByStatus/{status}")
    public List<LibroResponse> findByBookStatus(@PathVariable("status") BookActualStatusEnum bookActualStatusEnum) {
        List<Libro> libros = libroService.findByBookStatus(bookActualStatusEnum);
        return libros.stream().map(libro -> new LibroResponse(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getYear(),
                libro.getIsAvailable(),
                libro.getBookActualStatusEnum(),
                libro.getLibroHistorial()
        )).collect(Collectors.toList());
    }
}
