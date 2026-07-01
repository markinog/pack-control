package br.com.packcontrol.controller.dto.response;

import br.com.packcontrol.model.enums.DoormanShift;

public record DoormanResponseDTO(
        Long id,
        String name,
        DoormanShift shift
) {
}
