package pl.engineer.active.substances.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineer.active.substances.dto.NoteDTO;
import pl.engineer.active.substances.entity.NoteEntity;
import pl.engineer.active.substances.mapper.NoteMapper;
import pl.engineer.active.substances.repository.NoteRepository;

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
