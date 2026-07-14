package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.doorman.DoormanRequestDTO;
import br.com.packcontrol.controller.dto.request.doorman.DoormanUpdateDTO;
import br.com.packcontrol.controller.dto.response.doorman.DoormanResponseDTO;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.enums.DoormanShift;
import org.springframework.stereotype.Component;

@Component
public class DoormanMapper {
    public static Doorman toEntity(DoormanRequestDTO dto){
        if(dto == null){
            return null;
        }

        return Doorman.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .shift(DoormanShift.defaultOr(dto.shift()))
                .build();
    }

    public static DoormanResponseDTO toResponse(Doorman doorman){
        if(doorman == null){
            return null;
        }

        return new DoormanResponseDTO(
                doorman.getId(),
                doorman.getName(),
                doorman.getCpf(),
                doorman.getShift()
        );
    }

    public static Doorman updateEntityFromDto(DoormanUpdateDTO dto, Doorman doorman){

        if(dto.name() != null &&  !dto.name().isBlank()){
            doorman.setName(dto.name());
        }

        if(dto.shift() != null &&  !dto.shift().isBlank()){
            doorman.setShift(DoormanShift.fromValue(dto.shift()));
        }

        return doorman;
    }
}
