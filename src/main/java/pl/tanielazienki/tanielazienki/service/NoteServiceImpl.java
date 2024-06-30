package pl.tanielazienki.tanielazienki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.dto.NoteDTO;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;
import pl.tanielazienki.tanielazienki.mapper.NoteMapper;
import pl.tanielazienki.tanielazienki.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    @Override
    @Transactional
    public void createNote(NoteDTO noteDTO) {
        noteRepository.save(noteMapper.mapNoteDTOToNoteEntity(noteDTO));
    }

    @Override
    @Transactional
    public void createNoteEntity(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
    }
}
