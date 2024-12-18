package com.otaviojava.demos.ddd;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private Manufacturer manufacturer;

    @Column
    private List<String> tags;

    @Column
    private Set<Category> categories;

    Product(UUID id, String name, Manufacturer manufacturer,
            List<String> tags,
            Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.tags = tags;
        this.categories = categories;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public List<String> getTags() {
        return tags;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", tags=" + tags +
                ", categories=" + categories +
                '}';
    }
}
