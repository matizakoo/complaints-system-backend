package pl.tanielazienki.tanielazienki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.mapper.ComplaintMapper;
import pl.tanielazienki.tanielazienki.repository.ComplaintRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public void remove(Integer id) {
        complaintRepository.delete(complaintRepository.findById(id).get());
    }

    @Override
    public void update(ComplaintDTO complaintDTO) {

    }

    @Override
    @Transactional
    public void save(ComplaintDTO complaintDTO) {
        complaintRepository.save(complaintMapper.mapComplaintDTOToComplaintEntity(complaintDTO));
    }

    @Override
    @Transactional
    public void save(ComplaintEntity complaintEntity) {
        complaintRepository.save(complaintEntity);
    }

    @Override
    public void create(String category) {

    }

    @Override
    public List<ComplaintDTO> getAll() {
        return complaintMapper.mapComplaintEntityToComplaintDTOList(complaintRepository.findAllNotReadySortedByDataOfReportAnswerDesc());
//        return complaintMapper.mapComplaintEntityListToComplaintDTOList(complaintRepository.findAll());
    }

    @Override
    public ComplaintEntity findById(Integer id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public Integer amountOfComplaintsInYear(String year) {
        return complaintRepository.getAmountOfComplaintsInYear(year);
    }

    @Override
    public Integer amountOfComplaintsThisWeek() {
        System.out.println(complaintRepository.getAmountOfComplaintsThisWeek());
        return complaintRepository.getAmountOfComplaintsThisWeek();
    }

    @Override
    public Map<Integer, Long> getAmountOfComplaintsByMonth() {
        List<Object[]> results = complaintRepository.getAmountOfComplaintsByMonth(LocalDate.now().getYear());
        Map<Integer, Long> complaintsByMonth = new HashMap<>();
        for (Object[] result : results) {
            int month = (int) result[0];
            long count = (long) result[1];
            complaintsByMonth.put(month, count);
        }
        return complaintsByMonth;
    }

    @Override
    public List<ComplaintDTO> complaintsExpiresInTwoDays() {
        return complaintMapper.mapComplaintEntityToComplaintDTOList(complaintRepository.complaintsExpiresInTwoDays(LocalDate.now(), LocalDate.now().plusDays(3)));
    }
}
