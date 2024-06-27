package pl.tanielazienki.tanielazienki.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;

import javax.faces.annotation.RequestMap;
import java.util.List;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintControllerImpl implements ComplaintController{

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createComplaint(@RequestBody ComplaintDTO complaintDTO) {

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
    public ResponseEntity<List<ComplaintDTO>> getComplaint() {
        return null;
    }

    @Override
    public ResponseEntity<?> patchComplaint(ComplaintDTO complaintDTO, Integer id) {
        return null;
    }
}
