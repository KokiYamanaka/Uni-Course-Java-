//*********************************************************************************************************************************************************************************************************************
// RandomDraw.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 4 RandomDrawBox
// This program test the functinality of RandomDrawBox class.
// we add 5 names and 5 integers number into box, then we pick a number for a name, representing which seat he/she will occupy 
//**********************************************************************************************************************************************************************************************************************
import java.io.*; 
import java.util.*;

public class Driver { // class to test functionality of RandomDrawBox class
    public static void main(String[] args) {
        RandomDrawBox<String> names = new RandomDrawBox <String> ();   // create box to store first name
        RandomDrawBox<Integer> seats =new RandomDrawBox<Integer>(); // create box to store lottery number
    
        // adding 5 names
        names.add("Koki");  
        names.add("Mike");  
        names.add("Joe") ;
        names.add("Putin") ;
        names.add("Yanni") ;
    
        //Assign the seats
        seats.add(1);
        seats.add(2);
        seats.add(3);
        seats.add(4);
        seats.add(5);
        
        // pick a lottery number for a person to seat 
        String chosenName= names.DrawItem(); 
        Integer chosenSeat= seats.DrawItem();
        System.out.println("Name: "+chosenName);
        System.out.println("which seat he is seating at : "+chosenSeat);


    }
}

 