package br.com.packcontrol.repository;

import br.com.packcontrol.model.Doorman;
import br.com.packcontrol.model.enums.DoormanShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoormanRepository extends JpaRepository<Doorman, Long> {
    Optional<Doorman> findByCpf(String cpf);
    Optional<List<Doorman>> findAllByShift(DoormanShift shift);
}
