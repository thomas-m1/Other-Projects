//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.lang.Object;
//import java.util.StringTokenizer;
//
//public class TextInterface {
//	
//	public static void main(String[] args) {
//		
//		// creates new dictionary
//		OrderedDictionary dictionary = new OrderedDictionary();
//		String fileName = args[0];
//		try {
//		//reads input file
//		BufferedReader in = new BufferedReader(new FileReader(fileName));
//	    String name = in.readLine();
//	    String content = "", kind;
//	    boolean test = true;
//	    
//	    // reads lines in textfile and stores it into the dictionary
//	    try {
//	    	while (name != null) {
//	    		try {
//	    			content = in.readLine();
//	    			if (content.endsWith(".wav") || content.endsWith(".mid") ) {
//	    				kind = "sound";
//	    				dictionary.put(new DataItem(new Key(name,kind),content));
//	    				name = in.readLine();
//	    			}
//	    			else if (content.endsWith("gif")|| content.endsWith(".jpg")) {
//	    				kind = "picture";
//	    				dictionary.put(new DataItem(new Key(name,kind),content));
//	    				name = in.readLine();
//	    			}
//	    			else if(content.endsWith(".html")) {
//	    				kind = "url";
//	    				dictionary.put(new DataItem(new Key(name,kind),content));
//	    				name = in.readLine();
//	    			}
//	    			else if	(content.endsWith(".exe")) {
//	    				kind = "program";
//	    				dictionary.put(new DataItem(new Key(name,kind),content));
//	    				name = in.readLine();
//	    			}
//	    			else {// if	(content.endsWith("."))
//	    				kind = "definition";
//	    				dictionary.put(new DataItem(new Key(name,kind),content));
//	    				name = in.readLine();
//	    			}
//	    		}
//	    		catch (Exception e) {
//	    			test = false;
//	    		}
//	    		}
//	    }
//	    catch (Exception e) {
//			System.out.println("error");
//	    } 	
//	    	
//		
//		String firstWord = null;// initialize firstWord
//		
//		while (firstWord != "end") {
//			
//		    //creates a string reader and prompts user for command
//			StringReader keyboard = new StringReader(); 
//			String line = keyboard.read("Enter a command: ");
//			
//			//reads first word from user
//			StringTokenizer input = new StringTokenizer(line); 
//			firstWord = input.nextToken();
//
//			//if users first word is get, program gets file and displays content
//			if (firstWord.equals("get")) {
//				String secondWord = input.nextToken();
//				
//				Key temp = new Key(secondWord, null);
//
//				if (dictionary.get(temp) == null) {
//					System.out.println("The word " + secondWord + " is not in the ordered dictionary");
//					dictionary.get(temp);
//					DataItem succ = dictionary.successor(temp);
//					DataItem pred = dictionary.successor(temp);
//					System.out.println("Preceding word" + succ);
//					System.out.println("Following word" + pred);
//				}
//				else {
//					
//					temp.setKind("definition");
//					if (dictionary.get(temp) != null)//???????
//						System.out.println(dictionary.get(temp).getContent());
//					}
//					
//					temp.setKind("picture");
//					if (dictionary.get(temp) != null) {
//						//DataItem dictionary.gettemp();
//						PictureViewer viewer = new PictureViewer();
//						try {
//							viewer.show(dictionary.get(temp).getContent());
//						}
//						catch (Exception e) {
//							System.out.println("Error executing command:" + e);
//
//						}
//					
//					temp.setKind("sound");
//					if (dictionary.get(temp) != null) {
//						SoundPlayer player = new SoundPlayer();
//						try {			
//							player.play(dictionary.get(temp).getContent());
//						}
//						catch (Exception e) {
//							System.out.println("Error executing command:" + e);
//						}
//					}
//					
//					temp.setKind("program");
//					if (dictionary.get(temp) != null) {
//						RunCommand processor = new RunCommand();
//						processor.run(dictionary.get(temp).getContent());
//					}
//					
//					temp.setKind("url");
//					if (dictionary.get(temp) != null) {
//						ShowHTML browser = new ShowHTML();
//						browser.show(dictionary.get(temp).getContent());
//					}
//				}
//			}
//			
//			//if users first word is remove, program removes specified file from dictionary
//			else if (firstWord.equals("remove")) {
//				String secondWord = input.nextToken();
//				String thirdWord = input.nextToken();
//				
//				if (dictionary.get(new Key(secondWord,thirdWord)) == null) {
//					System.out.println("No record in the ordered dictionary has key (" + secondWord + ", "+ thirdWord + ")");
//					}
//				else {
//					DataItem node = dictionary.get(new Key(secondWord,thirdWord));
//					dictionary.remove(node.getKey());
//				}
//			}
//			
//			//if users first word is add, program adds an item into the dictionary
//			else if (firstWord.equals("add")) {
//				String secondWord = input.nextToken();
//				String thirdWord = input.nextToken();
//				int tokenLength = input.countTokens();
//				
//				//stores user input to content
//				for(int i = 0; i<tokenLength-2; i++) {
//					String s = input.nextToken();
//					content = s + s;
//				}
//				
//				
//				if (dictionary.get(new Key(secondWord,thirdWord)) == null) {
//					dictionary.put(new DataItem(new Key(secondWord,thirdWord),content));
//				}
//				else {
//					System.out.println("A record with the given key (w,k) is already in the ordered dictionary.");
//				}
//				
//
//				
//			}
//			
//			//if users first word is list, program lists all files with given prefix
//			else if (firstWord.equals("list")) {
//				String secondWord = input.nextToken();
//				
////				dictionary.get((dictionary.get((secondWord,"program"),root))
////				
////				startsWith(secondWord)
//			}
//			
//			//if users first word is first, program gets smallest key and prints it	
//			else if (firstWord.equals("first")) {
////				small = dictionary.smallest(dictionary.getRoot());
////				System.out.println(small);
//
//			}
//			
//			//if users first word is last, program gets largest key	 and prints it			
//			else if (firstWord.equals("last")) {
////				largest = dictionary.largest(root);
////				System.out.println(smallest);
//			}
//			
//			//if users first word is end, program terminates	
//			else if (firstWord.equals("end")) {
//				firstWord = "end";			
//			}
//			
//			//if user enters invalid word, warns user	
//			else {
//				System.out.println("sorry, that was an invalid command. Please try again or press end to terminate: ");				
//			}
//		}
//
//	}
//	    catch (Exception e) {
//			System.out.println("error");
//	    }
//	}
//	    
//}


