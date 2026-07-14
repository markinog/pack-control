package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.packages.PackageRequestDTO;
import br.com.packcontrol.controller.dto.response.packages.PackageResponseDTO;
import br.com.packcontrol.controller.dto.response.packages.PackageResponseDTO.AuthorizedReceiverSummary;
import br.com.packcontrol.controller.dto.response.packages.PackageResponseDTO.DoormanSummary;
import br.com.packcontrol.controller.dto.response.packages.PackageResponseDTO.ResidentSummary;
import br.com.packcontrol.model.AuthorizedReceiver;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.model.Package;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PackageMapper {

    public static Package toEntity(Doorman doorman,
                                                            Resident destinationResident,
                                                            PackageRequestDTO dto){
        if(dto == null ) return null;

        return Package.builder()
                .doorman(doorman)
                .destinationResident(destinationResident)
                .packageSize(dto.packageSize())
                .company(mapCompany(dto.company()))
                .deliveryTime(LocalDateTime.now())
                .build();
    }

    public static PackageResponseDTO toResponse(Package pack){
        if(pack == null ) return null;

        return new PackageResponseDTO(
                pack.getId(),
                mapDoorman(pack.getDoorman()),
                mapResident(pack.getDestinationResident()),
                mapResident(pack.getPickupResident()),
                mapAuthorizedReceiver(pack.getPickupAuthorizedReceiver()),
                pack.getDeliveryTime(),
                pack.getReceiveTime(),
                pack.getPackageSize(),
                mapCompany(pack.getCompany())
        );
    }

    private static DoormanSummary mapDoorman(Doorman doorman) {
        if (doorman == null) return null;
        return new DoormanSummary(doorman.getId(), doorman.getName());
    }

    private static ResidentSummary mapResident(Resident resident) {
        if (resident == null) return null;
        return new ResidentSummary(resident.getId(), resident.getName(), resident.getApartment());
    }

    private static AuthorizedReceiverSummary mapAuthorizedReceiver(AuthorizedReceiver receiver) {
        if (receiver == null) return null;
        return new AuthorizedReceiverSummary(receiver.getId(), receiver.getName());
    }

    private static String mapCompany(String value){
        return value != null ? value : "NAO_INFORMADA";
    }
}
