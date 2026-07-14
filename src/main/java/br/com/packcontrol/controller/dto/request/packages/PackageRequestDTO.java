package br.com.packcontrol.controller.dto.request.packages;

import br.com.packcontrol.model.enums.PackageSize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PackageRequestDTO (
        @NotBlank(message = "CPF do morador é obrigatório")
        String residentCpf,
        @NotBlank(message = "CPF do porteiro é obrigatório")
        String doormanCpf,
        PackageSize packageSize,
        String company
){
}
