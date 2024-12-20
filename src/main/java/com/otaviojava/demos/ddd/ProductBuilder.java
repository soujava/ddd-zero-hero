package com.otaviojava.demos.ddd;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ProductBuilder {
    private UUID id;
    private String name;
    private Manufacturer manufacturer;
    private List<String> tags;
    private Set<Category> categories;

    public ProductBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder manufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public ProductBuilder tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProductBuilder categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Product build() {
        return new Product(id, name, manufacturer, tags, categories);
    }
}
