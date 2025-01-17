package main.java.org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> cartActive = new HashMap<>();

    public Cart(Map<Item, Integer> cartActive) {
        this.cartActive = cartActive;
    }

    public Map<Item, Integer> getCartActive() {
        return this.cartActive;
    }

    public void showCartItems() {
        System.out.println("Items in cart \n");
        for (Item e : cartActive.keySet()) {
            System.out.println(e.getName() + " Quantity: " + cartActive.get(e));
        }
    }


}
