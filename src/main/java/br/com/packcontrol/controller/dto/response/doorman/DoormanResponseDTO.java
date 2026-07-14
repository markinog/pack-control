package br.com.packcontrol.controller.dto.response.doorman;

import br.com.packcontrol.model.enums.DoormanShift;

public record DoormanResponseDTO(
        Long id,
        String name,
        String cpf,
        DoormanShift shift
) {
}
