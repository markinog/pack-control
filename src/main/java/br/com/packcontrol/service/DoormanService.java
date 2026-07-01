package br.com.packcontrol.service;

import br.com.packcontrol.controller.dto.request.DoormanRequestDTO;
import br.com.packcontrol.mapper.DoormanMapper;
import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.repository.DoormanRepository;
import org.springframework.stereotype.Service;

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
}
