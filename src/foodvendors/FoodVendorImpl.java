package foodvendors;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;

/**
 * Maps Item quantity and price to vendors
 */
public class FoodVendorImpl implements FoodVendor
{
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";

    private static final String VENDOR_FILE = "src/foodvendors/vendors.json";

    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodVendorImpl()
    {
        vendorToItemsJson = JSONReaderHelper.getData(VENDOR_FILE);
    }

    public Map<String, Long> getIngredientFromVendor(String vendorName, String itemName)
    {
        JSONObject vendorItemsJson = (JSONObject) vendorToItemsJson.get(vendorName);
        JSONObject itemJson = (JSONObject) vendorItemsJson.get(itemName);
        
        Map<String, Long> itemMap = new HashMap<String, Long>();
        Long quantity = (Long) itemJson.get(QUANTITY);
        Long price = (Long) itemJson.get(PRICE);
        itemMap.put(QUANTITY, quantity);
        itemMap.put(PRICE, price);

        return itemMap;
    }
}