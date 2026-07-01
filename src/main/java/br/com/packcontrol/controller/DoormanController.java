package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.DoormanRequestDTO;
import br.com.packcontrol.controller.dto.response.DoormanResponseDTO;
import br.com.packcontrol.service.DoormanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
