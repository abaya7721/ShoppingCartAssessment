package main.java.org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> cartActive = new HashMap<>();


    public Map<Item, Integer> getCartMap() {
        return cartActive;
    }

     public void showCartItems(String header) {
        // String header determines print out for  viewing items in cart or getting a receipt after checkout
        System.out.println(header);
        if(header.equals("---- Items in cart ----")) {
            for (Item e : cartActive.keySet()) {
                System.out.println(" - " + e.getName() + " +" + cartActive.get(e));
            }
        }
        else {
            for (Item e : cartActive.keySet()) {
                System.out.println(e.getName() + " - price: $" + e.getPrice() + " - x " + cartActive.get(e) + " each");
            }
        }
    }

}
