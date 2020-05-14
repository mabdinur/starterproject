package foodsupplier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;

public class FoodSupplierImpl implements FoodSupplier
{

    public static final String SUPPLIER_FILE = "src/foodsupplier/suppliers.json";

    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodSupplierImpl()
    {
        vendorToItemsJson = JSONReaderHelper.getData(SUPPLIER_FILE);
    }

    // Gets the name of vendors with an ingredient
    // Returns vendor, quantity remaining
    public List<String> getVendorsByIngredient(String itemName)
    {
        List<String> vendors = new ArrayList<String>();

        for (Iterator iterator = vendorToItemsJson.keySet().iterator(); iterator.hasNext();) {
            String vendorName = (String) iterator.next();
            // System.out.println("vendor: " + vendorName + "item: " + itemName);
            if (vendorHasItem(vendorName, itemName)) {
                vendors.add(vendorName);
            }
        }

        return vendors;
    }

    public Boolean vendorHasItem(String vendorName, String itemName)
    {
        JSONArray vendorItems = (JSONArray) vendorToItemsJson.get(vendorName);
        String vendorItemsStr = vendorItems.toString();
        return vendorItemsStr.contains(itemName);
    }
}
