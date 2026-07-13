package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.DoormanRequestDTO;
import br.com.packcontrol.controller.dto.request.DoormanUpdateDTO;
import br.com.packcontrol.controller.dto.response.DoormanResponseDTO;
import br.com.packcontrol.exception.DoormanNotFoundException;
import br.com.packcontrol.mapper.DoormanMapper;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.enums.DoormanShift;
import br.com.packcontrol.repository.DoormanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.packcontrol.mapper.DoormanMapper.toResponse;
import static br.com.packcontrol.mapper.DoormanMapper.updateEntityFromDto;

@Service
public class DoormanService {

    private final DoormanRepository repository;

    public DoormanService(DoormanRepository repository) {
        this.repository = repository;
    }

    public Long create(DoormanRequestDTO dto){
        Doorman doorman = this.repository.save(DoormanMapper.toEntity(dto));
        return doorman.getId();
    }

    public List<DoormanResponseDTO> findAll(){
        List<Doorman> doormans = repository.findAll();
        return doormans.stream()
                .map(DoormanMapper::toResponse)
                .toList();
    }

    public DoormanResponseDTO  findById(Long id){
        Doorman doorman = repository.findById(id)
                .orElseThrow(() -> new DoormanNotFoundException("Porteiro com id " + id + " não encontrado")) ;

        return toResponse(doorman);
    }

    public DoormanResponseDTO findDoormanByCpf(String cpf){
        Doorman doorman = repository.findByCpf(cpf)
                .orElseThrow(() -> new DoormanNotFoundException("Porteiro com CPF " + cpf + " não encontrado"));

        return toResponse(doorman);
    }

    public List<DoormanResponseDTO> findAllDoormanByShift(String shift){
        List<Doorman> doormans = repository.findAllByShift(DoormanShift.fromValue(shift))
                .orElseThrow(() -> new DoormanNotFoundException("Nenhum porteiro do turno " + shift + " cadastrado"));

        return doormans.stream()
                .map(DoormanMapper::toResponse)
                .toList();
    }

    @Transactional
    public DoormanResponseDTO updateDoorman(String cpf, DoormanUpdateDTO dto){
        Doorman doorman = repository.findByCpf(cpf)
                .orElseThrow(() -> new DoormanNotFoundException("Porteiro não encontrado para o ID " + cpf));

        updateEntityFromDto(dto, doorman);
        return toResponse(doorman);
    }
}
