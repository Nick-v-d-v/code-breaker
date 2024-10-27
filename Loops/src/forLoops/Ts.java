package forLoops;

import java.util.Random;
import java.util.Scanner;

public class Ts {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        // De geheime code bestaat uit 4 kleuren, vertegenwoordigd door nummers van 1 tot 6
	        int[] secretCode = new int[4];
	        
	        // Genereer de geheime code
	        for (int i = 0; i < 4; i++) {
	            secretCode[i] = random.nextInt(6) + 1; // Genereer een nummer tussen 1 en 6
	        }

	        System.out.println("Welkom bij Mastermind!");
	        System.out.println("Raad de geheime code (4 kleuren van 1 tot 6).");

	        // Maximum aantal pogingen
	        int attempts = 10;

	        // Start de spelronde
	        for (int attempt = 1; attempt <= attempts; attempt++) {
	            System.out.print("Poging " + attempt + ": Voer 4 nummers in (1-6) gescheiden door spaties: ");
	            String input = scanner.nextLine();
	            String[] inputParts = input.split(" ");
	            
	            // Controleer of de invoer geldig is
	            if (inputParts.length != 4) {
	                System.out.println("Voer precies 4 nummers in.");
	                attempt--; // Dit telt niet mee als een poging
	                continue;
	            }

	            // Converteer invoer naar een array van integers
	            int[] userGuess = new int[4];
	            for (int i = 0; i < 4; i++) {
	                userGuess[i] = Integer.parseInt(inputParts[i]);
	            }

	            // Controleer de invoer tegen de geheime code
	            int correctPositions = 0;
	            int correctNumbers = 0;

	            // Controleer voor juiste posities
	            for (int i = 0; i < 4; i++) {
	                if (userGuess[i] == secretCode[i]) {
	                    correctPositions++;
	                } else if (contains(secretCode, userGuess[i])) {
	                    correctNumbers++;
	                }
	            }

	            // Geef feedback aan de gebruiker
	            System.out.println("Juiste posities: " + correctPositions + ", Juiste nummers: " + correctNumbers);

	            // Controleer of de gebruiker de code heeft geraden
	            if (correctPositions == 4) {
	                System.out.println("Gefeliciteerd! Je hebt de geheime code geraden!");
	                break;
	            }
	        }

	        // Als de gebruiker het niet raadt
	        if (attempts == 10) {
	            System.out.println("Helaas! De geheime code was: " + arrayToString(secretCode));
	        }

	        scanner.close();
	    }

	    // Controleer of een getal in de array zit
	    private static boolean contains(int[] array, int number) {
	        for (int value : array) {
	            if (value == number) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Hulpmethode om een array om te zetten naar een string
	    private static String arrayToString(int[] array) {
	        StringBuilder sb = new StringBuilder();
	        for (int value : array) {
	            sb.append(value).append(" ");
	        }
	        return sb.toString().trim();
	    }
	}