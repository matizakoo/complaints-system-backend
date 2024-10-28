package pl.engineer.active.substances.mapper;

import org.mapstruct.Mapper;
import pl.engineer.active.substances.dto.ComplaintDTO;
import pl.engineer.active.substances.entity.ComplaintEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    ComplaintEntity mapComplaintDTOToComplaintEntity(ComplaintDTO complaintDTO);
    ComplaintDTO mapComplaintEntityToComplaintDTO(ComplaintEntity complaintEntity);
    List<ComplaintDTO> mapComplaintEntityToComplaintDTOList(List<ComplaintEntity> complaintEntityList);
}
