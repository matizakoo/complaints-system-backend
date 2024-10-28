package pl.engineer.active.substances.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import pl.engineer.active.substances.dto.CategoryDTO;

import java.util.List;

public interface CategoryController {
    ResponseEntity<?> createCategory(@RequestBody String category);
    ResponseEntity<?> deleteCategory(@RequestBody String categoryId);
    ResponseEntity<?> editCategory();
    ResponseEntity<?> updateCategory();
    ResponseEntity<List<CategoryDTO>> getCategory();
    ResponseEntity<?> patchCategory(@RequestBody CategoryDTO categoryDTO, @RequestBody String newCategoryName);
}
