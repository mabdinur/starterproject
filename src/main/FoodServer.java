package main;


import java.util.List;

import foodfinders.FoodFinderImpl;
import foodsuppliers.FoodSupplierImpl;
import foodvendors.FoodVendorImpl;
import resources.VendorInventory;

public class FoodServer {
	
	private static final String INGREDIENT_NAME = "item3";
    
	public static void main(String[] args) {
		FoodSupplierImpl foodSupplierImpl = new FoodSupplierImpl();
		FoodVendorImpl foodVendorImpl = new FoodVendorImpl();
		FoodFinderImpl foodFinderImpl = new FoodFinderImpl(foodSupplierImpl, foodVendorImpl);
		
        List<VendorInventory> ingredientInfoMap = foodFinderImpl.getIngredient(INGREDIENT_NAME);
        
        ingredientInfoMap.forEach(inventory -> 
        	System.out.println(inventory.getVendor().getName() + " " + inventory.getIngredients().get(0).getName()));
	}
}
