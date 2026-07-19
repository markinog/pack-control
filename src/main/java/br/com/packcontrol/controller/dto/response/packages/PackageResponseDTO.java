package br.com.packcontrol.controller.dto.response.packages;

import br.com.packcontrol.controller.dto.response.authorizedReceiver.AuthorizedReceiverResponseDTO;
import br.com.packcontrol.controller.dto.response.doorman.DoormanResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentResponseDTO;
import br.com.packcontrol.model.enums.PackageSize;
import br.com.packcontrol.model.enums.PickedBy;

import java.time.LocalDateTime;

public record PackageResponseDTO(
    Long id,
    LocalDateTime deliveryTime,
    LocalDateTime receiveTime,
    PackageSize packageSize,
    String company,
    PickedBy pickedBy,
    DoormanResponseDTO doorman,
    ResidentResponseDTO resident,
    AuthorizedReceiverResponseDTO authorizedReceiver
) {
}


