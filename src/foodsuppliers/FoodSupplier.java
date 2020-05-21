package foodsuppliers;

import java.util.List;

/**
 * Gets the names of all vendors with an ingredient
 */
public interface FoodSupplier
{
    public List<String> getVendorsByIngredient(String ingredientName);
}
