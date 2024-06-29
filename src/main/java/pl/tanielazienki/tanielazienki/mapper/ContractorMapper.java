package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractorMapper {
    ContractorEntity mapContractorDTOToContractorEntity(pl.tanielazienki.tanielazienki.dto.ContractorDTO contractorDTO);
    pl.tanielazienki.tanielazienki.dto.ContractorDTO mapContractorEntityToContractorDTO(ContractorEntity contractorEntity);
    List<pl.tanielazienki.tanielazienki.dto.ContractorDTO> mapContractorEntityToContractorDTOList(List<ContractorEntity> contractorEntity);
}
