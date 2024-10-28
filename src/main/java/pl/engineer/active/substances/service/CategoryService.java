package pl.engineer.active.substances.service;

import pl.engineer.active.substances.dto.CategoryDTO;
import pl.engineer.active.substances.entity.CategoryEntity;

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
