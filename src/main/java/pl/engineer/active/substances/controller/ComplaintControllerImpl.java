package pl.engineer.active.substances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.engineer.active.substances.dto.ComplaintDTO;
import pl.engineer.active.substances.entity.ComplaintEntity;
import pl.engineer.active.substances.service.ComplaintServiceImpl;
import pl.engineer.active.substances.entity.NoteEntity;
import pl.engineer.active.substances.service.NoteServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintControllerImpl implements ComplaintController{
    @Autowired
    private ComplaintServiceImpl complaintService;
    @Autowired
    private NoteServiceImpl noteService;

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

    @Override
    @GetMapping("/amountOfReports")
    public ResponseEntity<?> amountOfAllComplaintsInYear() {
        return ResponseEntity.ok(complaintService.amountOfComplaintsInYear(String.valueOf(LocalDate.now().getYear())));
    }

    @Override
    @GetMapping("/amountOfComplaintsThisWeek")
    public ResponseEntity<?> amountOfComplaintsThisWeek() {
        return ResponseEntity.ok(complaintService.amountOfComplaintsThisWeek());
    }

    @Override
    @GetMapping("/complaintsChart")
    public ResponseEntity<?> getDataForComplaintsChart() {
        return ResponseEntity.ok(complaintService.getAmountOfComplaintsByMonth());
    }

    @Override
    @GetMapping("/expiresInTwoDays")
    public ResponseEntity<?> getExpiresInTwoDays() {
        return ResponseEntity.ok(complaintService.complaintsExpiresInTwoDays());
    }
}
