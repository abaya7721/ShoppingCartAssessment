package main.java.org.example;

import main.java.org.example.model.Cart;
import main.java.org.example.model.Catalog;
import main.java.org.example.model.Item;

import java.util.HashMap;
import java.util.Map;

public class CartService {

    private Catalog catalog = new Catalog();
    private Cart cart = new Cart(new HashMap<>());


    
    public Catalog accessCatalog(){
        return catalog;
    }

    public void addItem(int productNumber, int quantity) {
        cart.getCartActive().put(catalog.getCatalogItem(productNumber), quantity);
    }

    public Map<Item, Integer> removeItem(String productName) {
        cart.getCartActive().keySet().removeIf(item -> item.getName().equals(productName) );
        return cart.getCartActive();
    }

    public void showCart() {
        cart.showCartItems();
    }

    public boolean isCartEmpty() {
        return cart.getCartActive().isEmpty();
    }

    public double calculateTotal(){
        double total = 0;
        for(Item key : cart.getCartActive().keySet() ) {
            total += key.getPrice();
        }
        return total;
    }






}
