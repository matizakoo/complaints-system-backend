package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    ComplaintEntity mapComplaintDTOToComplaintEntity(ComplaintDTO complaintDTO);
    ComplaintDTO mapComplaintEntityToComplaintDTO(ComplaintEntity complaintEntity);
    List<ComplaintDTO> mapComplaintEntityToComplaintDTOList(List<ComplaintEntity> complaintEntityList);
}
