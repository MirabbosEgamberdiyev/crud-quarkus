package uz.fido.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uz.fido.models.Product;

import java.util.List;

import jakarta.inject.Inject;
import uz.fido.dto.ProductDTO;
import uz.fido.mapper.ProductMapper;
import uz.fido.models.Category;

import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    CategoryService categoryService;

    public List<ProductDTO> listAll() {
        return Product.<Product>listAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        Product product = Product.findById(id);
        return ProductMapper.toDTO(product);
    }

    @Transactional
    public ProductDTO create(ProductDTO dto) {
        Category category = categoryService.findById(dto.categoryId);
        Product product = ProductMapper.toEntity(dto, category);
        product.persist();
        return ProductMapper.toDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        Product product = Product.findById(id);
        if (product == null) return null;

        Category category = categoryService.findById(dto.categoryId);
        ProductMapper.updateEntity(product, dto, category);
        return ProductMapper.toDTO(product);
    }

    @Transactional
    public boolean delete(Long id) {
        return Product.deleteById(id);
    }
}
