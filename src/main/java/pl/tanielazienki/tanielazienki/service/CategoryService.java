package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    void remove(Integer id);

    void update(CategoryDTO categoryDTO);

    void save(CategoryDTO categoryDTO) ;
    void save(CategoryEntity categoryEntity) ;

    void create(String category);
    List<CategoryDTO> getAll();

    CategoryEntity findByCategory(String category);
}
