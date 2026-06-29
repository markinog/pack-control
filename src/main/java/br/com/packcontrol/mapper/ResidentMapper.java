package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.ResidentRequestDTO;
import br.com.packcontrol.controller.dto.response.ResidentResponseDTO;
import br.com.packcontrol.model.Resident;
import org.springframework.stereotype.Component;

@Component
public class ResidentMapper {

    public static Resident toEntity(ResidentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return Resident.builder()
                .name(dto.name())
                .cpf(dto.cpf())
                .phone(dto.phone())
                .email(dto.email())
                .apartment(dto.apartment())
                .build();
    }

    public static ResidentResponseDTO toResponse(Resident resident) {
        if (resident == null) {
            return null;
        }

        return new ResidentResponseDTO(
                resident.getId(),
                resident.getName(),
                resident.getCpf(),
                resident.getPhone(),
                resident.getEmail(),
                resident.getApartment()
        );
    }
}
