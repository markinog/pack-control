package br.com.packcontrol.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ResidentUpdateDTO(
        String name,
        @Pattern(regexp = "\\d{10,11}")
        String phone,
        String apartment,
        String email
) {
}
