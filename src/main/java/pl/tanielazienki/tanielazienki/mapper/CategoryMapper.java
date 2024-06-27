package pl.tanielazienki.tanielazienki.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.tanielazienki.tanielazienki.dto.CategoryDTO;
import pl.tanielazienki.tanielazienki.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "category", target = "category")
    })
    CategoryEntity mapCategoryDTOToCategoryEntity(CategoryDTO CategoryDTO);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "category", target = "category")
    })
    CategoryDTO mapCategoryEntityToCategoryDTO(CategoryEntity CategoryEntity);
}
