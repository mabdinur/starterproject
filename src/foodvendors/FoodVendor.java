package foodvendors;

import java.util.Map;

/**
 * Gets the price and quantity of an item from vendor
 */
public interface FoodVendor {

    public Map<String, Long> getIngredientFromVendor(String vendorName, String ingredientName);
}