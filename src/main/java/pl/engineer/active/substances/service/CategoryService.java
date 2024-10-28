package pl.tanielazienki.tanielazienki.service;

import pl.tanielazienki.tanielazienki.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    void remove(Integer id);

    void update(pl.tanielazienki.tanielazienki.dto.CategoryDTO categoryDTO);

    void save(pl.tanielazienki.tanielazienki.dto.CategoryDTO categoryDTO) ;
    void save(CategoryEntity categoryEntity) ;

    void create(String category);
    List<pl.tanielazienki.tanielazienki.dto.CategoryDTO> getAll();

    CategoryEntity findByCategory(String category);
}
