package br.com.packcontrol.controller.dto.response.authorizedReceiver;

public record ReceiversByResidentResponseDTO(
                                            String name,
                                             String email,
                                             boolean isAuthorized) {
}
