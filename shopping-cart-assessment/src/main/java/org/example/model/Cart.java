package main.java.org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> cartActive = new HashMap<>();

    public Cart(){
    }

    public Map<Item, Integer> getCartActive() {
        return cartActive;
    }

    public String showCartItems() {
        return "Items in cart" + cartActive;
    }
}
