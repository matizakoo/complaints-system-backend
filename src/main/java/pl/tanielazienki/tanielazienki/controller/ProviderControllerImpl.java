package pl.tanielazienki.tanielazienki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.dto.ProviderDTO;
import pl.tanielazienki.tanielazienki.service.CategoryServiceImpl;
import pl.tanielazienki.tanielazienki.service.ProviderServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

@RestController
@RequestMapping("/provider")
public class ProviderControllerImpl implements ProviderController {
    @Autowired
    private ProviderServiceImpl providerService;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProvider(@RequestBody String providerName) {
        try {
            providerService.create(providerName);
            return ResponseEntity.ok().body("{\"message\":\"Category created successfully\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Failed to create category: " + e.getMessage() + "\"}");
        }
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchProvider(@RequestBody ProviderDTO providerDTO, @RequestParam("newCategoryName") String newProviderName) {
        providerDTO.setNameOfProvider(newProviderName);
        providerService.update(providerDTO);
        return null;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProviderDTO>> getProvider() {
        return ResponseEntity.of(Optional.ofNullable(providerService.getAll()));
    }



    @Override
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProvider(@RequestBody String categoryId) {
        providerService.remove(Integer.valueOf(categoryId));
        return ResponseEntity.ok().body("");
    }

    @Override
    @PatchMapping
    public ResponseEntity<?> editProvider() {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<?> updateProvider() {
        return null;
    }
}
