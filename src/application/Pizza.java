package application;

import java.util.ArrayList;

/**
 * Abstract base class representing a pizza
 * @author Aaron Galang, Marko Elez
 */
public abstract class Pizza {

  protected String style;
  protected String size;
  protected ArrayList<String> toppings;
  

  /**
   * Constructor for pizza with toppings.
   * @param style The style of the pizza
   * @param size The size of the pizza
   * @param toppings The pizza's toppings
   */
  public Pizza(String style, String size, ArrayList<String> toppings) {
    this.style = style;
    this.size = size;
    this.toppings = toppings;
  }

  /**
   * Constructor for pizza without toppings.
   * @param style The style of the pizza
   * @param size The size of the pizza
   */
  public Pizza(String style, String size) {
    this.style = style;
    this.size = size;
  }

  /**
   * Abstract for returning the price of a pizza.
   */
  public abstract int pizzaPrice();

  /**
   * Returns formatting string containing information about the pizza object.
   */
  public String toString() {
	String tmp="N/A";
    if (this.toppings != null) {
      tmp= "";
      for (String topping: toppings) {
        tmp += topping + " ";
      }
    }
    return "Style: "+this.style+", Size: "+this.size+", Toppings: "+tmp;
    //return String.format("Style: %s", "Size: %s", "Toppings: %s", this.style, this.size, tmp);
  }

}
