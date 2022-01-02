/*
 * Thomas Michalski
 * cs2210 assignment 2
 * tmichal4
 * 251027332
 * October 18, 2020
 */

public class Data {
	
	private String key;
	private int score;
	private int level;
	
	//constructor for class "Data"
	public Data(String key, int score, int level) {
		this.key = key;
		this.score = score;
		this.level = level;
		
	}
	
	//returns string stored in this Data object
	public String getKey() {
		return key;
	}
	
	//returns first integer stored in this Data object
	public int getScore() {
		return score;
	}
	
	//returns second integer stored in this Data object
	public int getLevel() {
		return level;
	}
	
}
