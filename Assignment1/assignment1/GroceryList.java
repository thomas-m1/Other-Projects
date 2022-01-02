//Thomas Michalski
//computer science CS1027
//Assignment 1
//June 28th, 2019
//holds information about the Grocery List

package assignment1;

public class GroceryList {
	
	//constructor method, creates instance
	public GroceryList() {}
	//items = array containing a list of grocery Items ordered 
	//numitems number of items in the grocery list
	//keeps track of things in list and adds item if list < 10
	private GroceryItemOrder [] items = new GroceryItemOrder[10];
	private int numItems = 0;
	public void add(GroceryItemOrder itemOrder)
	{
       if(itemOrder==null)
       {
    	   throw new NullPointerException();
       }
       else if(numItems!= items.length)
       {
    	   items[numItems] = itemOrder;
       }
       numItems++;   
	}
	
	//returns sum cost of all grocery item orders
	public String getTotalCost() 
	{
		double sum=0.0;
		for (GroceryItemOrder element: items)
		{
			sum += element.getCost();
		}
		return String.format("%1.2f\n", sum);
	}
	
	//returns a string containing the values of an instance of the GroceryList class
    public String toString()
    {
        for(int n = 0; n<10; n++){
            String s = items[n].itemName;
            System.out.println("Grocery list Item number " + (n+1) + " " + s);
        }
        return " ";	
    }
    
    //returns true if the given grocery item is listed on the grocery list
    public  boolean GroceryListQuery(String itemName)
    {
    	for(int n=0; n<=numItems;n++)
    	{
    		if(items[n].itemName.equals(itemName))
    		{
    			return true;
    		}
    	}
		return false;
    }
}