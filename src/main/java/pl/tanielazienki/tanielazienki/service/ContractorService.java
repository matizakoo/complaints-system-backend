package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.dto.ContractorDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

import java.util.List;

public interface ContractorService {
    void remove(Integer id);
    void update(ContractorDTO contractorDTO);
    void save(ContractorDTO contractorDTO) ;
    void save(ContractorEntity CcntractorEntity) ;
    void create(String category);
    List<ContractorDTO> getAll();
}
