package daniellopezb.sistemagestionbiblioteca.dto;

import daniellopezb.sistemagestionbiblioteca.enums.ActionPerformedEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record LibroHistorialRequest(

        ActionPerformedEnum actionPerformedEnum,

        LocalDateTime transactionDate,

        UUID libroId,

        UUID usuarioId
) {
}
