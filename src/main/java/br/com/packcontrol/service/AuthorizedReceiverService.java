package br.com.packcontrol.service;

import br.com.packcontrol.repository.AuthorizedReceiverRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedReceiverService {

    private final AuthorizedReceiverRepository repository;

    public AuthorizedReceiverService(AuthorizedReceiverRepository repository) {
        this.repository = repository;
    }

    public void create(){

    }

    public int updateAuthorization(Long id, boolean active){
        return repository.updateAuthorizedStatus(id, active);
    }
}
