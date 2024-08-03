package daniellopezb.sistemagestionbiblioteca.repositories;

import daniellopezb.sistemagestionbiblioteca.entities.LibroHistorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LibroHistorialRepository extends JpaRepository<LibroHistorial, UUID> {
    List<LibroHistorial>findByLibro_Id(UUID libroId);
}
