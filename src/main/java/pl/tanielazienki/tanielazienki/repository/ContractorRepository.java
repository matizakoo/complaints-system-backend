package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

@Repository
public interface ContractorRepository extends JpaRepository<ContractorEntity, Integer> {
    ContractorEntity findByContractorName(String contractorName);
}
