//*********************************************************************************************************************************************************************************************************************
// RandomDrawBox.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 4 RandomDrawBox 
// This program simulates a hidden box with cards contained lottery number & First names.
// method for interacting with cards and box include - (1) adding card to to box (2) checking card is empty in box (3) pick a card from box and delete it. (4) displaying all current cards in box
//**********************************************************************************************************************************************************************************************************************
import java.io.*; 
import java.util.*;

class RandomDrawBox <Type>{
    private Type boxItems[]; // container to store cards
    private int cardAmount; // variable to hold current amount of cards
    
    public RandomDrawBox(){ // class contructor initialize item cards
        cardAmount = 0;
    }
    
    public void add(Type inItem){// method to add card with First name & Lottery number
        
        if (inItem instanceof String){ //If card is written in string
            if (boxItems == null){ // if box is empty initialize container
                boxItems = (Type[]) new String[10];
            }
                boxItems[cardAmount] = inItem; // add card into the the box 
                cardAmount++;//increment the count of card in box
            }
            
        if (inItem instanceof Integer){//if card is written in integer
            if (boxItems == null){
                boxItems = (Type[]) new Integer[10];
            }
                boxItems[cardAmount] = inItem;
                cardAmount++;
        }
        
    }
    
    public boolean isEmpty(){ // method to check whether the box is empty. 
        if (cardAmount == 0){
            return true;
        }
        else {
            return false; 
        }
    }
    
    public Type DrawItem(){ // method to pick a card from box
        Random randObj = new Random();// create a random integer 
        if (cardAmount != 0){// if box is not empty
            return boxItems[randObj.nextInt(cardAmount)];
        }
        else {  // if box is empty return null 
            return null;
        }
     }    
     
    public String toString() { // method to return all cards in box
        String s = ""; // variable to hold all cards in box for display
        if (cardAmount != 0 ){ // if there are card in list, gather all cards from box 
            for (Type inItem : boxItems) {
                s += inItem + ", "; // add each card 
            }
            s += "\n"; // make new line for variable that hold cards for display
        }
        return s; // return all gathered cards from box
    }
} // end line of code
 

 
 