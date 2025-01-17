package main.java.org.example.view;

import main.java.org.example.CartService;

public class MenuController {

    ConsoleIO io = new ConsoleIO();
    CartService cartService = new CartService();

    public enum menuChoice {
        VIEW_CART, ADD_ITEM, REMOVE_ITEM, CHECKOUT, EXIT
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
                    displayConfirmationMenu();
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
        if (itemSelected < cartService.accessCatalog().getSize()) {
            int quantity = io.getInt("Enter Quantity");

            cartService.addItem(itemSelected - 1, quantity);
            io.displayMessage("Item Added to Cart");
        } else {
            io.displayMessage("Not an item.");
        }
    }

    public void displayCart() {
        if (cartService.isCartEmpty()) {
            io.displayMessage("Cart is empty.");
        } else {
            cartService.showCart();
            io.displayMessage("Current Total \n" + "$" + cartService.calculateTotal());
        }
    }

    public void removeItemSelection() {
        cartService.showCart();

        String itemSelected = io.getString("Enter item name to remove item.");
        cartService.removeItem(itemSelected);

        io.displayMessage("Item removed from cart");
    }

    public void displayConfirmationMenu() {
        String confirm = "Enter    1(yes)   Any Key(no) \n >>";
        displayCart();
        String checkout = io.getString("Would you like to continue to checkout? \n " + confirm);
        if (checkout.equals("1")) {
            String confirmation = io.getString("Confirm Total" + " $" + cartService.calculateTotal() + "\n " + confirm);
            if (checkout.equals("1")) {
                checkoutCart();
            }
        }
    }

    public void checkoutCart() {

        io.displayMessage(" Check out successful. \n No items in cart.");
        cartService.getReceipt();
        cartService.getCart().clear();


    }
}
