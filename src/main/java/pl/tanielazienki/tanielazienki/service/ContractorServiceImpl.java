package pl.tanielazienki.tanielazienki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.dto.ContractorDTO;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;
import pl.tanielazienki.tanielazienki.exception.ContractorException;
import pl.tanielazienki.tanielazienki.mapper.ContractorMapper;
import pl.tanielazienki.tanielazienki.repository.ContractorRepository;

import java.util.List;

@Service
public class ContractorServiceImpl implements ContractorService{
    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private ContractorMapper contractorMapper;

    @Override
    public void remove(Integer id) {
        contractorRepository.delete(contractorRepository.findById(id).get());
    }

    @Override
    public void update(ContractorDTO contractorDTO) {
        ContractorEntity contractorEntity = null;
        contractorEntity = contractorRepository.findById(contractorDTO.getId()).get();

        contractorEntity.setContractorName(contractorDTO.getContractorName());
        save(contractorEntity);
    }

    @Override
    public void save(ContractorDTO contractorDTO) {

    }

    @Override
    @Transactional
    public void save(ContractorEntity cntractorEntity) {
        contractorRepository.save(cntractorEntity);
    }

    @Override
    public void create(String contractor) {
        ContractorEntity contractorEntity = contractorRepository.findByContractorName(contractor);
        if(contractorEntity != null)
            throw new ContractorException("Nazwa już istnieje");
        save(ContractorEntity.builder().contractorName(contractor).build());
    }

    @Override
    public List<ContractorDTO> getAll() {
        return contractorMapper.mapContractorEntityToContractorDTOList(contractorRepository.findAll());
    }
}
