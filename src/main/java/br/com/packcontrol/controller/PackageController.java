package br.com.packcontrol.controller;

import br.com.packcontrol.controller.dto.request.packages.PackageRequestDTO;
import br.com.packcontrol.controller.dto.response.PackageResponseDTO;
import br.com.packcontrol.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encomendas")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    //TODO logica de retirada de encomenda contendo a parte do PickupAuthorizedReceiver e pickupResident

    @PostMapping
    public ResponseEntity<PackageResponseDTO> createPackage(@RequestBody @Valid PackageRequestDTO request){
        PackageResponseDTO response = packageService.create(request);
        return ResponseEntity.status(201).body(response);
    }
}
