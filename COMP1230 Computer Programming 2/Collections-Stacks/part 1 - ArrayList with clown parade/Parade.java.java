//*********************************************************************************************************************************************************************************************************************
// Parade.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 4 Parade
// This program simulates a parade that lined up with some clowns.
// method of manipulation of the clown can included, inserting clowns, removing clowns, and checking clowns is infront.
//**********************************************************************************************************************************************************************************************************************
import java.io.*; 
import java.util.*;

public class Parade{ // declare class to represent simulation of a parade
    private ArrayList<Clown> clownsList; //create an array list of Clown objects
    
    public Parade(){ // a constructor to instatiate array list 
        clownsList = new ArrayList<Clown>();
    }
    
    public void AddClown(Clown clown){ // declare method to accept name of clown and add clown to the parade
         clownsList.add(clown);// add clown to end of the parade
    }
    
    public void RemoveClown(){ // declare method to accept name of clown and remove clown to the parade
        clownsList.remove(0);// removes the clown who is at the front of the parade
    }
    
    public String toString(){ // declare method to print clown that exists in the parade
        String eachClown = "";// string variable to hold each single clown name
        for (int i =0; i < clownsList.size(); i++){
            eachClown = eachClown + clownsList.get(i).toString() + "\n" ;
        }
        return eachClown + "\n" ;

    }
    
      // returns true if the clown is at the front of the parade
   public boolean isFront(Clown clown)
   {
       return clownsList.get(0).equals(clown);
   }
} // end line of code 

