package main.java.org.example.model;

import java.util.Objects;

public class Item {

    private double price;
    private String name;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " $" + price + "\n";
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o instanceof Item) {
            if( ((Item) o).getName().equals(this.name) && ((Item) o).getPrice() == (this.price) ) {
                return true;
            }
        }
        return false;
    }

}
