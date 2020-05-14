package starterproject.foodfinder;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FoodFinderImplTest {
	
   private static final String vendor = "shop1";
   private static final String ingredient = "item1"
   	
   private static FoodFinderImpl foodFinderImpl = new FoodFinderImpl();
   private static Map<String,Integer> testIngredient = new HashMap<String, Integer>();

    @Test
    public void testPrintMessage() {
        testIngredient.put("quanity", 10);
        testIngredient.put("price", 1);

        assertEquals(testIngredient, foodFinderImpl.getIngredient());
    }
}