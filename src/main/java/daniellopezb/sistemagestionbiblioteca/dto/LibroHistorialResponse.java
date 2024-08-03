package daniellopezb.sistemagestionbiblioteca.dto;

import daniellopezb.sistemagestionbiblioteca.entities.Libro;
import daniellopezb.sistemagestionbiblioteca.entities.Usuario;
import daniellopezb.sistemagestionbiblioteca.enums.ActionPerformedEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record LibroHistorialResponse(

        UUID id,

       @NotBlank
       ActionPerformedEnum actionPerformedEnum,

       @NotBlank
       LocalDateTime transactionDate,

       Libro libro,

       Usuario usuario
) {
}
