package pl.engineer.active.substances.mapper;

import org.mapstruct.Mapper;
import pl.engineer.active.substances.dto.CategoryDTO;
import pl.engineer.active.substances.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity mapCategoryDTOToCategoryEntity(CategoryDTO categoryDTO);
    CategoryDTO mapCategoryEntityToCategoryDTO(CategoryEntity categoryEntity);
}
