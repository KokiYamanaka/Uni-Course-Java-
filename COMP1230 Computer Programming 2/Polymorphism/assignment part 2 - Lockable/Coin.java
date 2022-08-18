//*********************************************************************************************************************************************************************************************************************
// Coin.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism - part 2
// this program represents a coin object that can be flipped. 
//**********************************************************************************************************************************************************************************************************************
 
import java.util.*;

public class Coin implements Lockable{

    // variable to hold the state of side of the coin 
   private final int HEADS =0;
   private final int TAILS =1;
   private  int face ; 
 
   // variable to hold the state the object's lock or unlock 
   private int key = 0;
   private boolean locked = false; 
   
   // declare constructor to flip the coin for initial 
   public Coin() {
           flip();
   }
    
    // declare method to randomly pick a side of the coin 
   public void flip(){
       if (locked){
        System.out.println("not flipped : locked");
            return; 
        }
        face = (int) ( Math.random()*2);
   }
   
   // declare method to return head is state of coin is heads 
   public boolean isHeads(){
       if (locked){
        System.out.println("can't determine locked");
            return false; 
        }
        return (face == HEADS);
    } 
       // declare method to return current state of coin whether is head or tails 
   public String toString(){
       if (locked) return "locked";
       return (face == HEADS) ? "Heads":"Tails"; 
    }
    
   // declare method to set key 
   public void setKey (int set) {
       key = set;
    }

   // declare method to provide functionality to lock object 
   public void lock(int key){
       if (key == this.key){
            locked = true; 
        }
    }
    
     //declare method to provide functionality to unlock  object 
   public void unlock (int key){
        if (key == this.key){
            locked = false; 
        }
    }
    
    // declare method to return the state of object  
    public boolean locked (){
         return locked;
    }
} // end line of code - for Coin class

