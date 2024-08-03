package daniellopezb.sistemagestionbiblioteca.services.impl;

import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;
import daniellopezb.sistemagestionbiblioteca.repositories.LibroRepository;
import daniellopezb.sistemagestionbiblioteca.services.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {

        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro getLibroById(UUID id) {
        return libroRepository.findById(id).orElseThrow();
    }

    @Override
    public Libro createLibro(Libro libro) {
        System.out.println("Datos que llegan");
        System.out.println(libro);

        System.out.println("Datos que se guardan");
        Libro libroSaved = libroRepository.save(libro);
        System.out.println(libroSaved);

        return libroRepository.save(libro);
    }

    @Override
    public Libro updateLibro(UUID id, Libro libro) {
        Libro oldLibro = this.getLibroById(id);
        oldLibro.setTitulo(libro.getTitulo());
        oldLibro.setAutor(libro.getAutor());
        oldLibro.setYear(libro.getYear());
        oldLibro.setBookActualStatusEnum(libro.getBookActualStatusEnum());
        oldLibro.setIsAvailable(libro.getIsAvailable());
        return libroRepository.save(oldLibro);
    }

    @Override
    public List<Libro> findByBookStatus(BookActualStatusEnum bookActualStatusEnum) {
        return libroRepository.findByBookActualStatusEnum(bookActualStatusEnum);
    }

    @Override
    public void deleteLibro(UUID id) {
        if (libroRepository.existsById(id)){
            libroRepository.deleteById(id);
            return;
        }
        throw new RuntimeException();
    }
}
