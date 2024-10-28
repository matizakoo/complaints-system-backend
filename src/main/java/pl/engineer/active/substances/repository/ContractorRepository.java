package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

import java.util.List;

@Repository
public interface ContractorRepository extends JpaRepository<ContractorEntity, Integer> {
    ContractorEntity findByContractorName(String contractorName);
    @Query("SELECT p.contractorName FROM ContractorEntity p GROUP BY p.contractorName ORDER BY COUNT(p) DESC, p.contractorName ASC")
    List<String> commonContractor();
}
