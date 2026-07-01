package br.com.packcontrol.repository;

import br.com.packcontrol.model.Doorman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoormanRepository extends JpaRepository<Doorman, Long> {
    Optional<Doorman> findByCpf(String cpf);
}
