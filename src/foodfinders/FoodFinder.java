package foodfinders;

import java.util.Map;

public interface FoodFinder {

    // Gets ingredients from food vendors
    // Returns ingredient price and quantity from vendor
    public Map<String, Long> getIngredient(String ingredient);
}