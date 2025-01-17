package main.java.org.example.model;

import java.util.ArrayList;

public class Catalog {

    private ArrayList<Item> catalog = new ArrayList<>();


    public Catalog() {
        createCatalog();
    }

    public Item getCatalogItem(int index) {
        return catalog.get(index);
    }

    public void createCatalog() {
        catalog.add(new Item("Yogurt [4ct]", 3.5));
        catalog.add(new Item("Orange Juice", 2.75));
        catalog.add(new Item("Cookies", 2.25));
        catalog.add(new Item("Package-Carrots", 2));
        catalog.add(new Item("Waffles", 3));
        catalog.add(new Item("Cheese [0.5 lb]", 4.5));
        catalog.add(new Item("Paper Towels [2ct]", 2.5));
        catalog.add(new Item("Socks [pair 1ct]", 3.70));
    }

    public void displayCatalog() {
        System.out.println("Available Items");
        int i = 1;
        for (Item item : catalog) {
            System.out.print("Item " + i + "     " + item.toString());
            i++;
        }
    }

}
