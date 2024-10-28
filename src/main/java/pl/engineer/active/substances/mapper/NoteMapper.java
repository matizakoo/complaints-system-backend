package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import pl.tanielazienki.tanielazienki.dto.NoteDTO;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;

@Mapper(
        componentModel = "spring",
        uses = {ComplaintMapper.class}
)
public interface NoteMapper {
    NoteEntity mapNoteDTOToNoteEntity(NoteDTO noteDTO);
}
