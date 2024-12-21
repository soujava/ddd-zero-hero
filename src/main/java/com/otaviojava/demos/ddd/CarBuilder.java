package com.otaviojava.demos.ddd;

import java.time.Year;

public class CarBuilder {
    private String vin;
    private String transmission;
    private Manufacturer manufacturer;
    private Year year;
    private Color color;

    CarBuilder() {
    }

    public CarBuilder vin(String vin) {
        this.vin = vin;
        return this;
    }

    public CarBuilder transmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder manufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public CarBuilder year(Year year) {
        this.year = year;
        return this;
    }

    public CarBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public Car build() {
        return new Car(vin, transmission, manufacturer, year, color);
    }
}
