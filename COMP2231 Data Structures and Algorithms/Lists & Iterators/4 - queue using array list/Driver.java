//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 3 - Question 4 queue using Arraylist 
// Driver.java - The purpose of this program is to test the functionality Queue implemented by Arraylist.
// All of the methods has been used in the test-case program. 
////*********************************************************************************************************************************************************************************************************************

import java.util.*;
public class Driver
{
    public static void main(String[] args) {
        // Creates an empty queue.
        ArrayQueue<String> queue = new ArrayQueue<String>();
        
        System.out.println("======== Adds 3 element to the rear of this queue. ========"); 
        queue.enqueue("John"); 
        queue.enqueue("Nick"); 
        queue.enqueue("Aaron"); 
        System.out.println(queue.toString());
        
        System.out.println("======== Removes the element at the front of this queue. ========");
        queue.dequeue();
        System.out.println(queue.toString()); 
        
        System.out.println("======== Returns without removing the element at the front of this queue ========"); 
        System.out.println("the removed element :" + queue.first() + "\n"); 
        System.out.println(queue.toString());
        
        System.out.println("========= remove 2 element and check if queue is empty =======");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
        
        System.out.println("========= add 3 element and check if queue is empty =======");
        queue.enqueue("John"); 
        queue.enqueue("Nick"); 
        queue.enqueue("Aaron"); // top element 
        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
        
        System.out.println("========= check the current size of the queue =======");
        System.out.println(queue.toString());
        System.out.println(queue.size());
    }
}

