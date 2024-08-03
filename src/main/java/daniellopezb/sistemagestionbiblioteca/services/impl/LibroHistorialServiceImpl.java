package daniellopezb.sistemagestionbiblioteca.services.impl;

import daniellopezb.sistemagestionbiblioteca.entities.LibroHistorial;
import daniellopezb.sistemagestionbiblioteca.repositories.LibroHistorialRepository;
import daniellopezb.sistemagestionbiblioteca.services.LibroHistorialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibroHistorialServiceImpl implements LibroHistorialService {

    private final LibroHistorialRepository libroHistorialRepository;

    public LibroHistorialServiceImpl(LibroHistorialRepository libroHistorialRepository) {
        this.libroHistorialRepository = libroHistorialRepository;
    }

    @Override
    public List<LibroHistorial> getLibroHistoriales() {
        return libroHistorialRepository.findAll();
    }

    @Override
    public LibroHistorial createLibroHistorial(LibroHistorial libroHistorial) {
        return libroHistorialRepository.save(libroHistorial);
    }

    @Override
    public List<LibroHistorial> findByLibro_Id(UUID libroId) {
        return libroHistorialRepository.findByLibro_Id(libroId);
    }
}
