package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

import java.util.List;

public interface ContractorService {
    void remove(Integer id);
    void update(pl.tanielazienki.tanielazienki.dto.ContractorDTO contractorDTO);
    void save(pl.tanielazienki.tanielazienki.dto.ContractorDTO contractorDTO) ;
    void save(ContractorEntity CcntractorEntity) ;
    void create(String category);
    List<pl.tanielazienki.tanielazienki.dto.ContractorDTO> getAll();
}
