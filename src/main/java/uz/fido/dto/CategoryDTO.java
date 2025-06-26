package uz.fido.dto;

import jakarta.persistence.Column;


public class CategoryDTO {

    @Column(nullable = false)
    public String name;

    public String description;
}
