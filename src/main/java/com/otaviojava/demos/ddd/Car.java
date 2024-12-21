package com.otaviojava.demos.ddd;

import java.time.Year;
import java.util.Objects;

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

    public String getVin() {
        return vin;
    }

    public String getTransmission() {
        return transmission;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Year getYear() {
        return year;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", transmission='" + transmission + '\'' +
                ", manufacturer=" + manufacturer +
                ", year=" + year +
                ", color=" + color +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }
}
