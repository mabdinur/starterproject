package starterproject.foodsupplier;

import java.util.List;

public interface FoodSupplier {

    // Gets the name of vendors with an ingredient
    // Returns vendor, quanity remaining
    public List<String> getVendorsByIngredient(String ingredientName); 
}