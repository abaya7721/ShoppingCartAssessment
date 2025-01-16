package main.java.org.example.view;

import java.util.Scanner;

public class ConsoleIO {
    public Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        displayMessage(prompt);
        return scanner.next();
    }

    public int getInt(String prompt) {
        displayMessage(prompt);
        String selection = scanner.next();
        int intSelect = 0;
        try {
            intSelect = Integer.parseInt(selection);
        } catch (Exception e) {
            displayMessage("Invalid input");
        }
        return intSelect;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        displayMessage("");
        displayMessage("------Your Shopping Assistant---------");
        displayMessage("");
        displayMessage("        1. View Cart");
        displayMessage("        2. Add Item");
        displayMessage("        3. Remove Item");
        displayMessage("        4. Checkout");
        displayMessage("        5. Exit");
    }


}
