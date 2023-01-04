//*********************************************************************************************************************************************************************************************************************
// ArrayStack.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 3 - Question 2 stack using arraylist 
// ArrayStack.java - The program represents a stack implemented by arraylist. 
// Multiple methods has been implemented to manipulate elements and the stack.   
////*****************************************************************************************************************************************************************************************
import java.util.ArrayList;

public class ArrayStack<T> implements StackADT<T> {
    // create stack container
    private ArrayList<T> stack;

    // create an empty stack 
    public ArrayStack() {
        stack = new ArrayList<T>();
    }

    // add element into the top of the stack
    public void push(T element) {
        stack.add(0, element); 
    }

    // Removes and returns the top element from this stack.  
    public T pop(){
        T result; 
        result = stack.remove(0);
        return result ; 
    }
    
    // Returns without removing the top element of this stack.
    public T peek(){
        T result;
        if (isEmpty()) 
            return null; 
        else 
            result = stack.get(0);
            return result ; 
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