package pl.engineer.active.substances.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import pl.engineer.active.substances.dto.ContractorDTO;

import java.util.List;

public interface ContractorController {
    ResponseEntity<?> createContractor(@RequestBody String category);
    ResponseEntity<?> deleteContractor(@RequestBody Integer categoryId);
    ResponseEntity<?> editContractor();
    ResponseEntity<?> updateContractor();
    ResponseEntity<List<ContractorDTO>> getContractors();
    ResponseEntity<?> patchContractor(@RequestBody ContractorDTO contractorDTO, @RequestBody String newContractorName);
    ResponseEntity<String> commonContractor();
}
