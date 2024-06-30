package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.dto.NoteDTO;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;

public interface NoteService {
    void createNote(NoteDTO noteDTO);
    void createNoteEntity(NoteEntity noteEntity);
}
