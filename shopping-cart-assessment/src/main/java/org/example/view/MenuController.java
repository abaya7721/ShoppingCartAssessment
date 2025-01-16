package main.java.org.example.view;

import main.java.org.example.model.Catalog;

public class MenuController {

    ConsoleIO io = new ConsoleIO();
    Catalog products = new Catalog();

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
                    //View cart
                    break;
                case 2:
                    //Add item
                    products.displayCatalog();
                    break;
                case 3:
                    //Remove item
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
}
