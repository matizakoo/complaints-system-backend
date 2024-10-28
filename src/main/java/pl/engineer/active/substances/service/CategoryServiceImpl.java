package pl.engineer.active.substances.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.engineer.active.substances.dto.CategoryDTO;
import pl.engineer.active.substances.entity.CategoryEntity;
import pl.engineer.active.substances.exception.CategoryException;
import pl.engineer.active.substances.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = null;
        categoryEntity = categoryRepository.findById(categoryDTO.getId()).get();

        categoryEntity.setCategory(categoryDTO.getCategory());
        save(categoryEntity);
    }

    @Override
    @Transactional
    public void save(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryDTO.getId()).get();
        CategoryEntity categoryEntity2 = new CategoryEntity(categoryEntity.getId(), categoryDTO.getCategory());
        categoryRepository.save(categoryEntity2);
    }

    @Override
    @Transactional
    public void save(CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
    }


    @Override
    public void create(String category) {
        if(findByCategory(category) == null) {
            CategoryEntity categoryEntity = new CategoryEntity(category);
            save(categoryEntity);
        } else {
            throw new CategoryException("Kategoria już istnieje");
        }
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for(CategoryEntity entity: categoryEntityList) {
            categoryDTOList.add(new CategoryDTO(entity.getId(), entity.getCategory()));
        }
        categoryDTOList.sort(Comparator.comparing(CategoryDTO::getId));
        return categoryDTOList;
    }

    @Override
    @Transactional
    public CategoryEntity findByCategory(String category) {
        return categoryRepository.findByCategory(category);
    }
}
