
public class Key {
	
	private String name;
	private String kind;
	
	//constructor that initializes a new Key object
	public Key(String word, String type) {	
		//converts word to lowercase
		word = word.toLowerCase();
		this.kind = type;
		this.name = word;
	}

	//returns string in name
	public String getName() {
		return this.name;
	}
	
	//returns string in kind
	public String getKind() {
		return this.kind;
	}
	
	public void setKind(String k) {
		kind = k;
	}
	
	public int compareTo(Key k) {
		//returns 0 if key object is equal to k, -1 if key object is smaller than k, and 1 otherwise
		if (name.compareTo(k.name) < 0 || (name.compareTo(k.name) == 0 && kind.compareTo(k.kind)<0))
			return -1;
		else if (name.compareTo(k.name) == 0 && kind == k.kind)
			return 0;
		else 
			return 1;
	}

	
}
