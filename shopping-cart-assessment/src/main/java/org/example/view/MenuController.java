package main.java.org.example.view;

import main.java.org.example.CartService;
import main.java.org.example.model.Item;

public class MenuController {

    ConsoleIO io = new ConsoleIO();
    CartService cartService = new CartService();

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
        if (itemSelected <= cartService.accessCatalog().getSize()) {
            int quantity = io.getInt("Enter Quantity");
            Item item = cartService.accessCatalog().getCatalogItem(itemSelected - 1);
            if (cartService.getCart().containsKey(item) && quantity > 0) {
                String addItem = io.getString("Item already in cart. Would you like to update it?" +
                        "\n       1(yes)   Any Key(no) ");
                if (addItem.equals("1")) {
                    cartService.addItem(itemSelected - 1, quantity);
                    io.displayMessage("    Item Updated");

                } else {
                    io.displayMessage("    Item not updated");
                }
            } else if (!cartService.getCart().containsKey(item) && quantity > 0) {
                cartService.addItem(itemSelected - 1, quantity);
                io.displayMessage("    Item Added to Cart");
            } else {
                io.displayMessage("Error during quantity input.");
            }
        } else {
            io.displayMessage("     Not an item!");
        }
    }


    public void displayCart() {
        if (showCartIsEmpty()) {

        } else {
            cartService.showCart();
            io.displayMessage("       Current Total \n" + "        $" + cartService.calculateTotal());
        }
    }

    public void removeItemSelection() {
        cartService.showCart();

        String itemSelected = io.getString("Enter item name to remove item.");
        cartService.removeItemEquals(itemSelected);

        io.displayMessage("Item removed from cart");
    }

    public void displayConfirmationMenu() {
        String confirm = "Enter    1(yes)   Any Key(no) \n >>";
        if(!showCartIsEmpty()) {
            String checkout = io.getString("Would you like to continue to checkout? \n " + confirm);
            if (checkout.equals("1")) {
                displayCart();
                String confirmation = io.getString("Confirm Total" + " $" + cartService.calculateTotal() + "\n " + confirm);
                if (confirmation.equals("1")) {
                    checkoutCart();
                }
            }
        }
    }

    public void checkoutCart() {
            io.displayMessage(" Check out successful. \n No items in cart.");
            cartService.getReceipt();
            cartService.getCart().clear();
    }

    public boolean showCartIsEmpty() {
        boolean checkEmpty = cartService.isCartEmpty();
        if (checkEmpty) {
            io.displayMessage("      Cart is empty.");
            io.displayMessage("      Cannot checkout.");
        }
        return checkEmpty;
    }
}
