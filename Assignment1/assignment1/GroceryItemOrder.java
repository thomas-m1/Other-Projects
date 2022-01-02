//Thomas Michalski
//computer science CS1027
//Assignment 1
//June 28th, 2019
//stores an item quantity and a price per unit

package assignment1;

//constructor method, constructs item order for purchase
public class GroceryItemOrder {
	
	public final String itemName;
	private int quantity;
	private final double pricePerItem;
	
	public GroceryItemOrder (String itemName, int quantity, double price)
	{
	//initializes variable
	this.itemName= itemName;
	this.quantity= quantity;
	this.pricePerItem= price;
	}
	
	//accessor method, returns the total cost of this item in its given quantity
	public double getCost()
	{
		return quantity * pricePerItem;
	}
	
	//modifier method, sets the grocery item’s quantity to be the given value
	public void setQuantity(int newQuantity)
	{
			quantity = newQuantity; 
	}
		
}