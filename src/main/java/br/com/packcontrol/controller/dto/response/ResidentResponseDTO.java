package br.com.packcontrol.controller.dto.response;

public record ResidentResponseDTO(
        Long id,
        String name,
        String cpf,
        String phone,
        String email,
        String apartment
) {
}
