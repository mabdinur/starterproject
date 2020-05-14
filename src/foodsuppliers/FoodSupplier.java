package foodsuppliers;

import java.util.List;

public interface FoodSupplier
{

    // Gets the name of vendors with an ingredient
    // Returns vendor, quantity remaining
    public List<String> getVendorsByIngredient(String ingredientName);
}
