package daniellopezb.sistemagestionbiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Usuario {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LibroHistorial> libroHistoriales;
}