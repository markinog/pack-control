package br.com.packcontrol.controller.dto.request.doorman;

import br.com.packcontrol.model.enums.DoormanShift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DoormanRequestDTO(
        @NotBlank(message = "Nome do porteiro é obrigatório")
        String name,

        @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 dígitos")
        String cpf,

        DoormanShift shift
) {
}
