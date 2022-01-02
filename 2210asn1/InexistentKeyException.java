/*
 * Thomas Michalski
 * cs2210 assignment 2
 * tmichal4
 * 251027332
 * October 18, 2020
 */

//exception thrown by the remove method of class Dictionary
public class InexistentKeyException extends Exception{
	
	public InexistentKeyException(String message) {
		super(message);
	}

}
