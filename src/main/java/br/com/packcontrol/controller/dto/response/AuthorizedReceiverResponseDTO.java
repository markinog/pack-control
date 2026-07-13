package br.com.packcontrol.controller.dto.response;

public record AuthorizedReceiverResponseDTO(String name,
                                            String email,
                                            boolean isAuthorized,
                                            ResidentResponseDTO resident) {
}
