package starterproject;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import foodfinder.FoodFinderImpl;
import foodsupplier.FoodSupplierImpl;
import foodvendor.FoodVendorImpl;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(FoodFinderImpl.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
}  	