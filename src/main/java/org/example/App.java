package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        final Shop shop = new Shop();
        final int SELLER = 10;
        Random random = new Random();

        List<String> nameSell = new ArrayList<String>(4);
        nameSell.add("Покупатель 1");
        nameSell.add("Покупатель 2");
        nameSell.add("Покупатель 3");

        for(int i = 0; i < SELLER; i++){
            new Thread(null, shop::sellCar, nameSell.get(random.ints(0,3).findFirst().getAsInt())).start();
        }

        for(int i = 0; i < SELLER; i++){
            new Thread(null, shop::acceptCar, "Фабрика автомобилей").start();
        }
    }
}
