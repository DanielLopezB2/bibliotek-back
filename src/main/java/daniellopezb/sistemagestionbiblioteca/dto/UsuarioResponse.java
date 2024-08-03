package daniellopezb.sistemagestionbiblioteca.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UsuarioResponse(

        UUID id,

        @NotBlank
        String nombre,

        @NotBlank
        String email

) {
}
