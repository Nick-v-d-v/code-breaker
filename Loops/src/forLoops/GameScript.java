package forLoops;

import java.util.*;

public class GameScript {
    
    // Function for "clearing" the console
    
    static void flush() {
	
	for (int i = 0; i < 100; i++) {
	    System.out.println("");
	}
    }
    
    public static void main(String[] args) {
	
	// General variable setup
	
	int i;
	int i2;
	int randomColor;
	int attempt = 0;
	
	final int colorCount = 6;
	final int gameLength = 10;
	final int codeLength = 4;
	
	String name;
	String character;
	String positionEvaluation = "";
	String colorCode = "";
	String playerInput = "";
	
	boolean firstAttempt = false;
	boolean wrongInput = false;
	boolean correctGuess = false;
	
	Scanner sc = new Scanner(System.in);
	Random r = new Random();

	// Color list array
	
	ArrayList<String> colorList = new ArrayList<>();
	colorList.add("R");
	colorList.add("G");
	colorList.add("B");
	colorList.add("Y");
	colorList.add("P");
	colorList.add("O");
	
	// text Won - Lost


	
	final String YouWonText = "You-Won";
	
	final String YouLostText = "You-Lost";
	

	
	// Introduction
	
	System.out.println("Welcome to MASTER MIND!!!"); 
	System.out.println("Wat is your name?:");
	name = sc.nextLine();
	
	// Random code generation
	
	for (i = 0; i < codeLength; i++) {
	    
	    randomColor = r.nextInt(colorCount - 1);
	    colorCode = colorCode + colorList.get(randomColor);
	    }
	
	// Game
	
	outerLoop: for (i = 0; i < gameLength; i++) {
	    
	    // Asks for user-input and displays options
	    
	    attempt = i + 1;
	    flush();
	    
	    // Debug mode if the name is set to "Admin"
	    
	    if (name.equals("Admin")) {
		System.out.println(colorCode);
	    }
	    
	    System.out.println("Attempt: " + attempt + "/" + gameLength + "\r\n"
		    	     + "Welcome " + name + ", please enter your guess down below.\r\n"
		    	     + "Choose from: " + colorList + "\r\n");
	    
	    // Runs when the user has made a previous guess for evaluation
	    
	    if (firstAttempt == true) {
		System.out.println("Previous guess:\r\n"
				 		 + playerInput + "\n\r" + positionEvaluation + "\r\n" + "\r\n"
				 		 + "Incorrect colors are represented with hyphens (-).\r\n"
				 		 + "Correct colors are labeled black (B).\r\n"
				 		 + "Colors present in the code but in the incorrect position are labeled white (W).\r\n");
	    }
	    
	    // Runs when the user give an input longer than {codeLength}
	    
	    if (wrongInput == true) {
		wrongInput = false;
		System.out.println("ERROR\r\n"
				 		 + "Your guess must be at least " + codeLength + " characters long and only contain " + colorList + "!");
	    }
	    
	    // Makes the user-input upper case
	    
	    playerInput = sc.nextLine();
	    playerInput = playerInput.toUpperCase();
	    
	    // Checks if the code is {codeLength} characters long
	    
	    if (playerInput.length() != colorCode.length()) {
	    	i--;
	    	wrongInput = true;
	    	continue;
	    }
	    
	    // Runs when the player guesses correctly
	    
	    if (playerInput.equals(colorCode)) {
	    	
	    	correctGuess = true;
	    	break;
	    }
	    
	    // Sets variables for next execution
	    
	    firstAttempt = true;
	    positionEvaluation = "";
	    
	    // Checks if individual characters match the code and evaluates it, throws an error when the character doesn't exist
	    
	    for (i2 = 0; i2 < codeLength; i2++) {
		
	    	character = "" + playerInput.charAt(i2);
	    	if (colorList.contains(character)) {
	    	
	    		if (playerInput.charAt(i2) == colorCode.charAt(i2)) {
		    
	    			positionEvaluation = positionEvaluation + "B";
	    		}
		
	    		else if (colorCode.contains(character)) {
		    
	    			positionEvaluation = positionEvaluation + "W";
	    		}
		
	    		else {
		    
	    			positionEvaluation = positionEvaluation + "-";
	    		}
	    	}
	    	else {
	    		wrongInput = true;
	    		firstAttempt = false;
	    		i--;
	    		continue outerLoop;
	    	}
	    }
	}
	
	// No-attempts left

	sc.close();
	flush();
	
	if (correctGuess) {
	
		System.out.println(YouWonText);

	}
	else {
		
		System.out.println(YouLostText);

	}
}
}