package starterproject.foodvendor;

import java.util.Map;

public interface FoodVendor {

    // Gets the price of  item from vendor
    public Map<String, Integer> getIngredientPriceFromVendor(String vendorName, String ingredientName); 
}