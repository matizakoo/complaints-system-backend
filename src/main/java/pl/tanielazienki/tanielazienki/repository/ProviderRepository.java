package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {
    ProviderEntity findByNameOfProvider(String nameOfProvider);

    @Query("SELECT p.nameOfProvider FROM ProviderEntity p GROUP BY p.nameOfProvider ORDER BY COUNT(p) DESC, p.nameOfProvider ASC")
    List<String> commonProvider();
}
