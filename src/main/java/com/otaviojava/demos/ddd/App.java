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
import net.datafaker.providers.base.Vehicle;
import org.eclipse.jnosql.mapping.DatabaseQualifier;

import java.util.logging.Logger;


public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Faker faker = new Faker();
        LOGGER.info("Starting the application");
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var vehicle = faker.vehicle();
            var garage = container.select(Garage.class, DatabaseQualifier.ofDocument()).get();
            Car car = garage.park(garage.park(Car.of(vehicle)));
            LOGGER.info("Saving a car: " + car);
            Car carFound = garage.checkRegistration(car.getVin());
            LOGGER.info("Car found: " + carFound);

        }
        System.exit(0);
    }

    private App() {
    }
}
