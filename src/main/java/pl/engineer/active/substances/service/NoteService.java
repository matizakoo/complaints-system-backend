package pl.engineer.active.substances.service;

import pl.engineer.active.substances.dto.NoteDTO;
import pl.engineer.active.substances.entity.NoteEntity;

public interface NoteService {
    void createNote(NoteDTO noteDTO);
    void createNoteEntity(NoteEntity noteEntity);
}
