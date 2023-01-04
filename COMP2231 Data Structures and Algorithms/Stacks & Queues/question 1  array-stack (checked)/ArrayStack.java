//*********************************************************************************************************************************************************************************************************************
// ArrayStack.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 1) 
// ArrayStack.java - This is a implementation of an array stack, except the top variable points to the actual top of the stack.
//**********************************************************************************************************************************************************************************************************************

import java.util.Arrays;

// class represents array stack  
public class ArrayStack<T> implements StackADT<T>
{
    // define the current maximum capacity of the stack
    private final static int DEFAULT_CAPACITY = 100;

    // variable to store the actual top of the element
    private int top;
    //create a stack 
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    // modified 
    /**
     * Show the index of the top element on stack.
     */
    public String showTop(){
        return "top variable points to index : "+(top) ; 
    } 
    
    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity)
    {
        top = -1;
        stack = (T[])(new Object[initialCapacity]);
    }

    // modified
    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        if (size() == stack.length)
            expandCapacity();

        // count the current index of top element 
        top++; 
        
        // store the element to the top of stack
        stack[top] = element; 
        
        //top++; 
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        // top--;
        
        // get the top element of the stack 
        T result = stack[top];
        
        // set the top stack points to null
        stack[top] = null;
        
        // decrement the index position of the top element 
        top--;

        // return the top element 
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top];
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        return (top == -1);
    }

    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        if (isEmpty())
            return 0;
            
        else 
            return top+1;
        
    }

    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString()
    {
        String result = "";

        for (int scan=0; scan < top+1; scan++)
             result = result + stack[scan] + "\n";

        return result;
    }
}

