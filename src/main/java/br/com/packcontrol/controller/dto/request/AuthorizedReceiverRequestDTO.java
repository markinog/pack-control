package br.com.packcontrol.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AuthorizedReceiverRequestDTO(
                                         @NotBlank(message = "Nome é obrigatório")
                                         String name,
                                         @Email(message = "Email inválido")
                                         String email,
                                         @NotBlank
                                         @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 dígitos")
                                         String cpf,
                                         @NotBlank
                                         String residentCpf,
                                         String apartment){
}
