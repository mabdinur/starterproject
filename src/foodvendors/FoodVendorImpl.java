package foodvendor;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;

public class FoodVendorImpl implements FoodVendor
{
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";

    private static final String VENDOR_FILE = "src/foodvendor/vendors.json";
    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodVendorImpl()
    {
        vendorToItemsJson = JSONReaderHelper.getData(VENDOR_FILE);
    }

    public Map<String, Long> getIngredientPriceFromVendor(String vendorName, String itemName)
    {
        JSONObject vendorItemsJson = (JSONObject) vendorToItemsJson.get(vendorName);
        JSONObject itemDataJson = (JSONObject) vendorItemsJson.get(itemName);
        
        Map<String, Long> itemDataMap = new HashMap<String, Long>();
        Long quantity = (Long) itemDataJson.get(QUANTITY);
        Long price = (Long) itemDataJson.get(PRICE);
        itemDataMap.put(QUANTITY, quantity);
        itemDataMap.put(PRICE, price);

        return itemDataMap;
    }
}