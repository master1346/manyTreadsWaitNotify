package org.example;

public class Seller {
    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveCar() {
            try {
                System.out.println("Мерседес поставил в автосалон автомобиль");
                Thread.sleep(3000);
                shop.getCar().add(new Car());
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public synchronized void sellBread() {
        try {
            System.out.println("В магазин пришел " + Thread.currentThread().getName());
            while (shop.getCar().size() == 0) {
                System.out.println("Машин не осталось!!!");
                wait();
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " купил автомобиль");
            shop.getCar().remove(shop.cars.size() - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
