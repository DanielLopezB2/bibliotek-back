package daniellopezb.sistemagestionbiblioteca.dto;

import daniellopezb.sistemagestionbiblioteca.entities.LibroHistorial;
import daniellopezb.sistemagestionbiblioteca.enums.BookActualStatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record LibroResponse(

        UUID id,

        @NotBlank
        String titulo,

        @NotBlank
        String autor,

        @NotBlank
        Long year,

        @NotBlank
        boolean isAvailable,

        @NotBlank
        BookActualStatusEnum bookActualStatusEnum,

        List<LibroHistorial> libroHistorial
) {
}
