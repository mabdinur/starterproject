package starterproject.foodfinder;

import java.util.Map;
import java.util.HashMap;

import starterproject.foodsupplier.FoodSupplierImpl;
import starterproject.foodvendor.FoodVendorImpl;

public class FoodFinderImpl extends FoodFinder{
    
    private static final String VEDNOR = "vendor";
    
    public Map<String, Integer> getIngredient(String ingredientName){
        List <String> vendorsNames = FoodSupplierImpl().getVendorsByIngredient(ingredientName);
        String vendorName = vendorsNames.get(0);

        FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
        Map<String, Integer> ingredientMap = foodVendorImpl.getIngredientPriceFromVendor(vendorName, ingredientName);
        ingredientMap[VEDNOR] =  vendorName;

        return ingredientMap;
    } 
}