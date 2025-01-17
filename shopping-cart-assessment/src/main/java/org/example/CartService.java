package main.java.org.example;

import main.java.org.example.model.Cart;
import main.java.org.example.model.Catalog;
import main.java.org.example.model.Item;

import java.util.Map;

public class CartService {

    private Catalog catalog = new Catalog();
    private Cart cart = new Cart();


    public Catalog accessCatalog(){
        return catalog;
    }


    public Map<Item, Integer> getCart(){
        return cart.getCartMap();
    }

    public void addItem(int productNumber, int quantity) {
        getCart().put(catalog.getCatalogItem(productNumber), quantity);
    }

    public void removeItem(String productName) {
        getCart().keySet().removeIf( key -> key.hashCode()==productName.toLowerCase().hashCode());
    }

    public void showCart() {
        cart.showCartItems("Items in cart");
    }

    public boolean isCartEmpty() {
        return getCart().isEmpty();
    }

    public double calculateTotal(){
        double total = 0;
        for(Item key : cart.getCartMap().keySet() ) {
            total += key.getPrice()*cart.getCartMap().get(key);
        }
        return total;
    }

    public void getReceipt(){
        cart.showCartItems("===Receipt====");
    }


}
