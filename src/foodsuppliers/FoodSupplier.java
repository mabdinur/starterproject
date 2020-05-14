package foodsuppliers;

import java.util.List;

public interface FoodSupplier
{

    // Gets all vendors with an ingredient
    // Returns the name of each vendor
    public List<String> getVendorsByIngredient(String ingredientName);
}
