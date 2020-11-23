package application;

import java.util.ArrayList;

/**
 * Subclass of Pizza representing a BuildYourOwn pizza
 * @author Aaron Galang, Marko Elez
 */
 public class BuildYourOwn extends Pizza {

  public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
    super(style, size, toppings);
  }

  public int pizzaPrice() {
    int price = 0;
    // first get base price
    if (this.size.equals(Constants.sizeSmall)) {
      price += Constants.buildYourOwnSmallBasePrice;
    } else if (this.size.equals(Constants.sizeMedium)) {
      price += Constants.buildYourOwnMediumBasePrice;
    } else if (this.size.equals(Constants.sizeLarge)) {
      price += Constants.buildYourOwnLargeBasePrice;
    }
    // factor in price per topping
    int numToppings = this.toppings.size();
    return price + numToppings * Constants.buildYourOwnPerToppingPrice;
  }

  public String toString() {
	  return super.toString()+", Price: "+ pizzaPrice();
  }

 }
