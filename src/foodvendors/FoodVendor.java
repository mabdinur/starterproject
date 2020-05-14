package foodvendors;

import java.util.Map;

public interface FoodVendor {

    // Gets the price of  item from vendor
    public Map<String, Long> getIngredientPriceFromVendor(String vendorName, String ingredientName);
}