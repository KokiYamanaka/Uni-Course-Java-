//*********************************************************************************************************************************************************************************************************************
// AverageIntegers.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 3 exceptions
// this program calculates average of every user input value, then outputs them.
// note that, if user enter stop, the program stops asking user to re-enter integer.
//**********************************************************************************************************************************************************************************************************************

import java.io.*; 
import java.util.*;
 
public class AverageIntegers {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); // declare scanner 
       String enteredValue = sc.nextLine(); // variable to hold user integer
       double sum = 0;// variable to hold sum of integer user has input 
       double cnt = 0;// variable to hold how many valid integer user has input
       while(true){
            try{
                int convertedInt = Integer.parseInt(enteredValue); // converting user's string value to object (wraper) Integer 
                sum = sum + convertedInt; // add up user input value to sum 
                cnt ++; // add 1 when user input once 
                System.out.println("Your average value will be" + sum/cnt);
            }
            catch (NumberFormatException e ){
                System.out.println("Re-enter a valid integer"); // notice user to re-enter an integer
                enteredValue = sc.nextLine();
            }
            enteredValue = sc.nextLine();
            if (enteredValue.equals("stop")){ // if user enter string "stop", then stop asking user to for an integer and output average of sum 
                break;
            }
        }
   }
    
}// end line of code - for AverageIntegers 