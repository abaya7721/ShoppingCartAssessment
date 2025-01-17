package main.java.org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> cartActive = new HashMap<>();


    public Map<Item, Integer> getCartMap() {
        return cartActive;
    }

     public void showCartItems(String header) {
        System.out.println(header);
        if(header.equals("Items in cart")) {
            for (Item e : cartActive.keySet()) {
                System.out.println(e.getName());
            }
        }
        else {
            for (Item e : cartActive.keySet()) {
                System.out.println(e.getName() + " - price: $" + e.getPrice() + " - x " + cartActive.get(e) + " each");
            }
        }
    }

}
