package br.com.packcontrol.controller.dto.response.resident;

public record ResidentResponseDTO(
        Long id,
        String name,
        String phone,
        String email,
        String apartment
) {
}
