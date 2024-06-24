package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.dto.ProviderDTO;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

import java.util.List;

public interface ProviderService {
    void remove(Integer id);

    void update(ProviderDTO providerDTO);

    void save(ProviderDTO providerDTO) ;
    void save(ProviderEntity provider) ;

    void create(String category);
    List<ProviderDTO> getAll();

    ProviderEntity findByNameOfProvider(String category);
}
