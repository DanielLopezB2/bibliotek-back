package daniellopezb.sistemagestionbiblioteca.services;

import daniellopezb.sistemagestionbiblioteca.entities.LibroHistorial;
import daniellopezb.sistemagestionbiblioteca.entities.Usuario;

import java.util.List;
import java.util.UUID;

public interface LibroHistorialService {
    List<LibroHistorial> getLibroHistoriales();
    LibroHistorial createLibroHistorial(LibroHistorial libroHistorial);
    List<LibroHistorial> findByLibro_Id(UUID libroId);
}
