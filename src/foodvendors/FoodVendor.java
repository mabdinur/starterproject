package foodvendors;

import java.util.List;
import resources.VendorInventory;

/**
 * Gets Ingredients from vendors
 */
public interface FoodVendor {

    public List<VendorInventory> getIngredientFromVendors(List<String> vendorNames, String itemName);
}