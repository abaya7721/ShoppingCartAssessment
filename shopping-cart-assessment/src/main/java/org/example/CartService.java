package main.java.org.example;

import main.java.org.example.model.Cart;
import main.java.org.example.model.Catalog;
import main.java.org.example.model.Item;
import main.java.org.example.view.ConsoleIO;

import java.util.Map;

public class CartService {

    private Catalog catalog = new Catalog();
    private Cart cart = new Cart();


    public Catalog accessCatalog() {
        return catalog;
    }

    public Map<Item, Integer> getCart() {
        return cart.getCartMap();
    }

    /*public Item getCart(Item item){
        for(Item itemFind : getCart().keySet().stream().findFirst() )
    }*/

    public void addItem(int productNumber, int quantity) {
        if(quantity > 0) {
            getCart().put(catalog.getCatalogItem(productNumber), quantity);
        }
    }

    public void removeItemEquals(String productName) {
        getCart().keySet().removeIf(key -> key.getName().equals(productName));
    }

    public void showCart() {
        cart.showCartItems("---- Items in cart ----");
    }

    public boolean isCartEmpty() {
        return getCart().isEmpty();
    }

    public double calculateTotal() {
        double total = 0;
        for (Item key : getCart().keySet()) {
            // multiply the item price by the quantity and add to grand total
            total += key.getPrice() * getCart().get(key);
        }
        return total;
    }

    public void getReceipt() {
        cart.showCartItems("===   Receipt  ====");
    }


}
