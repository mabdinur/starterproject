package starterproject.foodsupplier;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FoodSupplierImpl extends FoodSupplier {

    public static final String SUPPLIER_FILE = "suppliers.json";
    private JSONObject vendorItems = new JSONObject();

    public FoodSupplierImpl(){
        vendorItems = getSupplierData();
    }

    // Gets the name of vendors with an ingredient
    // Returns vendor, quanity remaining
    public List<String> getVendorsByIngredient(String itemName){
        List<String> vendors = new ArrayList<String>();

        for (String vendorName : vendorItems.keySet()) {
            System.out.println("vendor: " + vendorName + "item: "  + itemName);
            if(vendorHasItem(vendorName, itemName)){
                vendors.add(vendorName);
            }
        }
        return vendors;
    }

    public Boolean vendorHasItem(String vendorName, String itemName){
        JSONArray vendorItems = vendorItems.getJSONArray(vendorName);
        String vendorItemsStr = vendorItems.toString();
        return vendorItemsStr.contains(itemName);
    }

    private JSONObject getSupplierData(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(SUPPLIER_FILE))
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