package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);

    public void sellCar() {
        seller.sellBread();
    }

    public void acceptCar() {
        seller.receiveCar();
    }

    public List<Car> getCar() {
        return cars;
    }
}
