package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.authorizedReceiver.AuthorizedReceiverRequestDTO;
import br.com.packcontrol.controller.dto.request.authorizedReceiver.AuthorizedReceiversRequestDTO;
import br.com.packcontrol.controller.dto.request.authorizedReceiver.ReceiverAuthorizationRequestDTO;
import br.com.packcontrol.controller.dto.response.authorizedReceiver.AuthorizedReceiverResponseDTO;
import br.com.packcontrol.controller.dto.response.authorizedReceiver.ReceiversByResidentResponseDTO;
import br.com.packcontrol.controller.dto.response.resident.ResidentReceiversResponseDTO;
import br.com.packcontrol.service.AuthorizedReceiverService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recebedor")
public class AuthorizedReceiverController {

    private final AuthorizedReceiverService authorizedReceiverService;

    public AuthorizedReceiverController(AuthorizedReceiverService authorizedReceiverService) {
        this.authorizedReceiverService = authorizedReceiverService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody AuthorizedReceiverRequestDTO request){
        Long authorizedReceiverId = authorizedReceiverService.create(request);
        return ResponseEntity.ok().body(authorizedReceiverId);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<AuthorizedReceiverResponseDTO> findByCpf(@PathVariable("cpf") String  cpf){
        AuthorizedReceiverResponseDTO response = authorizedReceiverService.findAuthorizedReceiverByCpf(cpf);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping ( "/autorizados-por-morador")
    public ResponseEntity<ResidentReceiversResponseDTO> findAllAuthorizedReceiversByResident(@Valid @RequestBody AuthorizedReceiversRequestDTO residentCpf){
        ResidentReceiversResponseDTO authorizedReceivers = authorizedReceiverService.listReceiversByResident(residentCpf.residentCpf());
        return ResponseEntity.ok().body(authorizedReceivers);
    }

    @PatchMapping("/revogar-autorizacao")
    public ResponseEntity<String> revoke(@Valid @RequestBody ReceiverAuthorizationRequestDTO request){
        String result = authorizedReceiverService.revokeAuthorization(request);
        return ResponseEntity.ok().body(result);
    }

    @PatchMapping("/autorizar-recebedor")
    public ResponseEntity<String> authorizeReceiver(@Valid @RequestBody ReceiverAuthorizationRequestDTO request){
        String result = authorizedReceiverService.updateAuthorization(request);
        return ResponseEntity.ok().body(result);
    }
}
