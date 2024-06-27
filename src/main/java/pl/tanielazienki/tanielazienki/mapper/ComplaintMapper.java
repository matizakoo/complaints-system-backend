package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    ComplaintEntity mapComplaintDTOToComplaintEntity(ComplaintDTO complaintDTO);
    ComplaintDTO mapComplaintEntityToComplaintDTO(ComplaintEntity complaintEntity);
}
