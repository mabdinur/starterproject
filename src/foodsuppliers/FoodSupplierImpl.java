package foodsuppliers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;

/**
 * Maps vendors to ingredients
 */
public class FoodSupplierImpl implements FoodSupplier
{

    public static final String SUPPLIER_FILE = "src/foodsuppliers/suppliers.json";

    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodSupplierImpl()
    {
        vendorToItemsJson = JSONReaderHelper.getData(SUPPLIER_FILE);
    }

    public List<String> getVendorsByIngredient(String itemName)
    {
        List<String> vendors = new ArrayList<String>();

        for (Iterator iterator = vendorToItemsJson.keySet().iterator(); iterator.hasNext();) {
            String vendorName = (String) iterator.next();
            if (vendorHasItem(vendorName, itemName)) {
                vendors.add(vendorName);
            }
        }

        return vendors;
    }

    public Boolean vendorHasItem(String vendorName, String itemName)
    {
        JSONArray vendorItemsArray = (JSONArray) vendorToItemsJson.get(vendorName);
        String vendorItemsStr = vendorItemsArray.toString();
        return vendorItemsStr.contains(itemName);
    }
}
