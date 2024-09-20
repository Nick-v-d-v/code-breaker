package input03;

import java.util.Scanner;

class Input03 {

    public static void main(String[] args) {
        //Create a Scanner
        Scanner sc = new Scanner(System.in);
        //Find and print the sum of three integers entered by the user
       
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        
        System.out.println(x);
        
        //Remember to close the Scanner
        sc.close();
    }
}