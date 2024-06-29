package pl.tanielazienki.tanielazienki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.mapper.ComplaintMapper;
import pl.tanielazienki.tanielazienki.repository.ComplaintRepository;

import javax.faces.annotation.RequestMap;
import java.util.List;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintControllerImpl implements ComplaintController{
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
        System.out.println(complaintDTO.toString());
        System.out.printf("czy tu wchodzi?");
        complaintRepository.save(complaintMapper.mapComplaintDTOToComplaintEntity(complaintDTO));
        return null;
    }

    @Override
    public ResponseEntity<?> deleteComplaint(String complaintId) {
        return null;
    }

    @Override
    public ResponseEntity<?> editComplaint() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateComplaint() {
        return null;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComplaintDTO>> getComplaint() {
        return ResponseEntity.ok(complaintMapper.mapComplaintEntityListToComplaintDTOList(complaintRepository.findAll()));
    }

    @Override
    public ResponseEntity<?> patchComplaint(ComplaintDTO complaintDTO, Integer id) {
        return null;
    }
}
