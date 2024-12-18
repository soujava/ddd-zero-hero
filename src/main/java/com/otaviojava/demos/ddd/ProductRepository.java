package com.otaviojava.demos.ddd;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface ProductRepository extends BasicRepository<Product, String> {
}
