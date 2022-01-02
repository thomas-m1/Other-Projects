
public class DataItem {
	
	private String content;
	private Key theKey;
	
	//nodes stored in binary search tree
	
	// recieves key and associated data
	public DataItem(Key k, String data) {
		this.theKey = k;
		this.content = data;
	}
	
	//returns key
	public Key getKey() {
		return theKey;	
	}
	
	//returns content
	public String getContent() {
		return content;	
	}
	
}
