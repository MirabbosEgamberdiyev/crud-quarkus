package uz.fido.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class Category extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    public String description;
}
