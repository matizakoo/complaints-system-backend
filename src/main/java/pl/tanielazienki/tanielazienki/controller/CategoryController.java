package pl.tanielazienki.tanielazienki.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tanielazienki.tanielazienki.dto.CategoryDTO;

import java.util.List;

public interface CategoryController {
    ResponseEntity<?> createCategory(@RequestBody String category);
    ResponseEntity<?> deleteCategory(@RequestBody String categoryId);
    ResponseEntity<?> editCategory();
    ResponseEntity<?> updateCategory();
    ResponseEntity<List<CategoryDTO>> getCategory();
    ResponseEntity<?> patchCategory(@RequestBody CategoryDTO categoryDTO, @RequestBody String newCategoryName);
}
