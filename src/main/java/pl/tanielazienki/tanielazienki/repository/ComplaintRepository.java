package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Integer> {
}
