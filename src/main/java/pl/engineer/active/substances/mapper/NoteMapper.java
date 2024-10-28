package pl.engineer.active.substances.mapper;

import org.mapstruct.Mapper;
import pl.engineer.active.substances.dto.NoteDTO;
import pl.engineer.active.substances.entity.NoteEntity;

@Mapper(
        componentModel = "spring",
        uses = {ComplaintMapper.class}
)
public interface NoteMapper {
    NoteEntity mapNoteDTOToNoteEntity(NoteDTO noteDTO);
}
