package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.DoormanRequestDTO;
import br.com.packcontrol.controller.dto.request.DoormanUpdateDTO;
import br.com.packcontrol.controller.dto.response.DoormanResponseDTO;
import br.com.packcontrol.service.DoormanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/porteiro")
public class DoormanController {

    private final DoormanService doormanService;

    public DoormanController(DoormanService doormanService) {
        this.doormanService = doormanService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid DoormanRequestDTO request){
        Long response = doormanService.create(request);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DoormanResponseDTO>> findAllDoormans(){
        List<DoormanResponseDTO>  response =  doormanService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoormanResponseDTO> findById(@PathVariable("id") Long id){
        DoormanResponseDTO response =  doormanService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<DoormanResponseDTO> findByCpf(@PathVariable("cpf") String cpf){
        DoormanResponseDTO response  = doormanService.findDoormanByCpf(cpf);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/turno/{shift}")
    public ResponseEntity<List<DoormanResponseDTO>> findAllByShift(@PathVariable String shift){
        List<DoormanResponseDTO> response =  doormanService.findAllDoormanByShift(shift);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<DoormanResponseDTO> updateDoorman(@PathVariable("id") Long id, @RequestBody DoormanUpdateDTO dto){
        DoormanResponseDTO response = doormanService.updateDoorman(id, dto);
        return ResponseEntity.ok().body(response);
    }
}
