//*********************************************************************************************************************************************************************************************************************
// LinkedStack.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 3 - Question 1 stack using Linkedlist
// LinkedStack.java - The program represents a stack implemented by Linkedlist. 
// Multiple methods has been implemented to manipulate elements and the stack using Linkedlist class from java.util.   
////*****************************************************************************************************************************************************************************************
import java.util.LinkedList ;

public class LinkedStack<T> implements StackADT<T> {
    // create stack container
    private LinkedList <T> stack;

    // create an empty stack 
    public LinkedStack() {
        stack = new LinkedList<T>();
    }

    // add element into the top of the stack
    public void push(T element) {
        stack.push(element); 
    }

    // Removes and returns the top element from this stack.  
    public T pop(){
        T result; 
        result = stack.pop(); 
        return result ; 
    }
    
    // Returns without removing the top element of this stack.
    public T peek(){
        return stack.peek();
    }
    
    // Returns true if this stack contains no elements. 
    public boolean isEmpty(){
        return stack.isEmpty();  
    }
    
    // returns the number of elements in this stack.
    public int size(){
        return stack.size(); 
    }
    
    //  Returns a string representation of this stack.
    public String toString(){
        String result = "";
        
        // note that type has not yet declared for "for-each loop"
        // loop through each element in the stack and receive its object element.
        for ( T element : stack){
            result = result + element + "\n";
        }
        return result; 
    }
}