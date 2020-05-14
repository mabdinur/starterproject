package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import foodsuppliers.FoodSupplierImpl;

public class FoodSupplierImplTest
{
    private static final String VENDOR = "shop1";

    private static final String INGREDIENT_NAME = "item1";

    @Test
    public void testGetVendorsByIngredient()
    {
        FoodSupplierImpl foodFinderImpl = new FoodSupplierImpl();
        List<String> storesWithIngredient = foodFinderImpl.getVendorsByIngredient(INGREDIENT_NAME);
        assertTrue(storesWithIngredient.stream().anyMatch(shop -> VENDOR.equals(shop)));
    }

}
