package daniellopezb.sistemagestionbiblioteca.dto;

import jakarta.validation.constraints.NotBlank;

public record DeleteResponse(
        @NotBlank
        String message
) {
}
