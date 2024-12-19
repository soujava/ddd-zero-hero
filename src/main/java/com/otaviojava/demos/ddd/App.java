/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package com.otaviojava.demos.ddd;



import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;
import net.datafaker.providers.base.Commerce;

import java.util.List;
import java.util.Set;
import java.util.UUID;


public class App {


    public static void main(String[] args) {
        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Manufacturer manufacturer = new Manufacturer(faker.company().name(), faker.address().fullAddress(), faker.phoneNumber().cellPhone());
            Set<Category> categories = Set.of(new Category("category1", "description1"), new Category("category2", "description2"));
            Commerce commerce = faker.commerce();
            Product product = new ProductBuilder()
                    .id(UUID.randomUUID())
                    .name(commerce.productName())
                    .manufacturer(manufacturer)
                    .tags(List.of("tag1", "tag2"))
                    .categories(categories)
                    .build();
        }
    }

    private App() {
    }
}
