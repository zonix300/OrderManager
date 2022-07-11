package rinka.com.order;

import java.util.Arrays;
import java.util.Date;

public class Demo{

    public static void main (String[] args) {


        Customer customer1 = new Customer("Женя", "Харьков", "Женщина");
        Customer customer2 = new Customer("Алекс", "Киев", "Мужчина");


        ElectronicsOrder order1 = new ElectronicsOrder("Phone", new Date(), "Киев", "Харьков", 1000, customer1, 12);
        FurnitureOrder order2 = new FurnitureOrder("Chair", new Date(), "Киев", "Харьков",600, customer2, "097689");

        System.out.println(order2.getDateCreated());
    }
}
