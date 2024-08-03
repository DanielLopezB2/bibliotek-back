package daniellopezb.sistemagestionbiblioteca.repositories;

import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LibroRepository extends JpaRepository<Libro, UUID> {
    List<Libro> findByBookActualStatusEnum(BookActualStatusEnum bookActualStatusEnum);
}
