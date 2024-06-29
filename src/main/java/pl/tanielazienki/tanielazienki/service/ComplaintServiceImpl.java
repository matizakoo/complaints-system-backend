package pl.tanielazienki.tanielazienki.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.mapper.ComplaintMapper;
import pl.tanielazienki.tanielazienki.repository.ComplaintRepository;

import java.util.List;

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
}
