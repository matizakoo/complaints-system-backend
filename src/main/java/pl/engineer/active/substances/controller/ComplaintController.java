package pl.tanielazienki.tanielazienki.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;

import java.util.List;

public interface ComplaintController {
    ResponseEntity<?> createComplaint(@RequestBody ComplaintDTO complaintDTO);
    ResponseEntity<?> deleteComplaint(@RequestBody String complaintId);
    ResponseEntity<?> editComplaint();
    ResponseEntity<?> patchComplaintStatus(String id, String status);
    ResponseEntity<List<ComplaintDTO>> getComplaint();
    ResponseEntity<?> patchComplaint(@RequestBody ComplaintDTO complaintDTO, @RequestParam("id") Integer id);
    ResponseEntity<?> addNote(@RequestParam("id") String id,
                              @RequestParam("status") String status,
                              @RequestParam("principal") String principal);

    ResponseEntity<?> amountOfAllComplaintsInYear();
    ResponseEntity<?> amountOfComplaintsThisWeek();
    ResponseEntity<?> getDataForComplaintsChart();
    ResponseEntity<?> getExpiresInTwoDays();
}
