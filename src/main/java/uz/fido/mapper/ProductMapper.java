package uz.fido.mapper;

import uz.fido.dto.ProductDTO;
import uz.fido.models.Product;
import uz.fido.models.Category;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;

        ProductDTO dto = new ProductDTO();
        dto.name = product.name;
        dto.price = product.price;
        dto.quantity = product.quantity;
        dto.description = product.description;
        dto.categoryId = product.category != null ? product.category.id : null;
        return dto;
    }

    public static Product toEntity(ProductDTO dto, Category category) {
        Product product = new Product();
        product.name = dto.name;
        product.price = dto.price;
        product.quantity = dto.quantity;
        product.description = dto.description;
        product.category = category;
        return product;
    }

    public static void updateEntity(Product product, ProductDTO dto, Category category) {
        product.name = dto.name;
        product.price = dto.price;
        product.quantity = dto.quantity;
        product.description = dto.description;
        product.category = category;
    }
}
