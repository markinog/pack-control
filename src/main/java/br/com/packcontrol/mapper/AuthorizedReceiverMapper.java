package br.com.packcontrol.mapper;

import br.com.packcontrol.controller.dto.request.AuthorizedReceiverRequestDTO;
import br.com.packcontrol.controller.dto.request.ReceiverAuthorizationRequestDTO;
import br.com.packcontrol.controller.dto.response.AuthorizedReceiverResponseDTO;
import br.com.packcontrol.controller.dto.response.ResidentResponseDTO;
import br.com.packcontrol.model.AuthorizedReceiver;
import br.com.packcontrol.controller.AuthorizedReceiverController
import br.com.packcontrol.model.Resident;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedReceiverMapper {

    /**
     * param "authorized" always false when creating, to activate a receiver use:
     * {@link  AuthorizedReceiverController#authorizeReceiver(ReceiverAuthorizationRequestDTO)}
     * */
    public static AuthorizedReceiver createEntity (AuthorizedReceiverRequestDTO dto, Resident resident){
        if(dto ==  null){
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
}
