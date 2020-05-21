package foodfinders;

import java.util.List;

import resources.VendorInventory;

/**
 * Gets ingredients from all available vendors 
 */
public interface FoodFinder {
    
    public List<VendorInventory> getIngredient(String ingredient);
}