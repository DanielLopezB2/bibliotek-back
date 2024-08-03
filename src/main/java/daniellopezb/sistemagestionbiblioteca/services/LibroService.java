package daniellopezb.sistemagestionbiblioteca.services;

import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;

import java.util.List;
import java.util.UUID;

public interface LibroService {

    List<Libro> getLibros();
    Libro getLibroById(UUID id);
    Libro createLibro(Libro libro);
    Libro updateLibro(UUID id, Libro libro);
    List<Libro> findByBookStatus(BookActualStatusEnum bookActualStatusEnum);
    void deleteLibro(UUID id);

}
