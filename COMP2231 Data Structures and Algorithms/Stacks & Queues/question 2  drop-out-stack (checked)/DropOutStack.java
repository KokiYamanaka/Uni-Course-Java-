
//*********************************************************************************************************************************************************************************************************************
// DropOutStack.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 - Question 2 drop-out-stack
// DropOutStack.java - The purpose of this program is provide functionality of a drop out stack using linked list.
// DropOutStack is similar to a stack, except they are fixed in size. As an element is push onto the stack with max capacity, the bottom element will be removed.
// Users can create and manipulate a node in a list by using provided methods.
////*********************************************************************************************************************************************************************************************************************


//Represents a linked implementation of a stack.
public class DropOutStack<T> implements StackADT<T>
{
    // variables to count the number of elements and to store the maximum size of the stack.
    private int count, maxCapacity =0;  
    // a node to  represents the top of the stack 
    private LinearNode<T> top; 
    
    /**
     * Creates an empty stack.
     */
    public DropOutStack(int max)
    {
        // initiliaze element count to 0
        count = 0; 
        // set the top node to null
        top = null;
        // store the max capacity of the stack from user's input 
        maxCapacity = max;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        // remove the bottom element if a new element is pushed and stack reached its max capacity
        // that is, the current stacked elements is equal to the max capacity of the stack.
        if (count == maxCapacity) { 
            
            // create a temporary node 
            LinearNode current = top ;
            
            // iterate the temporary node from the top of stack to the 2nd last element
            for ( int i = 1 ; i < maxCapacity-1; i++) { 
                current = current.getNext(); //  get the next node through pointer 
            }
            
            // set the last node's reference to empty node(null)
            current.setNext(null);
            
            // decrease the count of the current elements in the stack 
            count--;
        }
        
        
        // create a new node with a reference towards a new element  
        LinearNode<T> newNode = new LinearNode<T>(element);
        // point the new node towards the top of the node in a stack 
        newNode.setNext(top); 
        // reset the top node's reference to the new node (new node becomes the top of the stack)
        top = newNode;
        // increase the count of the current element
        count++;
    }

    
    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        // check if the stack is empty 
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        // get the top element on the stack 
        T result = top.getElement();
        // set the top node to the next 2nd top node  
        top = top.getNext();
        //  decrease the count of the element       
        count--;
        // get the top of the stack
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty  
     */
    public T peek() throws EmptyCollectionException
    {
        // if the stack is empty,throw an exception
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        // get the top element from stack
        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        // return true if current count of element in stack is 0
        return (count == 0);
    }

    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this stack.
     * @return string representation of the stack
     */
    public String toString()
    {
        // intialize string variable 
        String result = "";
        // create a temporary node
        LinearNode current = top;

        // iterate the temporary node as long as it doesn't reference towards to null in a list
        while (current != null)
        {
            // get the element in string format 
            result = result + current.getElement() + "\n";
            // get the next node through reference
            current = current.getNext();
        }

        // get all of the element in the stack
        return result;
    }
}
// end line of code - checked

