//*********************************************************************************************************************************************************************************************************************
// Deque.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 3) 
// Deque.java - This is a implementation of a drop-out-queue.
// It is similar to a queue, except its operatios works in both ends.
// Multiple methods has been modified and newly added. And, the double linked list structure are used since each node contains reference to front/back nodes. 
//**********************************************************************************************************************************************************************************************************************

// class represents a drop-out-queue
public class Deque<T> implements DequeADT<T>
{
    // variable to count current number of elemennt 
    private int count;
    // node to represent head and tail of the queue 
    private LinearNode<T> head, tail;

    // done modified
    /**
     * Creates an empty queue.
     */
    public Deque()
    {
        // set element count to 0 
        count = 0;
        // reference head and tail node to null 
        head = tail = null;
    }
    
    // done modified 
    /**
     * Adds the specified element to the tail of this queue.  
     * @param element the element to be added to the tail of the queue
     */
    public void enqueue(T element)
    {
        // create a new node and reference the element 
        LinearNode<T> node = new LinearNode<T>(element);

        // if queue is empty, set the new node as the head of the queue
        if (isEmpty())
            head = node;
        // point the new node's reference to the tail node
        // point the tail node's reference to the new node
        else{
            node.setPrevious(tail);
            tail.setNext(node);
        }

        // reset the tail as the new node 
        tail = node;
        // increment the element in a queue
        count++;
    }
    
    // done modified 
    /**
     * Adds the specified element to the front of this queue.  
     * @param element the element to be added to the front of the queue
     */
    public void addFront(T element)
    {
        //  create a new node and reference the element 
        LinearNode<T> newnode = new LinearNode<T>(element);
        
        // if queue is empty, set the new node as the head of the queue
        if (isEmpty()){
            head = newnode; 
        }
        // point the new node's reference to the head node
        // point the head node's reference to the new node
        else {
            // modified
            newnode.setNext(head);
            head.setPrevious(newnode);
        }
        
        // reset the head as the new node
        head = newnode; 
        // increment the element in a queue
        count++;
    }
    
    // done modified 
    /**
     * Removes the element at the head of this queue and returns a
     * reference to it. 
     * @return the element at the head of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        // if queue is empty, set the new node as the head of the queue
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        
        // store the element of the first element in the front of queue 
        T result = head.getElement();
        
        // set the head node to the 2nd first element in the queue
        head = head.getNext();
        
        // decrement the element in a queue
        count--;

        // if queue is empty, set the tail reference to null 
        if (isEmpty())
            tail = null;
        // otherwise, set head reference to null
        else 
            head.setPrevious(null);

        // return the removed element front the front
        return result;
    }
    
    // done modified
    /**
     * Removes the element at the tail of this queue and returns a
     * reference to it. 
     * @return the element at the tail of this queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T removeTail() throws EmptyCollectionException
    {
        // if queue is empty, throw an exception to notice the queue is empty
        if (isEmpty())
            throw new EmptyCollectionException("queue");
            
        // store the element of the last element in the front of queue 
        T result = tail.getElement();
        
        // set the tail node to the previous node in the queue
        tail = tail.getPrevious();
        
        // decrement the element in a queue
        count --; 
        
        // if queue is empty, set the tail reference to null 
        if (isEmpty())
            tail = null;
        // set tails next reference's to empty (so that tail element is removed from queue) 
        else 
            tail.setNext(null); 
        
        // return the removed element 
        return result;
    }
    
    
    /**
     * Returns a reference to the element at the head of this queue.
     * The element is not removed from the queue.  
     * @return a reference to the first element in this queue
     * @throws EmptyCollectionsException if the queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue"); 

        return head.getElement();
    }
    
    /**
     * Returns a reference to the element at the tail of this queue.
     * The element is not removed from the queue.  
     * @return a reference to the tail element in this queue
     * @throws EmptyCollectionsException if the queue is empty
     */ 
    public T last() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue"); 

        return tail.getElement();
    }
    
    /**
     * Returns true if this queue is empty and false otherwise. 
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
        return (count ==0); 
    }

    /**
     * Returns the number of elements currently in this queue.
     * @return the number of elements in the queue
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        String result = "";
        LinearNode<T> current = head;
        while (current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }
} 
// end line of code - checked 

