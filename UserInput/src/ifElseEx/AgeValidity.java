/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifElseEx;

import java.util.Scanner;

/**
 *
 * @author anshenoy
 */
public class AgeValidity {

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	
    	 
        boolean drivingunderAge = false;
    	 
    	int x = 18;
    	
		int age = sc.nextInt(); 
		
    	System.out.println(age <= x);

    	sc.close();
    }
}
