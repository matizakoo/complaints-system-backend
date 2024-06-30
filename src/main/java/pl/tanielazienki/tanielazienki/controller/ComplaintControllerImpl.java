package pl.tanielazienki.tanielazienki.controller;

import freemarker.core._ArrayEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.dto.ComplaintDTO;
import pl.tanielazienki.tanielazienki.dto.NoteDTO;
import pl.tanielazienki.tanielazienki.entity.ComplaintEntity;
import pl.tanielazienki.tanielazienki.entity.NoteEntity;
import pl.tanielazienki.tanielazienki.mapper.ComplaintMapper;
import pl.tanielazienki.tanielazienki.service.ComplaintServiceImpl;
import pl.tanielazienki.tanielazienki.service.NoteServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintControllerImpl implements ComplaintController{
    @Autowired
    private ComplaintServiceImpl complaintService;
    @Autowired
    private NoteServiceImpl noteService;
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
    public ResponseEntity<?> patchComplaintStatus(@RequestParam("id") String id,
                                                  @RequestParam("status") String status) {
        ComplaintEntity complaintEntity = complaintService.findById(Integer.valueOf(id));
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

    @Override
    @PostMapping(value = "/note")
    public ResponseEntity<?> addNote(
            @RequestParam("id") String id,
            @RequestParam("noteContent") String noteContent,
            @RequestParam("principal") String principal
            ) {
        NoteEntity noteEntity = NoteEntity.builder()
                .publisher(principal)
                .dateTime(LocalDateTime.now())
                .note(noteContent)
                .complaintEntity(complaintService.findById(Integer.valueOf(id)))
                        .build();
        noteService.createNoteEntity(noteEntity);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
