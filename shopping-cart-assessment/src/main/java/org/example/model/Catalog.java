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

    public int getSize() {
        return catalog.size();
    }

    public void createCatalog() {
        catalog.add(new Item("yogurt", 3.50));
        catalog.add(new Item("orange juice", 2.75));
        catalog.add(new Item("cookies", 2.25));
        catalog.add(new Item("package carrots", 2.00));
        catalog.add(new Item("waffles", 3.00));
        catalog.add(new Item("cheese", 4.50));
        catalog.add(new Item("paper towels", 2.50));
        catalog.add(new Item("sponges", 3.70));
    }

    public void displayCatalog() {
        System.out.println("-----Available Items-----");
        int i = 1;
        for (Item item : catalog) {
            System.out.print("       Item " + i + "     " + item.toString());
            i++;
        }
    }

}