import java.awt.Desktop;
import java.awt.Image;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TextInterface {

	public static void main(String[] args) throws DictionaryException {
		Scanner in;
		OrderedDictionary dictionary = new OrderedDictionary();
		StringReader command = new StringReader();
		
		try {
			in = new Scanner(new File(args[0]));
			String name, content, kind;
			while (in.hasNextLine()) {  //continue until eof
				name = in.nextLine(); //read name line
				content = in.nextLine(); //read content line

				if (content.indexOf(".wav") != -1 || content.indexOf(".mid") != -1) {
					kind = "sound";
				}
				else if (content.indexOf(".jpg") != -1 || content.indexOf(".gif") != -1) {
					kind = "picture";
				}
				else if (content.indexOf(".html") != -1) {
					kind = "url";	
				}
				else if (content.indexOf(".exe") != -1) {
					kind = "program";
				}
				else {
					kind = "definition";
				}
				dictionary.put(new DataItem(new Key(name, kind), content));//////////////////////////////////////////////
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		

		
		String input[];
		while (true) {
			input = command.read("Enter a command: ").split(" ");
			//checks if user inputed a get command - displays data file
			if (input[0].equals("get")) {
				Key[] keys = new Key[] {new Key(input[1], "definition"), new Key(input[1], "sound"), new Key(input[1], "picture"), new Key(input[1], "url"), new Key(input[1], "program")};
				//if the key entered does not exist, return predecessor and successor
				if (dictionary.get(keys[0]) == null && dictionary.get(keys[1]) == null && dictionary.get(keys[2]) == null && dictionary.get(keys[3]) == null && dictionary.get(keys[4]) == null) { 
					System.out.println("The word " + input[1] + " is not in the ordered dictionary.");
//					DataItem preceding = dictionary.predecessor(new Key(input[1], " "));
//					String st = preceding.toString();
//					System.out.println(st); 
					System.out.println("Preceding word: " + dictionary.predecessor(new Key(input[1], " ")));
					System.out.println("Following word: " + dictionary.successor(new Key(input[1], " ")));

				} 
				else {

					if (dictionary.get(keys[0]) != null) //output definition
						System.out.println(dictionary.get(keys[0]).getContent());
					if (dictionary.get(keys[1]) != null) { //play audio, top 3 lines play natively in Java, only works if this is NOT the first get command
						try {
							Desktop.getDesktop().open(new File(dictionary.get(keys[1]).getContent()));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (dictionary.get(keys[2]) != null) { //open picture
						try {
							Desktop.getDesktop().open(new File(dictionary.get(keys[2]).getContent()));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
					}
					if (dictionary.get(keys[3]) != null) { //open HTML page
						try {
							Desktop.getDesktop().browse(new File(dictionary.get(keys[3]).getContent()).toURI());
						} catch (Exception e) {
				            e.printStackTrace();
				        }
					}
					if (dictionary.get(keys[4]) != null) { //open program
						try {
							Desktop.getDesktop().open(new File(dictionary.get(keys[4]).getContent()));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				
				
				
			}
			//checks if user inputed a remove command - removes data item from tree
			/////////////////////////remove only working if we put the "" for input 2... compare then if statements?
			else if (input[0].equals("remove")) {
				try {
					System.out.println(input[1]+input[2]);
					if (input[2].equals("definition")){
						System.out.println("No re");
					}
					dictionary.remove(new Key(input[1], input[2]));
				} catch (DictionaryException e) {
					System.out.println("No record in the ordered dictionary has key (" + input[1] + ", " + input[2] + ").");
				}
			}
			//checks if user inputed an add command - adds data item to tree
			else if (input[0].equals("add")) {
				try {
					String str = input[3];
					//concatenate remainder of input array to account for splitting at each space
					for (int i = 4; i < input.length; i++) {
						str += " " + input[i];
					}
					dictionary.put(new DataItem(new Key(input[1], input[2]), str)); //try to add the data item with the given key and catch DictionaryException
				} catch (DictionaryException e) {
					System.out.println("A record with the given key (" + input[1] + ", " + input[2] + ") is already in the ordered dictionary.");
				}
			} 
			
			
			
			
			
			
			
			//lists dictionary items with prefixes given by the user
			else if (input[0].equals("list")) {
				Key last = dictionary.largest().getKey();
				Key curr = dictionary.smallest().getKey();
				boolean check = false;
				while (true) {
					//checks through tree starting from the smallest and checks if the substrings match the user input substring
					if (curr.getName().substring(0, input[1].length()).equals(input[1])) {
						System.out.println(curr.getName());
						check = true;
					}
					//if search through tree ends on the last one, then search is done
					if (curr.compareTo(last) == 0 || dictionary.successor(curr) == null) {
						break;
					}
					curr = dictionary.successor(curr).getKey();//checks next successor to search the whole tree
				}
				if (!check) System.out.println("No name attributes in the ordered dictionary start with prefix " + input[1] + ".");
			}
			//prints smallest item in dictionary
			else if (input[0].equals("first")) {
				DataItem first = dictionary.smallest();
				System.out.println(first.getKey().getName() + ", " + first.getKey().getKind() + ", " + first.getContent());
			}
			// prints largest item in dictionary
			else if (input[0].equals("last")) {
				DataItem last = dictionary.largest();
				System.out.println(last.getKey().getName() + ", " + last.getKey().getKind() + ", " + last.getContent());
			} 
			//ends program
			else if (input[0].equals("end")) {
				System.out.println("Goodbye");
				break;
			}
			//if user enters wrong command, print message
			else {
				System.out.println("Invalid command, please try again.");
			}
		}
	}

}