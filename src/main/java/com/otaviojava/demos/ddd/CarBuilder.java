package com.otaviojava.demos.ddd;


public class CarBuilder {
    private String vin;
    private String transmission;
    private Manufacturer manufacturer;
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

    public CarBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public Car build() {
        return new Car(vin, transmission, manufacturer, color);
    }
}
