package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.ResidentRequestDTO;
import br.com.packcontrol.controller.dto.response.ResidentResponseDTO;
import br.com.packcontrol.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/morador")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<ResidentResponseDTO> create(@RequestBody @Valid ResidentRequestDTO request){
        ResidentResponseDTO response = residentService.create(request);
        return ResponseEntity.created(URI.create("/morador/" + response.id())).body(response);
    }
}
