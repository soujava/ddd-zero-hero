package com.otaviojava.demos.ddd;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import net.datafaker.providers.base.Vehicle;

import java.time.Year;
import java.util.Objects;

@Entity
public class Car {

    @Id
    private String vin;

    @Column
    private String transmission;

    @Column
    private Manufacturer manufacturer;

    @Column
    private Color color;

    @Deprecated
    Car() {
    }

    Car(String vin, String transmission, Manufacturer manufacturer, Color color) {
        this.vin = vin;
        this.transmission = transmission;
        this.manufacturer = manufacturer;
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
                ", color=" + color +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public static Car of(Vehicle vehicle) {
        return builder()
                .vin(vehicle.vin())
                .transmission(vehicle.transmission())
                .manufacturer(new Manufacturer(vehicle.manufacturer(), vehicle.model()))
                .color(Color.valueOf(vehicle.color().toUpperCase()))
                .build();
    }
}
