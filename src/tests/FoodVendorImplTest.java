package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import foodvendors.FoodVendorImpl;
import resources.Ingredient;
import resources.Vendor;
import resources.VendorInventory;

public class FoodVendorImplTest
{
	private static final String VENDOR_NAME = "shop1";
    private static final String INGREDIENT_NAME = "item1";

    private static final float PRICE = 10;
    private static final float QUANTITY = 1;

    @Test
    public void testGetVendorsByIngredient()
    {
        FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
        List<String> vendorNames = Arrays.asList(VENDOR_NAME);
        List<VendorInventory> inventories =
            foodVendorImpl.getIngredientFromVendors(vendorNames, INGREDIENT_NAME);
        
        VendorInventory inventory = inventories.get(0);
        Vendor vendor = inventory.getVendor();
        Ingredient ingredient = inventory.getIngredient(INGREDIENT_NAME);
        
        assertEquals(vendor.getName(), VENDOR_NAME);
        assertNotNull(ingredient);
        assertEquals(ingredient.getPrice(), PRICE, 0);
        assertEquals(ingredient.getQuantity(), QUANTITY, 0);
    }
}
