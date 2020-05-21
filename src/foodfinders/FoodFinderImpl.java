package foodfinders;

import java.util.List;

import foodsuppliers.FoodSupplierImpl;
import foodvendors.FoodVendorImpl;
import resources.VendorInventory;

/**
 * Finds the price and quantity of an ingredient from the first available vendor. Assumes at least one vendor has the
 * item in stock
 */
public class FoodFinderImpl implements FoodFinder
{
	private FoodSupplierImpl foodSupplierImpl;
	private FoodVendorImpl foodVendorImpl;
	
	public FoodFinderImpl(FoodSupplierImpl foodSupplierImpl, FoodVendorImpl foodVendorImpl ) {
		this.foodSupplierImpl = foodSupplierImpl;
		this.foodVendorImpl = foodVendorImpl;
	}
	
	@Override
    public List<VendorInventory> getIngredient(String ingredientName)
    {
        List<String> vendorNames = foodSupplierImpl.getVendorsByIngredient(ingredientName);
        List<VendorInventory> ingredientMap = foodVendorImpl.getIngredientFromVendors(vendorNames, ingredientName);
        return ingredientMap;
    } 
}