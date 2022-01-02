/*
 * Thomas Michalski
 * cs2210 assignment 2
 * tmichal4
 * 251027332
 * October 18, 2020
 */
import java.util.Arrays;


public class Evaluate {
	
	private char[][] gameBoard;
	//r=rows, c=column, tn=tiles needed to win, spots=# of spots on gameboard(r*c)
	private int r, c, tn, ml, spots;
	
	//constructor
	public Evaluate (int boardRows, int boardColumns, int tilesNeeded, int maxLevels) {
		this.r = boardRows;
		this.c = boardColumns;
		this.tn = tilesNeeded;
		this.ml = maxLevels;
		this.gameBoard = new char[r][c];

		for(char[] row: gameBoard) {
			Arrays.fill(row, 'g');
		}
		
	}
	
	//returns an empty Dictionary of size selected
	public Dictionary createDictionary() {
		return new Dictionary(7499);
	}

	//represents content of gameBoard as a string, then checks if string is in dictionary. if true, returns the Data object that contains it; otherwise the method returns the value null
	public Data repeatedConfig(Dictionary dict) {
		String config = Arrays.deepToString(gameBoard).replace(" " , "").replace("," , "").replace("[" , "").replace("]" , "");
		return dict.get(config);
		
		// compare
		}
	
	//represents content of gameBoard as a string, then it creates an object of class Data storing string, score, and level; Data object is then stored in dictionary
	public void insertConfig(Dictionary dict, int score, int level) {
		String config = Arrays.deepToString(gameBoard).replace(" " , "").replace("," , "").replace("[" , "").replace("]" , "");
//		dict.put(new Data(config,score,level));
		
		Data data = new Data(config, score, level);
		try {
			dict.put(data);
		}
		catch (DuplicatedKeyException e) {
		}
	}
	
	//stores symbol row and col in gameBoard
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col] = symbol;
		return;
	}
	
	//returns true if the spot on gameboard is ’g’; otherwise returns false
	public boolean squareIsEmpty (int row, int col) {
		return gameBoard[row][col] == 'g';
	}
	
	//returns true if the spot on gameboard is ’o’; otherwise returns false
	public boolean tileOfComputer (int row, int col) {
		return gameBoard[row][col] == 'o';	
	}
	
	//returns true if the spot on gameboard is ’b’; otherwise returns false
	public boolean tileOfHuman (int row, int col) {
		return gameBoard[row][col] == 'b';
	}
	
	//returns true if required number of adjacent tiles of type symbol in the same row, column, or diagonal on gameBoard (indicating a win)
	public boolean wins (char symbol) {
//		this.winner(symbol);
	
		//checking rows
		for(int row = 0; row < r; row++) {
			int rowcount = 0;
			for(int column = 0; column < c; column++) {
				if(gameBoard[row][column] == symbol) {
					rowcount++;
				}
			}
			if(rowcount == tn) {
				return true;
			}
		}
		
		//checking columns
		for(int column = 0; column < c; column++) {
			int columncount = 0;
			for(int row = 0; row < r; row++) {
				if(gameBoard[row][column] == symbol) {
					columncount++;
				}
			}
			if(columncount == tn) {
				return true;
			}
		}
		
		//diagonal top left to bottom right
		int TLBRcount = 0;
		for(int column = 0, row = r-1; row >= 0 && column < c; row--, column++) {
			if(gameBoard[row][column] == symbol) {
				TLBRcount++;
				}
			if(TLBRcount == tn) {
				return true;
			}
		}
		
		//diagonal, bottom left to top right
		int BLTRcount = 0;
		for(int column = c-1, row = 0; row < r && column >= 0; row++, column--) {
			if(gameBoard[row][column] == symbol) {
				BLTRcount++;
				}
			if(BLTRcount == tn) {
				return true;
			}
		}
		return false;
	}
	
	//Returns true if no empty positions left in gameBoard (indicating a draw); otherwise returns false
	public boolean isDraw() {
		
		if (wins('o')||wins('b')) {
			return false;
		}
		spots = r*c;
		for(int row = 0; row < r; row++) {
			int count = 0;
			for(int column = 0; column < c; column++) {
				if(gameBoard[row][column] == 'g') {
					return false;
				}
				else if(gameBoard[row][column] == 'o' || gameBoard[row][column] == 'b' || gameBoard[row][column] == 'd') {
					count++;
				}
			}
			if(count == spots) {
				return true;
			}
		}
		return false;
		
	}
	
	
	/* returns values based on the result of the game
	 * 3, if the computer won
	 * 0, if the human player has won
	 * 2, if the game is a draw
	 * 1, if the game is still undecided
	*/
	public int evalBoard() {
		if(wins('o')) {
			return 3;
		}
		else if(wins('b')) {
			return 0;
		}
		else if(isDraw()) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	


	
}
