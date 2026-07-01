package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.ResidentRequestDTO;
import br.com.packcontrol.mapper.ResidentMapper;
import br.com.packcontrol.model.Resident;
import br.com.packcontrol.repository.ResidentRepository;
import org.springframework.stereotype.Service;

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
}
