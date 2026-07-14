package br.com.packcontrol.controller.dto.response.authorizedReceiver;

import br.com.packcontrol.controller.dto.response.resident.ResidentResponseDTO;

public record AuthorizedReceiverResponseDTO(String name,
                                            String email,
                                            boolean isAuthorized,
                                            ResidentResponseDTO resident) {
}
