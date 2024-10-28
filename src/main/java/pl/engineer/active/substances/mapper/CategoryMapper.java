package pl.tanielazienki.tanielazienki.mapper;

import jdk.jfr.Category;
import org.mapstruct.Mapper;
import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity mapCategoryDTOToCategoryEntity(CategoryDTO categoryDTO);
    CategoryDTO mapCategoryEntityToCategoryDTO(CategoryEntity categoryEntity);
}
