package uz.fido.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public double price;

    public int quantity;

    public String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;
}
