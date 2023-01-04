//*********************************************************************************************************************************************************************************************************************
// DriverQuestion2.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 - Question 2 drop-out-stack
// DriverQuestion2.java - The purpose of this program is test the functionality of a drop out stack using linked list.
// 3 different test cases are prepared. This includes adding 5 elements, pushing 2 elements, remove 2 elements from the stack. 
////*********************************************************************************************************************************************************************************************************************

// Driver class test the functionality of a drop out stack
public class DriverQuestion2 {

    public static void main(String[] args){
    
        // setting capacity of the stack
        int maxArraySize = 5; 
        // created a drop out stack 
        DropOutStack<String> mystack = new DropOutStack<String>(maxArraySize); 
        
        // adding 5 elements onto stack 
        System.out.println("==== ADD 5 ELEMENTS ON STACK =====");
        mystack.push(new String("John")); 
        mystack.push(new String("Peter")); 
        mystack.push(new String("Katie"));
        mystack.push(new String("Koki")); 
        mystack.push(new String("Nicole")); 
        // print the all element, size, and top element of the stack
        System.out.println("the whole current stack : " +"\n" + mystack.toString());
        System.out.println("current stack size : " + mystack.size());
        System.out.println("element on top of the stack is : " + mystack.peek());
        
        // push 2 more elements on stack
        System.out.println("==== PUSH 2 ELEMENTS ON STACK =====");
        mystack.push(new String("Walter"));
        mystack.push(new String("Dwayne"));
        // print the all element, size, and top element of the stack
        System.out.println("\n"+"the whole current stack : " +"\n" + mystack.toString());
        System.out.println("current stack size : " + mystack.size());
        System.out.println("element on top of the stack is : " + mystack.peek());
        
        System.out.println(); 
        
        // extra TEST CASES 
        // remove two element from the top of the stack
        System.out.println("==== REMOVE 3 ELEMENTS FROM STACK =====");
        System.out.println("removed element 1 : " + mystack.pop());
        System.out.println("removed element 2 : "  + mystack.pop());
        System.out.println("removed element 3 : "  + mystack.pop());
        // print the all element, size, and top element of the stack
        System.out.println("the whole current stack : " +"\n" + mystack.toString());
        System.out.println("current stack size : " + mystack.size());
        System.out.println("element on top of the stack is : " + mystack.peek());
    }
} 
// end line of code - checked 
