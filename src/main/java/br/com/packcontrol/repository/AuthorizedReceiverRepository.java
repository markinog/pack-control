package br.com.packcontrol.repository;

import br.com.packcontrol.model.AuthorizedReceiver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorizedReceiverRepository extends JpaRepository<AuthorizedReceiver, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AuthorizedReceiver a SET a.authorized = :authorized WHERE a.cpf = :cpf")
    int updateAuthorizedStatus(@Param("cpf") String cpf, @Param("authorized") boolean authorized);

    Optional<AuthorizedReceiver> findByCpf(String cpf);
    List<AuthorizedReceiver> findAllByResidentId(Long residentId);

}
