package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.resident.ResidentRequestDTO;
import br.com.packcontrol.controller.dto.request.resident.ResidentUpdateDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentResponseDTO;
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
                resident.getCpf(),
                resident.getName(),
                resident.getPhone(),
                resident.getEmail(),
                resident.getApartment()
        );
    }

    public static Resident updateEntityFromUpdateDto(ResidentUpdateDTO dto, Resident resident){
        if (dto.name() != null && !dto.name().isBlank()) {
            resident.setName(dto.name());
        }
        if (dto.phone() != null) {
            resident.setPhone(dto.phone());
        }
        if (dto.email() != null && !dto.email().isBlank()) {
            resident.setEmail(dto.email());
        }
        if (dto.apartment() != null ) {
            resident.setApartment(dto.apartment());
        }

        return resident;
    }
}
