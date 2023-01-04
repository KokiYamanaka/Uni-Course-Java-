//*********************************************************************************************************************************************************************************************************************
// ArrayQueue.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 3 - Question 4 queue using ArrayList 
// ArrayQueue.java - The program represents a queue implemented by ArrayList.
// Multiple methods has been implemented to manipulate elements and the ArrayQueue.   
////*****************************************************************************************************************************************************************************************


import java.util.ArrayList;
public class ArrayQueue<T> implements QueueADT<T>
{
    private ArrayList<T> queue;
    
    // Creates an empty queue.
    public ArrayQueue() {
        queue = new ArrayList<T>();
    }

    // Adds the specified element to the tail of this queue.
    public void enqueue(T element)
    {
        queue.add(element); 
    }

    // Removes the element at the head of this queue and returns a reference to it.
    public T dequeue() {
        // stores element in temporary variable to return
        T element = queue.remove(0);

        return element;
    }


    // Returns a reference to the element at the head of this queue.
    public T first() throws EmptyCollectionException
    {
        if (isEmpty()){
            return null; 
        }
        else {
            return queue.get(0);  
        }
        
    }

    /**
     * Returns true if this queue is empty and false otherwise. 
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
        return queue.isEmpty();  // temp
    }

    /**
     * Returns the number of elements currently in this queue.
     * @return the number of elements in the queue
     */
    public int size()
    {   
        return queue.size();  // temp
    }

    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        String result = ""; 
        for ( T element: queue) {
            result = result + element + "\n"; 
        }
        return result;  // temp
    }
}
