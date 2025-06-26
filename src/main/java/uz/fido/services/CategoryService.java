package uz.fido.services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uz.fido.dto.CategoryDTO;
import uz.fido.mapper.CategoryMapper;
import uz.fido.models.Category;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoryService {

    public List<CategoryDTO> listAll() {
        return Category.<Category>listAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Category findById(Long id) {
        return Category.findById(id);
    }

    public CategoryDTO getDTOById(Long id) {
        return CategoryMapper.toDTO(findById(id));
    }

    @Transactional
    public CategoryDTO create(CategoryDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        category.persist();
        return CategoryMapper.toDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category category = Category.findById(id);
        if (category == null) return null;

        CategoryMapper.updateEntity(category, dto);
        return CategoryMapper.toDTO(category);
    }

    @Transactional
    public boolean delete(Long id) {
        return Category.deleteById(id);
    }
}
