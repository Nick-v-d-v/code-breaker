package arrayEx;

import java.util.*;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] c = new String[6];

        c[0] = "Yellow";
        c[1] = "Red";
        c[2] = "Blue";
        c[3] = "Green";
        c[4] = "Purple";
        c[5] = "Orange";

        // Willekeurige kleuren selecteren
        List<String> colorList = Arrays.asList(c);
        Collections.shuffle(colorList); // Schud de kleurenlijst

        // Selecteer de eerste vier kleuren na schudden
        String computerColor1 = colorList.get(0);
        String computerColor2 = colorList.get(1);
        String computerColor3 = colorList.get(2);
        String computerColor4 = colorList.get(3);

        int colorsright = 0;
        System.out.println("Guess the code using the following colors: Blue, Green, Yellow, Purple, Orange, and Red. You get 10 attempts before you lose. Black = Good   White = Good but at the wrong place");

        for (int rowloop = 1; rowloop <= 10; rowloop++) {
            System.out.println("Color one:");
            String userColor1 = capitalize(input.nextLine());

            System.out.println("Color two:");
            String userColor2 = capitalize(input.nextLine());

            System.out.println("Color three:");
            String userColor3 = capitalize(input.nextLine());

            System.out.println("Color four:");
            String userColor4 = capitalize(input.nextLine());

            colorsright = 0;  // Reset het aantal juiste kleuren voor deze poging

            // Controleer de eerste kleur
            if (userColor1.equals(computerColor1)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor1.equals(computerColor2) || userColor1.equals(computerColor3) || userColor1.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("-");
            }

            // Controleer de tweede kleur
            if (userColor2.equals(computerColor1)) {
                System.out.println("white");
            } else if (userColor2.equals(computerColor2)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor2.equals(computerColor3) || userColor2.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("-");
            }

            // Controleer de derde kleur
            if (userColor3.equals(computerColor1)) {
                System.out.println("white");
            } else if (userColor3.equals(computerColor2)) {
                System.out.println("white");
            } else if (userColor3.equals(computerColor3)) {
                System.out.println("black");
                colorsright++;
            } else if (userColor3.equals(computerColor4)) {
                System.out.println("white");
            } else {
                System.out.println("-");
            }

            // Controleer de vierde kleur
            if (userColor4.equals(computerColor1)) {
                System.out.println("white");
            } else if (userColor4.equals(computerColor2)) {
                System.out.println("white");
            } else if (userColor4.equals(computerColor3)) {
                System.out.println("white");
            } else if (userColor4.equals(computerColor4)) {
                System.out.println("black");
                colorsright++;
            } else {
                System.out.println("-");
            }

            // Controleer of de speler heeft gewonnen
            if (colorsright == 4) {
                System.out.println("You win!");
                break; // Stop de loop bij winst
            }

            System.out.println("Colors to choose from: Blue, Green, Yellow, Purple, Orange, and Red.");
        }

        // Als de speler niet heeft gewonnen
        if (colorsright < 4) {
            System.out.println("You lost.");
        }
    }

    // Methode om een string te kapitaliseren
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}