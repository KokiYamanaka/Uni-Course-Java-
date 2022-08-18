
//*********************************************************************************************************************************************************************************************************************
// Priority.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism 
// this program defines numeric priority values and declare abstract methods for setting and getting priority.
//**********************************************************************************************************************************************************************************************************************
 
public interface Priority // declare interface to group constant priority values and get&set priority methods
{
   // declare numeric priority values
   public static final int LOW = 1;
   public static final int MEDIUM = 2;
   public static final int HIGH = 3;
  
   // declare get & set method for manipulate priority values 
   public void setPriority(int priority);
   public int getPriority();
} // end line of code - for Priority interface