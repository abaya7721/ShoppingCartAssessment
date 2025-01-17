package main.java.org.example.view;

import main.java.org.example.CartService;
import main.java.org.example.model.Catalog;

public class MenuController {

    ConsoleIO io = new ConsoleIO();
    CartService cartService = new CartService();

    public enum menuChoice {
        VIEW_CART, ADD_ITEM, REMOVE_ITEM, CHECKOUT, EXIT
    }

    public MenuController() {

    }

    public void runShoppingCartApp() {
        boolean running = true;
        while (running) {
            io.displayMenu();
            int menuSelect = io.getInt("       Select an option.");
            switch (menuSelect) {
                case 1:
                    displayCart();
                    break;
                case 2:
                    //Add item
                    askUserForItemSelection();
                    break;
                case 3:
                    //Remove item
                    removeItemSelection();
                    break;
                case 4:
                    //Checkout
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    io.displayMessage("Enter number between 1 and 5.");
            }
        }
    }

    public void askUserForItemSelection() {
        cartService.accessCatalog().displayCatalog();
        int itemSelected = io.getInt("Select Item");
        int quantity = io.getInt("Enter Quantity");

        cartService.addItem(itemSelected - 1, quantity);
        io.displayMessage("Item Added to Cart");
    }

    public void displayCart() {
        if (cartService.isCartEmpty()) {
            io.displayMessage("Cart is empty.");
        } else {
            cartService.showCart();
            io.displayMessage("Current Total \n"+cartService.calculateTotal());
        }
    }

//    public void

    public void removeItemSelection() {
        cartService.showCart();
        String itemSelected = io.getString("Enter item name to remove item.");
        //int quantity = io.getInt("Enter Quantity");

        cartService.removeItem(itemSelected);
        io.displayMessage("Item removed from cart");
    }

    public void displayConfirmationMenu(){

    }
}
