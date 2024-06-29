package pl.tanielazienki.tanielazienki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Integer> {
    @Query("SELECT c FROM ComplaintEntity c " +
            "WHERE c.status = 'NOWE' OR c.status = 'REALIZOWANE' " +
            "ORDER BY c.dataOfReportAnswer ASC")
    List<ComplaintEntity> findAllNotReadySortedByDataOfReportAnswerDesc();
}
