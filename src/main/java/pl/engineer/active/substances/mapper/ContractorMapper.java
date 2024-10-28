package pl.engineer.active.substances.mapper;

import org.mapstruct.Mapper;
import pl.engineer.active.substances.dto.ContractorDTO;
import pl.engineer.active.substances.entity.ContractorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractorMapper {
    ContractorEntity mapContractorDTOToContractorEntity(ContractorDTO contractorDTO);
    ContractorDTO mapContractorEntityToContractorDTO(ContractorEntity contractorEntity);
    List<ContractorDTO> mapContractorEntityToContractorDTOList(List<ContractorEntity> contractorEntity);
}
