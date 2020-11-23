package application;

import java.util.ArrayList;

/**
 * Subclass of Pizza representing a Hawaiian pizza
 * @author Aaron Galang, Marko Elez
 */
 public class Hawaiian extends Pizza {

  public Hawaiian(String style, String size, ArrayList<String> toppings) {
    super(style, size, toppings);
  }

  public Hawaiian(String style, String size) {
    super(style, size);
  }

  public int pizzaPrice() {
    if (this.size.equals(Constants.sizeSmall)) {
      return Constants.hawaiianSmallPrice;
    } else if (this.size.equals(Constants.sizeMedium)) {
      return Constants.hawaiianMediumPrice;
    } else if (this.size.equals(Constants.sizeLarge)) {
      return Constants.hawaiianLargePrice;
    }
    return -1;
  }

  public String toString() {
	  return super.toString()+", Price: "+ pizzaPrice();
  }

 }
