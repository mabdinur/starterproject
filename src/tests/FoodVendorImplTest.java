package tests;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import foodvendors.FoodVendorImpl;

public class FoodVendorImplTest
{
    private static final String VENDOR_NAME = "shop1";
    private static final String INGREDIENT_NAME = "item1";

    private static final Long PRICE = 10L;

    private static final Long QUANTITY = 1L;

    @Test
    public void testGetVendorsByIngredient()
    {
        FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
        Map<String, Long> ingredientInfoMap =
            foodVendorImpl.getIngredientPriceFromVendor(VENDOR_NAME, INGREDIENT_NAME);
        
        assertEquals(ingredientInfoMap.get(FoodVendorImpl.PRICE), PRICE);
        assertEquals(ingredientInfoMap.get(FoodVendorImpl.QUANTITY), QUANTITY);
    }
}
