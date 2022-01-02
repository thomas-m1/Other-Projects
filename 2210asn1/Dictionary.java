/*
 * Thomas Michalski
 * cs2210 assignment 2
 * tmichal4
 * 251027332
 * October 18, 2020
 */
import java.util.LinkedList;
import java.util.Iterator; 


public class Dictionary implements DictionaryADT{
	
	private Data[] hashDict; 
	
	// initializes a dictionary with an empty hash table of the specified size
	public Dictionary(int size) {
		hashDict = new Data[size]; 
		}

	@Override	
	//inserts  given Dataobject referenced by record in the dictionary
	public int put(Data record) throws DuplicatedKeyException {

		String key = record.getKey();		

		//traverse hashdict and check if key already exists inside the hash
		Data node; 
		for(int i = 0; i< hashDict.length; i++){
			if (hashDict[i] != null) {
				node = hashDict[i];
				if(node.getKey() == key) { 
					throw new DuplicatedKeyException("Duplicate key");
				}	
			}	
		}
		

		int index = hashFunction(key, hashDict.length);

		if (hashDict[index] != null) {
			//hashDict[index] = record;

			return 1;
		}
		else {
			hashDict[index] = record;
			return 0;
		}
	}
	

	@Override
	//removes Data object containing string key from dictionary
	public void remove(String key) throws InexistentKeyException {
		
		
		Data node; 
		for(int i = 0; i< hashDict.length; i++){
			if (hashDict[i] != null) {
				node = hashDict[i];
				if(node.getKey() == key) { 
					hashDict[i] = null; 
					return;
				}
				
			}
			
		}
		throw new InexistentKeyException("InexistentKeyException");
	}
	
	
	@Override
	//returns Data object stored in hash table containing given key value, or null
	public Data get(String key) {
		
		int index = hashFunction(key, hashDict.length);
		return hashDict[index];
	}
		
		

	@Override
	//returns number of Data objects stored in hash table
	public int numDataItems() {
		int count = 0;
		for(int i = 0; i< hashDict.length; i++){
			if(hashDict[i] != null) { 
				count++;
			}
		}
		return count;
		
		
	}

	private int hashFunction(String key, int a) {
		int index = 0;
		for (int i = 0; i < key.length(); i++) {

			index += Math.pow(((int) (key.charAt(i))), (i+1));
		}
		return index % a;

	}
}

