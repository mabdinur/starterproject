package foodfinders;

import java.util.List;
import java.util.Map;

import foodsuppliers.FoodSupplierImpl;
import foodvendors.FoodVendorImpl;

/**
 * Finds the price and quantity of an ingredient from the first available vendor. Assumes at least one vendor has the
 * item in stock
 */
public class FoodFinderImpl implements FoodFinder
{
    public Map<String, Long> getIngredient(String ingredientName)
    {
        FoodSupplierImpl foodSupplierImpl = new FoodSupplierImpl();
        List<String> vendorNames = foodSupplierImpl.getVendorsByIngredient(ingredientName);
        String vendorName = vendorNames.get(0);

        FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
        Map<String, Long> ingredientMap = foodVendorImpl.getIngredientFromVendor(vendorName, ingredientName);

        return ingredientMap;
    } 
}