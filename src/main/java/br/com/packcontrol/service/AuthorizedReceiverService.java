package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.authorizedReceiver.AuthorizedReceiverRequestDTO;
import br.com.packcontrol.controller.dto.request.authorizedReceiver.ReceiverAuthorizationRequestDTO;
import br.com.packcontrol.controller.dto.response.authorizedReceiver.AuthorizedReceiverResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentReceiversResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentResponseDTO;
import br.com.packcontrol.exception.AuthorizedReceiverNotFoundException;
import br.com.packcontrol.exception.ResidentNotFoundException;
import br.com.packcontrol.mapper.AuthorizedReceiverMapper;
import br.com.packcontrol.mapper.ResidentMapper;
import br.com.packcontrol.model.AuthorizedReceiver;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.repository.AuthorizedReceiverRepository;
import br.com.packcontrol.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedReceiverService {

    private final AuthorizedReceiverRepository repository;
    private final ResidentService residentService;
    private final ResidentRepository residentRepository;

    public AuthorizedReceiverService(AuthorizedReceiverRepository repository, ResidentService residentService, ResidentRepository residentRepository) {
        this.repository = repository;
        this.residentService = residentService;
        this.residentRepository = residentRepository;
    }

    public Long create(AuthorizedReceiverRequestDTO request){

        Resident resident = residentRepository.findByCpf(request.residentCpf())
                .orElseThrow(() -> new ResidentNotFoundException("Morador não encontrado"));

        AuthorizedReceiver authorized = this.repository.save(AuthorizedReceiverMapper.createEntity(request, resident));
        return authorized.getId();
    }

    public AuthorizedReceiverResponseDTO findAuthorizedReceiverByCpf(String cpf){
        AuthorizedReceiver receiver = repository.findByCpf(cpf)
                .orElseThrow(() -> new AuthorizedReceiverNotFoundException("Recebedor com CPF " + cpf + " não foi encontrado"));

        ResidentResponseDTO resident = residentService.findResidentById(receiver.getResident().getId());

        return AuthorizedReceiverMapper.toResponse(receiver, resident);
    }

    public String updateAuthorization(ReceiverAuthorizationRequestDTO dto){
         int isAuthorized = repository.updateAuthorizedStatus(dto.cpf(), dto.isAuthorized());
         if(isAuthorized == 1){
             return  String.format("Recebedor com CPF %s foi autorizado a retirar encomendas para um morador", dto.cpf() );
         }
         return "Erro ao autorizar retirada";
    }

    public String revokeAuthorization(ReceiverAuthorizationRequestDTO dto){
         repository.updateAuthorizedStatus(dto.cpf(), false);
        return String.format("Recebedor com CPF %s teve sua autorização de retirar encomendas revogada pelo morador", dto.cpf() );
    }

    public ResidentReceiversResponseDTO listReceiversByResident(String cpf){
        Resident resident = residentRepository.findByCpf(cpf)
                .orElseThrow(() -> new AuthorizedReceiverNotFoundException("Recebedor com CPF " + cpf + " não foi encontrado"));

        List<AuthorizedReceiver> authorizedReceivers = repository.findAllByResidentId(resident.getId());

        return AuthorizedReceiverMapper.manyReceiversToResponse(ResidentMapper.toResponse(resident), authorizedReceivers );
    }
}
