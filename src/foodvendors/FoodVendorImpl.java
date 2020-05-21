package foodvendors;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;
import resources.Ingredient;
import resources.Vendor;
import resources.VendorInventory;

/**
 * Maps Item quantity and price to vendors
 */
public class FoodVendorImpl implements FoodVendor
{
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String CURRENCY = "currency";
    private static final String VENDOR_FILE = "src/resources/vendors.json";

    private JSONObject vendorsToItemsJson = new JSONObject();

    public FoodVendorImpl()
    {
        vendorsToItemsJson = JSONReaderHelper.getData(VENDOR_FILE);
    }
    
    @Override
    public List<VendorInventory> getIngredientFromVendors(List<String> vendorNames, String itemName)
    {
    	List<VendorInventory> inventories = new ArrayList<VendorInventory>();
    	
    	for (String vendorName : vendorNames) {
    		Vendor vendor = new Vendor(vendorName);
    		Ingredient ingredient = getIngredient(itemName, vendorName);
    		VendorInventory vendorInventory = new VendorInventory(vendor, ingredient);
    		inventories.add(vendorInventory);
    	}
        
        return inventories;
    }

	private Ingredient getIngredient(String itemName, String vendorName) {
		JSONObject vendorItemsJson = (JSONObject) vendorsToItemsJson.get(vendorName);
		JSONObject itemJson = (JSONObject) vendorItemsJson.get(itemName);
    
		Long quantity = (Long) itemJson.get(QUANTITY);
		Long price = (Long) itemJson.get(PRICE);
		String currency = (String) itemJson.get(CURRENCY);
		
		Ingredient ingredient = new Ingredient(itemName, price, quantity, currency);
		return ingredient;
	}
}