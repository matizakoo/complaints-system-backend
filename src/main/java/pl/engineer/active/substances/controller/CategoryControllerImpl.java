package pl.engineer.active.substances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.engineer.active.substances.service.CategoryServiceImpl;
import pl.engineer.active.substances.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController{
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCategory(@RequestBody String category) {
        try {
            categoryServiceImpl.create(category);
            return ResponseEntity.ok().body("{\"message\":\"Category created successfully\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Failed to create category: " + e.getMessage() + "\"}");
        }
    }

    @Override
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchCategory(@RequestBody CategoryDTO categoryDTO, @RequestParam("newCategoryName") String newCategoryName) {
        categoryDTO.setCategory(newCategoryName);
        categoryServiceImpl.update(categoryDTO);
        return null;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> getCategory() {
        return ResponseEntity.of(Optional.ofNullable(categoryServiceImpl.getAll()));
    }



    @Override
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCategory(@RequestBody String categoryId) {
        categoryServiceImpl.remove(Integer.valueOf(categoryId));
        return ResponseEntity.ok().body("");
    }

    @Override
    @PatchMapping
    public ResponseEntity<?> editCategory() {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<?> updateCategory() {
        return null;
    }
}
