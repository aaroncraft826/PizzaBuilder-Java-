package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * JUnit test class for Pizza prices
 * @author Aaron Galang, Marko Elez
 */
class PizzaPriceTests {

	/**
	 * Test method for {@link Pizza#pizzaPrice()}
	 */
	@Test
	public void testSmallPizzaPrice() {
		ArrayList<String> buildTop = new ArrayList();
		ArrayList<String> deluxeTop = new ArrayList();
		ArrayList<String> hawaiianTop = new ArrayList();
		
		buildTop.add(ItemLists.toppingsList[0]);
		buildTop.add(ItemLists.toppingsList[1]);
		buildTop.add(ItemLists.toppingsList[2]);

		for(String s:ItemLists.deluxeToppings) {
			deluxeTop.add(s);
		}
		
		for(String s:ItemLists.HawaiianToppings) {
			hawaiianTop.add(s);
		}
		
		//testing price for small
		Pizza build = new BuildYourOwn(Constants.pizzaTypeBuildYourOwn, Constants.sizeSmall, buildTop);
		Pizza deluxe = new Deluxe(Constants.pizzaTypeBuildYourOwn, Constants.sizeSmall, deluxeTop);
		Pizza hawaiian = new Hawaiian(Constants.pizzaTypeBuildYourOwn, Constants.sizeSmall, hawaiianTop);
		
		assertEquals((5+(3*2)), build.pizzaPrice(), "Small buildyourown pizza price for 3 toppings must be $11 (5+(3*2))");
		assertEquals(Constants.deluxeSmallPrice, deluxe.pizzaPrice(), "Small deluxe pizza price must be $14");
		assertEquals(Constants.hawaiianSmallPrice, hawaiian.pizzaPrice(), "Small deluxe pizza price must be $8");
		
		//testing price for medium
		build = new BuildYourOwn(Constants.pizzaTypeBuildYourOwn, Constants.sizeMedium, buildTop);
		deluxe = new Deluxe(Constants.pizzaTypeBuildYourOwn, Constants.sizeMedium, deluxeTop);
		hawaiian = new Hawaiian(Constants.pizzaTypeBuildYourOwn, Constants.sizeMedium, hawaiianTop);
		
		assertEquals((5+(3*2)+2), build.pizzaPrice(), "Medium buildyourown pizza price for 3 toppings must be $13 (5+(3*2)+2)");
		assertEquals(Constants.deluxeMediumPrice, deluxe.pizzaPrice(), "Medium deluxe pizza price must be $16");
		assertEquals(Constants.hawaiianMediumPrice, hawaiian.pizzaPrice(), "Medium deluxe pizza price must be $10");
		
		//testing price for large
		build = new BuildYourOwn(Constants.pizzaTypeBuildYourOwn, Constants.sizeLarge, buildTop);
		deluxe = new Deluxe(Constants.pizzaTypeBuildYourOwn, Constants.sizeLarge, deluxeTop);
		hawaiian = new Hawaiian(Constants.pizzaTypeBuildYourOwn, Constants.sizeLarge, hawaiianTop);
		
		assertEquals((5+(3*2)+4), build.pizzaPrice(), "Large buildyourown pizza price for 3 toppings must be $15 (5+(3*2)+4)");
		assertEquals(Constants.deluxeLargePrice, deluxe.pizzaPrice(), "Large deluxe pizza price must be $18");
		assertEquals(Constants.hawaiianLargePrice, hawaiian.pizzaPrice(), "Large deluxe pizza price must be $12");
		
		
		//fail("Not yet implemented");
	}

}
