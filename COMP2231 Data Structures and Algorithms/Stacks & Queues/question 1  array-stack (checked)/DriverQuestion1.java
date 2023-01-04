//*********************************************************************************************************************************************************************************************************************
// DriverQuestion1.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 1) 
// DriverQuestion1.java - This is a program to test the functionality of an array stack, except the top variable points to the actual top of the stack.
//**********************************************************************************************************************************************************************************************************************

public class DriverQuestion1 {

    public static void main(String[] args){
    
        ArrayStack<Integer> mystack = new ArrayStack<Integer>(); 
        
        System.out.println("======== TEST CASE 1 ========");
        // demostrate method to add elements
        mystack.push(new Integer(71)); 
        mystack.push(new Integer(72)); 
        mystack.push(new Integer(73));
        mystack.push(new Integer(74));
        mystack.push(new Integer(75));
        System.out.print(mystack.toString());// demostrate method to print all element
        System.out.println(mystack.showTop()); // show the top variable 
        System.out.println();
        
        // remove 2 elements and peek 1 element from stack 
        System.out.println("======== TEST CASE 2 ========");
        mystack.pop(); 
        mystack.pop();
        System.out.println("peeked element : " + mystack.peek());
        System.out.print(mystack.toString());// demostrate method to print all elements
        System.out.println(mystack.showTop()); // show the top variable 
        System.out.println();
        
        System.out.println("======== TEST CASE 3 ========");
        mystack.pop(); 
        mystack.pop();
        mystack.pop(); 
        System.out.print(mystack.toString());// demostrate method to print all elements
        System.out.println(mystack.showTop()); // show the top variable 
        System.out.println();
        // make stack empty and check if stack is empty 
    }
}