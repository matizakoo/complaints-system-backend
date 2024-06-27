package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.dto.ContractorDTO;
import pl.tanielazienki.tanielazienki.entity.ContractorEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractorMapper {
    ContractorEntity mapContractorDTOToContractorEntity(ContractorDTO contractorDTO);
    ContractorDTO mapContractorEntityToContractorDTO(ContractorEntity contractorEntity);
    List<ContractorDTO> mapContractorEntityToContractorDTOList(List<ContractorEntity> contractorEntity);
}
