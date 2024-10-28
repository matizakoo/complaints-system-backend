package pl.engineer.active.substances.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.engineer.active.substances.dto.ProviderDTO;

import java.util.List;

public interface ProviderController {
    ResponseEntity<?> createProvider(@RequestBody String category);
    ResponseEntity<?> deleteProvider(@RequestBody String categoryId);
    ResponseEntity<?> editProvider();
    ResponseEntity<?> updateProvider();
    ResponseEntity<List<ProviderDTO>> getProvider();
    ResponseEntity<?> patchProvider(@RequestBody ProviderDTO providerDTO, @RequestParam("newCategoryName") String newProviderName);
    ResponseEntity<?> commonProvider();
}
