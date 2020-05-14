package starterproject.foodvendor;

import java.util.Map;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FoodVendorImpl extends FoodVendor{

    private static final String VENDOR_FILE = "vendors.json";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";

    private JSONObject vendorToItemsJson = new JSONObject();

    public FoodSupplierImpl(){
        vendorToItemsJson = getVendorData();
    }

    public Map<String, Integer> getIngredientPriceFromVendor(String vendorName, String itemName){
        JSONObject vendorItemsJson = vendorToItemsJson.getJSONObject(vendorName);
        JSONObject itemDataJson = vendorItemsJson.getJSONObject(itemName);
        
        Map<String, Integer> itemDataMap = new HashMap<String, Integer>();
        itemDataMap.put(QUANTITY, itemDataJson.getInteger(QUANTITY));
        itemDataMap.put(PRICE, itemDataJson.getInteger(PRICE));

        return itemDataMap;
    }

    private JSONObject getSupplierData(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(VENDOR_FILE))
        {
            //Read JSON file
            JSONObject vendorsJson = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return vendorsJson;
    }
}