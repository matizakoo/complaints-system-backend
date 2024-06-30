package pl.tanielazienki.tanielazienki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.dto.ContractorDTO;
import pl.tanielazienki.tanielazienki.service.ContractorServiceImpl;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/contractor")
public class ContractorControllerImpl implements ContractorController {
    @Autowired
    private ContractorServiceImpl contractorService;
    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createContractor(String contractor) {
        contractorService.create(contractor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteContractor(Integer contractorId) {
        contractorService.remove(contractorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> editContractor() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateContractor() {
        return null;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContractorDTO>> getContractors() {
        return ResponseEntity.ok(contractorService.getAll());
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchContractor(@RequestBody ContractorDTO contractorDTO, @RequestParam("newContractorName") String newContractorName) {
        contractorDTO.setContractorName(newContractorName);
        contractorService.update(contractorDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
