package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.AuthorizedReceiverController;
import br.com.packcontrol.controller.dto.request.authorizedReceiver.ReceiverAuthorizationRequestDTO;
import br.com.packcontrol.controller.dto.request.packages.PackageRequestDTO;
import br.com.packcontrol.controller.dto.response.packages.PackageResponseDTO;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.model.Package;
import br.com.packcontrol.model.enums.PackageSize;
import br.com.packcontrol.model.enums.PickedBy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PackageMapper {

    /**
     * param "pickedBy" always NAO_RETIRADA when creating.
     * a package can be picked by MORADOR or RECEBEDOR_AUTORIZADO.
     * */
    public static Package toEntity(Doorman doorman,
                                                            Resident destinationResident,
                                                            PackageRequestDTO dto){
        if(dto == null ) return null;

        return Package.builder()
                .doorman(doorman)
                .destinationResident(destinationResident)
                .packageSize(dto.packageSize())
                .company(mapCompany(dto.company()))
                .pickedBy(PickedBy.NAO_RETIRADO)
                .deliveryTime(LocalDateTime.now())
                .build();
    }

    public static PackageResponseDTO toResponse(Package pack){
        if(pack == null ) return null;

        return new PackageResponseDTO(
                pack.getId(),

                pack.getDeliveryTime(),
                pack.getReceiveTime(),
                PackageSize.defaultOr(pack.getPackageSize()),
                mapCompany(pack.getCompany()),
                PickedBy.defaultOr(pack.getPickedBy()),
                DoormanMapper.toResponse(pack.getDoorman()),
                ResidentMapper.toResponse(pack.getDestinationResident()),
                AuthorizedReceiverMapper.toResponse(pack.getPickupAuthorizedReceiver(), ResidentMapper.toResponse(pack.getDestinationResident()))
        );
    }

    private static String mapCompany(String value){
        return value != null ? value : "NAO_INFORMADA";
    }
}
