package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

import java.util.List;

public interface ProviderService {
    void remove(Integer id);

    void update(pl.tanielazienki.tanielazienki.dto.ProviderDTO providerDTO);

    void save(pl.tanielazienki.tanielazienki.dto.ProviderDTO providerDTO) ;
    void save(ProviderEntity provider) ;

    void create(String category);
    List<pl.tanielazienki.tanielazienki.dto.ProviderDTO> getAll();

    ProviderEntity findByNameOfProvider(String category);
}
