package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.ResidentRequestDTO;
import br.com.packcontrol.controller.dto.request.ResidentUpdateDTO;
import br.com.packcontrol.controller.dto.response.ResidentResponseDTO;
import br.com.packcontrol.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/morador")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid ResidentRequestDTO request){
        Long response = residentService.create(request);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ResidentResponseDTO>> findAllResidents(){
        return ResponseEntity.ok().body(residentService.findAllResidents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidentResponseDTO> findResidentById(@PathVariable("id") Long id){
        ResidentResponseDTO response = residentService.findResidentById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ResidentResponseDTO> findResidentByCpf(@PathVariable("cpf") String cpf){
        ResidentResponseDTO response = residentService.findResidentByCpf(cpf);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ResidentResponseDTO> updateResident(@PathVariable("id") Long id,
                                                 @Valid @RequestBody ResidentUpdateDTO request){
        ResidentResponseDTO response = residentService.updateResident(id, request);
        return ResponseEntity.status(200).body(response);
    }
}
