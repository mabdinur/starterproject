package starterproject.foodfinder;

import java.util.Map;

public interface FoodFinder {

    // Gets the ingredient if it exists
    // updates inventory
    // returns ingredient, vendor, quanitity remaining from vendor
    public Map<String, Integer> getIngredient(String ingredient); 
}