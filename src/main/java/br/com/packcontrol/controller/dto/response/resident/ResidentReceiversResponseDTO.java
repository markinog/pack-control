package br.com.packcontrol.controller.dto.response.resident;

import br.com.packcontrol.controller.dto.response.authorizedReceiver.ReceiversByResidentResponseDTO;

import java.util.List;

public record ResidentReceiversResponseDTO(ResidentResponseDTO resident,
                                           List<ReceiversByResidentResponseDTO> authorizedReceivers) {
}
