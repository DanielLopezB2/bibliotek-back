package daniellopezb.sistemagestionbiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import daniellopezb.sistemagestionbiblioteca.enums.ActionPerformedEnum;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private Boolean isAvailable;

    @Column(nullable = false, name = "estado")
    private BookActualStatusEnum bookActualStatusEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LibroHistorial> libroHistorial;
}
