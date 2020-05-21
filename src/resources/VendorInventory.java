package resources;

import java.util.ArrayList;
import java.util.List;

public class VendorInventory {
	
	private Vendor vendor;
	private List <Ingredient> ingredients;

	public VendorInventory(Vendor vendor, Ingredient ingredient) {
		this.vendor = vendor;
		this.ingredients = new ArrayList<Ingredient>();
		this.ingredients.add(ingredient);
	}
	
	public VendorInventory(Vendor vendor, List<Ingredient> ingredients) {
		this.vendor = vendor;
		this.ingredients = ingredients;
	}
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public Ingredient getIngredient(String name) {
		return ingredients.stream().filter(ingredient -> 
			ingredient.getName() == name).findFirst().get();
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public void removeIngredient(Ingredient ingredient) {
		this.ingredients.remove(ingredient);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorInventory other = (VendorInventory) obj;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}

}
