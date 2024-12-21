package com.otaviojava.demos.ddd;

import java.time.Year;

public class Car {

    private String vin;

    private String transmission;

    private Manufacturer manufacturer;

    private Year year;

    private Color color;

    Car(String vin, String transmission, Manufacturer manufacturer, Year year, Color color) {
        this.vin = vin;
        this.transmission = transmission;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
    }
}
