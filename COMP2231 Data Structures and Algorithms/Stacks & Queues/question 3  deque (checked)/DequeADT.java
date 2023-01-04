//*********************************************************************************************************************************************************************************************************************
// DequeADT.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 3) 
// DequeADT.java - DequeADT defines the interface to a drop out queue collection.
// It is similar to a queue, except its operatios works in both ends.
// multiple methods have been added and modified.  
//**********************************************************************************************************************************************************************************************************************

public interface DequeADT<T>
{
    /**  
     * Adds one element to the rear of this queue. 
     * @param element  the element to be added to the rear of the queue  
     */
    public void enqueue(T element);

    // modified
    /**  
     * Adds one element to the "front" of this queue. 
     * @param element  the element to be added to the front of the queue  
     */
    public void addFront(T element);
    
    /**  
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeue();
    
    // modified 
    /**  
     * Removes and returns the element at the tail of this queue.
     * @return the element at the tail of the queue
     */
    public T removeTail();
    
    /**  
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public T first();

    // modified 
    /**  
     * Returns without removing the element at the back of this queue.
     * @return the back element in the queue
     */
    public T last();
    
    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size();

    /**  
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString();
}
