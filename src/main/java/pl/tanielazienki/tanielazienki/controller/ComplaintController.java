package pl.tanielazienki.tanielazienki.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.dto.ProviderDTO;

import java.util.List;

public interface ComplaintController {
    ResponseEntity<?> createComplaint(@RequestBody ComplaintDTO complaintDTO);
    ResponseEntity<?> deleteComplaint(@RequestBody String complaintId);
    ResponseEntity<?> editComplaint();
    ResponseEntity<?> updateComplaint();
    ResponseEntity<List<ComplaintDTO>> getComplaint();
    ResponseEntity<?> patchComplaint(@RequestBody ComplaintDTO complaintDTO, @RequestParam("id") Integer id);
}
