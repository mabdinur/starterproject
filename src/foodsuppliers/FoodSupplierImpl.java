package foodsuppliers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import helpers.JSONReaderHelper;

/**
 * Maps vendors to available ingredients ingredients
 */
public class FoodSupplierImpl implements FoodSupplier
{
    private static final String SUPPLIER_FILE = "src/resources/suppliers.json";

    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodSupplierImpl()
    {
        vendorToItemsJson = JSONReaderHelper.getData(SUPPLIER_FILE);
    }

    @Override
    public List<String> getVendorsByIngredient(String itemName)
    {
        List<String> vendors = new ArrayList<String>();

        for (Iterator<String> iterator = vendorToItemsJson.keySet().iterator(); iterator.hasNext();) {
            String vendorName = iterator.next();
            if (vendorHasItem(vendorName, itemName)) {
                vendors.add(vendorName);
            }
        }

        return vendors;
    }

    private boolean vendorHasItem(String vendorName, String itemName)
    {
        JSONArray vendorItemsArray = (JSONArray) vendorToItemsJson.get(vendorName);
        return vendorItemsArray.contains(itemName);
    }
}
