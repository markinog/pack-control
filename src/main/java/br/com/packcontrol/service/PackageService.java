package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.PackageRequestDTO;
import br.com.packcontrol.controller.dto.response.PackageResponseDTO;
import br.com.packcontrol.exception.ResidentNotFoundException;
import br.com.packcontrol.mapper.PackageMapper;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.Package;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.repository.DoormanRepository;
import br.com.packcontrol.repository.PackageRepository;
import br.com.packcontrol.repository.ResidentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    private final DoormanRepository doormanRepository;
    private final ResidentRepository residentRepository;
    private final PackageRepository packageRepository;

    public PackageService(DoormanRepository doormanRepository, ResidentRepository residentRepository, PackageRepository packageRepository) {
        this.doormanRepository = doormanRepository;
        this.residentRepository = residentRepository;
        this.packageRepository = packageRepository;
    }

    public PackageResponseDTO create(PackageRequestDTO request){
        Doorman doorman = doormanRepository.findByCpf(request.doormanCpf())
                .orElseThrow(() -> new EntityNotFoundException("Porteiro não encontrado"));

        Resident destinationResident = residentRepository.findByCpf(request.residentCpf())
                .orElseThrow(() -> new ResidentNotFoundException("Morador não encontrado"));

        Package pkg = PackageMapper.toEntity(doorman, destinationResident, request);
        return PackageMapper.toResponse(packageRepository.save(pkg));
    }
}
