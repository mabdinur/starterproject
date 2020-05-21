package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import foodfinders.FoodFinderImpl;
import foodsuppliers.FoodSupplierImpl;
import foodvendors.FoodVendorImpl;
import resources.Ingredient;
import resources.Vendor;
import resources.VendorInventory;

public class FoodFinderImplTest
{
    private static final String INGREDIENT_NAME = "item1";
    private static final String VENDOR_NAME = "shop1";
    private static final float PRICE = 10L;
    private static final float QUANTITY = 1L;

    @Test
    public void testGetVendorsByIngredient()
    {
    	FoodSupplierImpl foodSupplierImpl = new FoodSupplierImpl();
		FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
		FoodFinderImpl foodFinderImpl = new FoodFinderImpl(foodSupplierImpl, foodVendorImpl);
		
        List<VendorInventory> inventories = foodFinderImpl.getIngredient(INGREDIENT_NAME);
        
        VendorInventory inventory = inventories.get(0);
        Vendor vendor = inventory.getVendor();
        Ingredient ingredient = inventory.getIngredient(INGREDIENT_NAME);
        
        assertEquals(vendor.getName(), VENDOR_NAME);
        assertEquals(ingredient.getPrice(), PRICE, 0);
        assertEquals(ingredient.getQuantity(), QUANTITY, 0);
        ;
    }
}
