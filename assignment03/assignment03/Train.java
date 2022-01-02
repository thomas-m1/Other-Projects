//Thomas Michalski
//computer science CS1027
//Assignment 3
//Nov 18, 2019

package assignment03;

/**
 * This file represents a Train, which is composed of one or more train cars.
 * Note that the Train described in this assignment is simply a doubly linked list.
 * 
 * @author CS1027A
 *
 */
public class Train {
    
    // Student code goes here.
    private DoubleNode<TrainCar> locomotive;
    private DoubleNode<TrainCar> caboose;
    //////////private TrainCar element;
    
    public Train() {
        locomotive = null;
        caboose = null;
        //////////element = null;
        
    }
    
    private void switchCars(DoubleNode<TrainCar> Car1, DoubleNode<TrainCar> Car2) {
      TrainCar temp = Car1.getElement();
      Car1.setElement(Car2.getElement());
      Car2.setElement(temp);
    }
    
    public boolean addCar(DoubleNode<TrainCar> newCar) {
      //If there is no locomotive, then add to head
        if(this.locomotive == null) {
        	this.locomotive = newCar;
        	this.locomotive.setNext(caboose);
        	return true;
        }
        //If there is no caboose add to the end
        else if(this.caboose == null) { 
        	if(locomotive.getElement().getNumber() == newCar.getElement().getNumber() || locomotive.getElement().getColor().equals(newCar.getElement().getColor())) {
        		this.caboose = new DoubleNode<TrainCar>();
        		this.caboose.setElement(newCar.getElement());
        		this.caboose.setPrevious(locomotive);
        		this.locomotive.setNext(caboose);
        		return true; 
        	}
        	else {
        		return false;
        	}
        }
        else if(this.caboose.getElement().getNumber() == newCar.getElement().getNumber() || this.caboose.getElement().getColor().equals(newCar.getElement().getColor())){
        	this.caboose.getPrevious().setNext(newCar);
            newCar.setPrevious(this.caboose.getPrevious());
            newCar.setNext(caboose);
            this.caboose.setPrevious(newCar);
            switchCars(caboose, newCar);
            return true;
          }
        else {
        	DoubleNode<TrainCar> temp = this.caboose.getPrevious();
        	while(!(temp.equals(locomotive))) {
        		if((temp.getPrevious().getElement().getNumber() == newCar.getElement().getNumber() ||temp.getPrevious().getElement().getColor().equals(newCar.getElement().getColor())) && (temp.getElement().getNumber() == newCar.getElement().getNumber() ||  temp.getElement().getColor().equals(newCar.getElement().getColor()))){
        			newCar.setNext(temp);
        			newCar.setPrevious(temp.getPrevious());
        			temp.getPrevious().setNext(newCar);
        			temp.setPrevious(newCar);
        			return true;           
        		}
        		else {
        			temp = temp.getPrevious();
        		}
        	}
        	return false;            
        }       
} 
    
    /**
     * This method prints out the contents of the Train in more detail.
     */
    public void printDetailedTrain() {
        
        DoubleNode<TrainCar> current = locomotive;
        
        System.out.println("*******************************");
        System.out.println("Locomotive: " + locomotive.getElement());
        System.out.println("Caboose: " + caboose.getElement());
        System.out.println("*=*=*=*=*=*=*=*=*");
        
        // Traverse through the Train, e.g. traverse through the doubly linked list
        while (current != null) {
        
            String str;
            
            // Print previous element if it exists.
            if (current.getPrevious() != null) {
                
                str = current.getPrevious() + " >> ";
                
            } //end if
            
            // Print something informative if it does not exist
            else {
                
                str = "N/A >> ";
                
            } //end else            
            
            // Print actual element value.
            str += "'" + current.getElement() + "' >> ";
            
            // Print next element if it exists.
            if (current.getNext() != null) {
                
                str += current.getNext();
                
            } //end if 
            
            // Print something informative if it does not exist
            else {
                
                str += "N/A";
                
            } //end else
        
            System.out.println(str);
            current = current.getNext();
            
        } //end while
        
        System.out.println("*******************************");
        
    } //end printDetailedTrain
    
    /**
     * This method prints out the contents of the Train.
     */
    public void printTrain() {
        
        DoubleNode<TrainCar> current = locomotive;

        String mainStr = "";
        int count = 0;
        
        // Traverse through the Train, e.g. traverse through the doubly linked list
        while (current != null) {

            if (count > 0) {
                
                mainStr += ",  ";
                
            } //end if
            
            mainStr += current.toString();
            current = current.getNext();
            count++;
            
        } //end while       
        
        System.out.println("Main train cars:");
        System.out.println("======================");
        System.out.println(mainStr);
        
    } //end printTrain
    
} //end Train (class)
