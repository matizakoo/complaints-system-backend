package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
}
