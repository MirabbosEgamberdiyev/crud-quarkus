package uz.fido.mapper;

import uz.fido.dto.CategoryDTO;
import uz.fido.models.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        if (category == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.name = category.name;
        dto.description = category.description;
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.name = dto.name;
        category.description = dto.description;
        return category;
    }

    public static void updateEntity(Category category, CategoryDTO dto) {
        category.name = dto.name;
        category.description = dto.description;
    }
}
