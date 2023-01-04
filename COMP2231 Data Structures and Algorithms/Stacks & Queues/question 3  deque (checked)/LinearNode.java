//*********************************************************************************************************************************************************************************************************************
// LinearNode.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 3) 
// LinearNode.java - LinearNode represents a node reference to the next/previous node and the element.  
//**********************************************************************************************************************************************************************************************************************


public class LinearNode<T>
{
    // node to repesent the next node 
    private LinearNode<T> next;
    // variable to store element 
    private T element;

    // node to represent previous node 
    private LinearNode<T> previous;  
    
    /**
     * Creates an empty node.
     */
    public LinearNode()
    {
        next = null;
        element = null;
        previous = null; 
    }

    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public LinearNode(T elem)
    {
        // set next node reference to null 
        next = null;
        
        // set previous to null
        previous = null; 
        
        // store the given element 
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     * @return reference to next node
     */
    public LinearNode<T> getNext()
    {
        return next;
    }

    // modified
    /**
     * Returns the node that is previous of this 
     * @return reference to previous node
     */ 
    public LinearNode<T> getPrevious()
    {
        return previous;
    }
    
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node)
    {
        next = node;
    }
    
    // modified 
    /**
     * Sets the node that is previous of this 
     * @param node to previous ones 
     */
    public void setPrevious(LinearNode<T> node)
    {
        previous = node;
    }

    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }

    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }
}
