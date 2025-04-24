package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     * 
     * @param itemName  the name of the item
     * @param price     the price of the item (must be non-negative)
     * @throws IllegalArgumentException if price is zero or negative
     *
     * Note: Modified to reject 0 price to meet exam requirement
     */
    public void addItem(String itemName, double price) {
        // >>> Changed from price < 0 to price <= 0
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     * 
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10 percent discount
     * - "SAVE20": 20 percent discount
     * 
     * @param code  the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     * Useful for testing.
     * 
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * >>> ADDED METHOD
     * Removes an item from the shopping cart by name.
     */
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    /**
     * >>> ADDED METHOD
     * Returns the current number of items in the cart.
     */
    public int getItemCount() {
        return items.size();
    }
}
