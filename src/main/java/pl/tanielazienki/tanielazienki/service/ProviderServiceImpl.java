package pl.tanielazienki.tanielazienki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.dto.ProviderDTO;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;
import pl.tanielazienki.tanielazienki.exception.CategoryException;
import pl.tanielazienki.tanielazienki.repository.ProviderRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private ProviderRepository providerRepository;
    @Override
    @Transactional
    public void remove(Integer id) {
        providerRepository.deleteById(id);
    }

    @Override
    public void update(ProviderDTO providerDTO) {
        ProviderEntity providerEntity = null;
        providerEntity = providerRepository.findById(providerDTO.getId()).get();

        providerEntity.setNameOfProvider(providerDTO.getNameOfProvider());
        save(providerEntity);
    }

    @Override
    public void save(ProviderDTO providerDTO) {
        ProviderEntity categoryEntity = providerRepository.findById(providerDTO.getId()).get();
        ProviderEntity categoryEntity2 = new ProviderEntity(categoryEntity.getId(), providerDTO.getNameOfProvider());
        providerRepository.save(categoryEntity2);
    }

    @Override
    public void save(ProviderEntity provider) {
        providerRepository.save(provider);
    }

    @Override
    public void create(String category) {
        if(findByNameOfProvider(category) == null) {
            ProviderEntity categoryEntity = new ProviderEntity(category);
            save(categoryEntity);
        } else {
            throw new CategoryException("Kategoria już istnieje");
        }
    }

    @Override
    public List<ProviderDTO> getAll() {
        List<ProviderEntity> categoryEntityList = providerRepository.findAll();
        List<ProviderDTO> providerDTOList = new ArrayList<>();
        for(ProviderEntity entity: categoryEntityList) {
            providerDTOList.add(new ProviderDTO(entity.getId(), entity.getNameOfProvider()));
        }
        providerDTOList.sort(Comparator.comparing(ProviderDTO::getId));
        return providerDTOList;
    }

    @Override
    public ProviderEntity findByNameOfProvider(String category) {
        return providerRepository.findByNameOfProvider(category);
    }
}
