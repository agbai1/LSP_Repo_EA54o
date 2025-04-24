package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ShoppingCart functionality.
 */
public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setup() {
        cart = new ShoppingCart();
    }

    // Test: Add item with valid price
    @Test
    public void shouldAllowAddingItemWithValidPrice() {
        cart.addItem("Bluetooth Speaker", 49.99);
        assertEquals(49.99, cart.getTotalCost(), 0.001);
    }

    // Test: Add item with zero price (should throw exception)
    @Test
    public void shouldRejectItemWithZeroPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Free Sample", 0.0);
        });
        assertTrue(exception.getMessage().contains("greater than zero"));
    }

    // Test: Add item with negative price (should throw exception)
    @Test
    public void shouldThrowExceptionForNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Smartwatch", -59.99);
        });
        assertTrue(exception.getMessage().contains("greater than zero"));
    }

    // Test: Apply SAVE10 discount
    @Test
    public void shouldApplySave10DiscountCode() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.01);
    }

    // Test: Apply SAVE20 discount
    @Test
    public void shouldApplySave20DiscountCode() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.01);
    }

    // Test: Apply invalid discount code
    @Test
    public void shouldThrowExceptionForInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    // Test: Total cost without discount
    @Test
    public void shouldReturnTotalWithoutDiscount() {
        cart.addItem("Laptop", 1000.00);
        cart.addItem("Mouse", 50.00);
        assertEquals(1050.00, cart.getTotalCost(), 0.001);
    }

    // Test: Total cost with discount
    @Test
    public void shouldReturnTotalWithDiscount() {
        cart.addItem("Monitor", 200.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(180.00, cart.getTotalCost(), 0.001);
    }

    // Test: Total cost with empty cart
    @Test
    public void shouldReturnZeroWhenCartIsEmpty() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
    
 // Test: Remove an existing item
    @Test
    public void testRemoveExistingItem() {
        cart.addItem("Laptop Stand", 30.00);
        cart.addItem("Mousepad", 10.00);
        cart.removeItem("Mousepad");

        // After removing, total should only reflect the remaining item
        assertEquals(30.00, cart.getTotalCost(), 0.001);
        assertEquals(1, cart.getItemCount());  // cart should now only have one item
    }

    // Test: Remove an item that doesn’t exist
    @Test
    public void testRemoveNonexistentItem() {
        cart.addItem("Notebook", 5.00);
        cart.removeItem("Pen");  // Should do nothing, no crash

        // Total cost and size should remain unchanged
        assertEquals(5.00, cart.getTotalCost(), 0.001);
        assertEquals(1, cart.getItemCount());
    }

    // Test: Cart size updates correctly when adding and removing items
    @Test
    public void testCartSizeUpdatesAfterAddAndRemove() {
        cart.addItem("Book", 12.00);
        cart.addItem("Highlighter", 2.50);
        cart.addItem("Backpack", 45.00);

        // After 3 additions
        assertEquals(3, cart.getItemCount());

        cart.removeItem("Highlighter");

        // After removal
        assertEquals(2, cart.getItemCount());
    }
}
