package com.otaviojava.demos.ddd;

import jakarta.data.repository.By;
import jakarta.data.repository.Delete;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

@Repository
public interface Garage {

    @Save
    Car park(Car car);

    @Delete
    void unpark(Car car);

    @Find
    Car checkRegistration(@By("vin") String vin);
}
