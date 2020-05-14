package test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import foodfinder.FoodFinderImpl;
import foodvendor.FoodVendorImpl;

public class FoodFinderImplTest
{
    private static final String INGREDIENT_NAME = "item1";
    private static final Long PRICE = 10L;
    private static final Long QUANTITY = 1L;

    private static FoodFinderImpl foodFinderImpl = new FoodFinderImpl();

    @Test
    public void testGetVendorsByIngredient()
    {
        Map<String, Long> ingredientInfoMap = foodFinderImpl.getIngredient(INGREDIENT_NAME);
        assertEquals(ingredientInfoMap.get(FoodVendorImpl.PRICE), PRICE);
        assertEquals(ingredientInfoMap.get(FoodVendorImpl.QUANTITY), QUANTITY);
    }
}
