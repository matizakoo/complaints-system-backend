package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Integer> {
}
