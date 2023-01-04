//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 3 - Question 1 stack using Linkedlist 
// Driver.java - The purpose of this program is to test the functionality stack implemented by Linkedlist.
// All of the methods from LinkedStack has been used/test in this program.
////*********************************************************************************************************************************************************************************************************************
import java.util.*;
public class Driver
{
    public static void main(String[] args) {
    // instance variables - replace the example below with your own
        LinkedStack<String> stack = new LinkedStack<String>();
        
        System.out.println("======== Add 3 element to the stack ========"); 
        stack.push("John"); 
        stack.push("Nick"); 
        stack.push("Aaron"); // top element 
        System.out.println(stack.toString());
        
        System.out.println("======== remove 1 element ========");
        stack.pop();
        System.out.println(stack.toString()); 
        
        System.out.println("======== show current top element wihtout removing ========"); 
        System.out.println("current element on the top is :" + stack.peek() + "\n"); 
        System.out.println(stack.toString());
        
        System.out.println("========= remove 2 element and check if stack is empty =======");
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
        
        System.out.println("========= add 3 element and check if stack is empty =======");
        stack.push("John"); 
        stack.push("Nick"); 
        stack.push("Aaron"); // top element 
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
        
        System.out.println("========= check the current size of the stack =======");
        System.out.println(stack.toString());
        System.out.println(stack.size());
    }
}
