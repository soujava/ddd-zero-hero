package com.otaviojava.demos.ddd;

import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

@Repository
public interface ProductRepository  {

    @Save
    Product save(Product product);
}
