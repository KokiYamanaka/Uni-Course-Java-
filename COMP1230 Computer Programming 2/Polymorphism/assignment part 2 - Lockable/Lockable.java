
//*********************************************************************************************************************************************************************************************************************
// Lockable.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism - part 2
// this program (interface)  purpose is to declare necessary method to manipulate Coin class 
//**********************************************************************************************************************************************************************************************************************
 

public interface Lockable
{
    // declare necessary methods to manipulate coin object
   public void setKey(int newkey);
   public void lock(int key);
   public void unlock(int key);
   public boolean locked(); 
} // end line of code - for Lockable interface 
