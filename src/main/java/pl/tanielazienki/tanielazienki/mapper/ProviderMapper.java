package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nameOfProvider", target = "nameOfProvider")
    })
    ProviderEntity mapProviderDTOToProviderEntity(pl.tanielazienki.tanielazienki.dto.ProviderDTO providerDTO);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nameOfProvider", target = "nameOfProvider")
    })
    pl.tanielazienki.tanielazienki.dto.ProviderDTO mapProviderEntityToProviderDTO(ProviderEntity providerEntity);
}
