package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;
import pl.tanielazienki.tanielazienki.entity.ProviderEntity;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {
    ProviderEntity findByNameOfProvider(String nameOfProvider);
}
