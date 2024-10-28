package pl.engineer.active.substances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.engineer.active.substances.entity.NoteEntity;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
}
