package pl.tanielazienki.tanielazienki.service;

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
    private ComplaintMapper complaintMapper;

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void update(ComplaintDTO complaintDTO) {

    }

    @Override
    public void save(ComplaintDTO complaintDTO) {

    }

    @Override
    public void save(ComplaintEntity complaintEntity) {

    }

    @Override
    public void create(String category) {

    }

    @Override
    public List<ComplaintDTO> getAll() {
//        complaintRepository.findAll()
        return null;
    }
}
