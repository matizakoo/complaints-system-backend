package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;

import java.util.List;
import java.util.Map;

public interface ComplaintService {
    void remove(Integer id);
    void update(ComplaintDTO complaintDTO);
    void save(ComplaintDTO complaintDTO) ;
    void save(ComplaintEntity complaintEntity) ;
    void create(String category);
    List<ComplaintDTO> getAll();
    ComplaintEntity findById(Integer id);
    Integer amountOfComplaintsInYear(String year);
    Integer amountOfComplaintsThisWeek();
    Map<Integer, Long> getAmountOfComplaintsByMonth();
    List<ComplaintDTO> complaintsExpiresInTwoDays();
}
