package test.java.org.example;
import main.java.org.example.CartService;
import main.java.org.example.model.Cart;
import main.java.org.example.model.Catalog;
import main.java.org.example.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;



public class CartServiceTest {

    Catalog catalog;
    Cart cart;
    CartService cartService;

    @BeforeEach
    public void setupItems() {
        catalog = new Catalog();
        cart = new Cart();
        cartService = new CartService();
    }

    @Test
    public void cartService_addItem_Adding_Item_With_Negative_Quantity_Shows_As_Not_Valid_Cart_Not_Updated(){
        //Arrange
        int productNumber = 0;
        int quantity = -2;

        //Act
        cartService.addItem(productNumber, quantity);

        //Assert
        assertEquals(0, cartService.getCart().size());
    }

    @Test
    public void test2() {
        
    }

    @Test
    public void test3() {

    }
}
