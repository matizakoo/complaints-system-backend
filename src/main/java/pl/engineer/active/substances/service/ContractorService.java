package pl.engineer.active.substances.service;

import pl.engineer.active.substances.dto.ContractorDTO;
import pl.engineer.active.substances.entity.ContractorEntity;

import java.util.List;

public interface ContractorService {
    void remove(Integer id);
    void update(ContractorDTO contractorDTO);
    void save(ContractorDTO contractorDTO) ;
    void save(ContractorEntity CcntractorEntity) ;
    void create(String category);
    List<ContractorDTO> getAll();
    String commonContractor();
}
