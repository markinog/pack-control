package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.authorizedReceiver.AuthorizedReceiverRequestDTO;
import br.com.packcontrol.controller.dto.request.authorizedReceiver.ReceiverAuthorizationRequestDTO;
import br.com.packcontrol.controller.dto.response.authorizedReceiver.AuthorizedReceiverResponseDTO;
import br.com.packcontrol.controller.dto.response.authorizedReceiver.ReceiversByResidentResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentReceiversResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentResponseDTO;
import br.com.packcontrol.model.AuthorizedReceiver;
import br.com.packcontrol.controller.AuthorizedReceiverController;
import br.com.packcontrol.model.Resident;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizedReceiverMapper {

    /**
     * param "authorized" always false when creating, to activate a receiver use:
     * {@link  AuthorizedReceiverController#authorizeReceiver(ReceiverAuthorizationRequestDTO)}
     * */
    public static AuthorizedReceiver createEntity (AuthorizedReceiverRequestDTO dto, Resident resident){
        if(dto ==  null || resident == null){
            return null;
        }

        return AuthorizedReceiver.builder()
                .name(dto.name())
                .email(dto.email())
                .cpf(dto.cpf())
                .apartment(dto.apartment())
                .authorized(false)
                .resident(resident)
                .build();
    }

    public static AuthorizedReceiverResponseDTO toResponse(AuthorizedReceiver receiver, ResidentResponseDTO resident){
        if(receiver == null || resident == null){
            return null;
        }

        return new AuthorizedReceiverResponseDTO(
                receiver.getName(),
                receiver.getEmail(),
                receiver.isAuthorized(),
                resident
        );
    }

    public static ResidentReceiversResponseDTO manyReceiversToResponse(ResidentResponseDTO resident, List<AuthorizedReceiver> authorizedReceivers){
        if(authorizedReceivers.isEmpty()){
            return null;
        }

        return new ResidentReceiversResponseDTO(resident, authorizedReceivers
                .stream()
                .map(receiver -> new ReceiversByResidentResponseDTO(
                        receiver.getName(),
                        receiver.getEmail(),
                        receiver.isAuthorized()))
                .toList());
    }
}
