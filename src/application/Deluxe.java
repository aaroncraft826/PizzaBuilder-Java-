package application;

import java.util.ArrayList;

/**
 * Subclass of Pizza representing a Deluxe pizza
 * @author Aaron Galang, Marko Elez
 */
 public class Deluxe extends Pizza {

	 public Deluxe(String style, String size, ArrayList<String> toppings) {
		 super(style, size, toppings);
	 }

	 public Deluxe(String style, String size) {
		 super(style, size);
	 }

	 public int pizzaPrice() {
		 if (this.size.equals(Constants.sizeSmall)) {
			 return Constants.deluxeSmallPrice;
		 } else if (this.size.equals(Constants.sizeMedium)) {
			 return Constants.deluxeMediumPrice;
		 } else if (this.size.equals(Constants.sizeLarge)) {
			 return Constants.deluxeLargePrice;
		 }
		 return -1;//pizza price needs to have some output
	 }

	 public String toString() {
		 return super.toString()+", Price: "+ pizzaPrice();
	 }

 }
