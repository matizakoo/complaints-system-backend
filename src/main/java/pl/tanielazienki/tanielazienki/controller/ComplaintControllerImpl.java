package pl.tanielazienki.tanielazienki.controller;

import io.swagger.v3.oas.annotations.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.mapper.ComplaintMapper;
import pl.tanielazienki.tanielazienki.repository.ComplaintRepository;
import pl.tanielazienki.tanielazienki.service.ComplaintService;
import pl.tanielazienki.tanielazienki.service.ComplaintServiceImpl;

import javax.faces.annotation.RequestMap;
import java.util.List;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintControllerImpl implements ComplaintController{
    @Autowired
    private ComplaintServiceImpl complaintService;
    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
        complaintDTO.setStatus("NOWE");
        complaintService.save(complaintDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteComplaint(@RequestBody String complaintId) {
        complaintService.remove(Integer.valueOf(complaintId));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> editComplaint() {
        return null;
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateComplaintStatus(@RequestParam("id") Integer id,
                                                   @RequestParam("status") String status) {
        ComplaintEntity complaintEntity = complaintService.findById(id);
        complaintEntity.setStatus(status);
        complaintService.save(complaintEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComplaintDTO>> getComplaint() {
        return ResponseEntity.ok(complaintService.getAll());
    }

    @Override
    public ResponseEntity<?> patchComplaint(ComplaintDTO complaintDTO, Integer id) {
        return null;
    }
}
