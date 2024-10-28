package pl.engineer.active.substances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.engineer.active.substances.entity.ComplaintEntity;

import java.time.LocalDate;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity, Integer> {
    @Query("SELECT c FROM ComplaintEntity c " +
            "WHERE c.status = 'NOWE' OR c.status = 'REALIZOWANE' " +
            "ORDER BY c.dataOfReportAnswer ASC")
    List<ComplaintEntity> findAllNotReadySortedByDataOfReportAnswerDesc();


    @Query("SELECT COUNT(r) FROM ComplaintEntity r WHERE FUNCTION('YEAR', r.dataOfReport) = :year")
    Integer getAmountOfComplaintsInYear(String year);

    @Query(value = "SELECT COUNT(*) FROM complaint WHERE YEAR(data_of_report) = YEAR(CURDATE()) AND WEEK(data_of_report) = WEEK(CURDATE())", nativeQuery = true)
    Integer getAmountOfComplaintsThisWeek();

    @Query("SELECT MONTH(c.dataOfReport), COUNT(c) FROM ComplaintEntity c WHERE YEAR(c.dataOfReport) = :year GROUP BY MONTH(c.dataOfReport) ORDER BY MONTH(c.dataOfReport)")
    List<Object[]> getAmountOfComplaintsByMonth(int year);

    @Query("SELECT c FROM ComplaintEntity c WHERE c.status = 'NOWE' AND c.dataOfReportAnswer <= :todayPlus3Days")
    List<ComplaintEntity> complaintsExpiresInTwoDays(LocalDate today, LocalDate todayPlus3Days);
}
