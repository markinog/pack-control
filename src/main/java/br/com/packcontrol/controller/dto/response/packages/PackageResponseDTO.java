package br.com.packcontrol.controller.dto.response.packages;

import br.com.packcontrol.model.enums.PackageSize;

import java.time.LocalDateTime;

public record PackageResponseDTO(
    Long id,
    DoormanSummary doorman,
    ResidentSummary resident,
    ResidentSummary pickupResident,
    AuthorizedReceiverSummary authorizedReceiver,
    LocalDateTime deliveryTime,
    LocalDateTime receiveTime,
    PackageSize packageSize,
    String company
) {
    public record DoormanSummary(
            Long id,
            String name
    ) {}

    public record ResidentSummary(
            Long id,
            String name,
            String apartment
    ) {}

    public record AuthorizedReceiverSummary(
            Long id,
            String name
    ) {}
}


