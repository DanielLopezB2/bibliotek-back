package daniellopezb.sistemagestionbiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import daniellopezb.sistemagestionbiblioteca.JsonViews.Views;
import daniellopezb.sistemagestionbiblioteca.enums.ActionPerformedEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LibroHistorial {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "action_performed", nullable = false)
    private ActionPerformedEnum actionPerformedEnum;

    @Column(nullable = false)
    @DateTimeFormat
    private LocalDateTime transactionDate = LocalDateTime.now();

    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
