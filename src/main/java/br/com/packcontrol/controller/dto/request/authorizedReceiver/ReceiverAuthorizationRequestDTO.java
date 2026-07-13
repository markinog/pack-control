package br.com.packcontrol.controller.dto.request.authorizedReceiver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ReceiverAuthorizationRequestDTO(
        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 dígitos")
        String cpf,
        boolean isAuthorized) {
}
