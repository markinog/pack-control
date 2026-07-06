package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.ResidentRequestDTO;
import br.com.packcontrol.controller.dto.request.ResidentUpdateDTO;
import br.com.packcontrol.controller.dto.response.ResidentResponseDTO;
import br.com.packcontrol.exception.ResidentNotFoundException;
import br.com.packcontrol.mapper.ResidentMapper;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.repository.ResidentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.packcontrol.mapper.ResidentMapper.toResponse;
import static br.com.packcontrol.mapper.ResidentMapper.updateEntityFromUpdateDto;

@Service
public class ResidentService {

    private final ResidentRepository repository;

    public ResidentService(ResidentRepository repository) {
        this.repository = repository;
    }

    public Long create(ResidentRequestDTO dto){
        Resident resident =  this.repository.save(ResidentMapper.toEntity(dto));
        return resident.getId();
    }

    public List<ResidentResponseDTO> findAllResidents(){
        return repository.findAll()
                .stream()
                .map(ResidentMapper::toResponse)
                .toList();
    }

    public ResidentResponseDTO findResidentById(Long id){
       Resident resident = repository.findById(id)
               .orElseThrow(() -> new ResidentNotFoundException("Morador com ID  "+ id+ " não encontrado"));
        return toResponse(resident);
    }

    public ResidentResponseDTO findResidentByCpf(String cpf){
        Resident resident = repository.findByCpf(cpf)
                .orElseThrow(() ->  new ResidentNotFoundException("Morador com CPF "+ cpf + " não encontrado"));
        return toResponse(resident);
    }

    @Transactional
    public ResidentResponseDTO updateResident(Long id, ResidentUpdateDTO dto){
        Resident resident = repository.findById(id)
                .orElseThrow(() -> new ResidentNotFoundException("Morador com ID  "+ id+ " não encontrado"));

         updateEntityFromUpdateDto(dto, resident);

         return toResponse(resident);
    }
}
