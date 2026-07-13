package br.com.packcontrol.controller.dto.request.resident;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ResidentRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String name,

        @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 dígitos")
        String cpf,

        @Pattern(regexp = "\\d{10,11}", message = "Telefone deve ter 10 ou 11 dígitos")
        String phone,

        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Apartamento é obrigatório")
        String apartment
) {
}
