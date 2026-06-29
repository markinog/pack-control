package br.com.packcontrol.repository;

import br.com.packcontrol.model.PackageHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageHistoryRepository extends MongoRepository<PackageHistory, String> {
}
