package pl.engineer.active.substances.service;

import pl.engineer.active.substances.dto.ProviderDTO;
import pl.engineer.active.substances.entity.ProviderEntity;

import java.util.List;

public interface ProviderService {
    void remove(Integer id);

    void update(ProviderDTO providerDTO);

    void save(ProviderDTO providerDTO) ;
    void save(ProviderEntity provider) ;

    void create(String category);
    List<ProviderDTO> getAll();

    ProviderEntity findByNameOfProvider(String category);
    String commonProvider();
}
