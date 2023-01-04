//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 2 Stacks and Queues  (Question 2) 
// Driver.java - This program test the functionality of drop-out-queue in Deque.java. 
// 3 test cases are prepared. This includes add/remove elements from both sides.
// After each add/remove operation, the size, actual, first & last element of the queue will be printed.
//**********************************************************************************************************************************************************************************************************************

import java.util.*; 

// class to represent the test cases
public class Driver {
    public static void main(String[] args)
    {
        Deque<Integer> myqueue = new Deque<Integer>(); 
        
        // TEST CASE - ADD ELEMENTS
        System.out.println("===TEST CASE 1 - ADD ELEMENTS===");
        // add 5 elements to queue
        myqueue.enqueue(new Integer(1));
        myqueue.enqueue(new Integer(3));
        myqueue.enqueue(new Integer(5));
        myqueue.enqueue(new Integer(7));
        myqueue.enqueue(new Integer(9));
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // add 2 elements to the front 
        myqueue.addFront(new Integer(100));
        myqueue.addFront(new Integer(102));
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // add 2 elements to the back 
        myqueue.enqueue(new Integer(200));
        myqueue.enqueue(new Integer(202));
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // TEST CASE - REMOVE ELEMENTS 
        System.out.println("===TEST CASE 2 - REMOVE ELEMENTS===");
        // remove 2 elements from the front 
        myqueue.dequeue();
        myqueue.dequeue();
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // remove 2 elements from the back  
        myqueue.removeTail();
        myqueue.removeTail();
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // TEST CASE - REMOVE ELEMENTS 
        System.out.println("===TEST CASE 3 - CONTINUE REMOVE ELEMENTS===");
        // remove 2 elements from the front 
        myqueue.dequeue();
        myqueue.dequeue();
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // remove 2 elements from the back  
        myqueue.removeTail();
        myqueue.removeTail();
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
        // make stack empty 
        System.out.println("===TEST CASE 4 - MAKING STACK EMPTY===");
        // remove 1 element from the front 
        myqueue.dequeue();
        // print the whole queue
        System.out.println("current queue looks like :" +"\n" + myqueue.toString());
        // print the size of the queue 
        System.out.println("the size :" + + myqueue.size());
        System.out.println("front element :" + + myqueue.first() +", last element :"+ myqueue.last() );
        System.out.println("====================================================");
        
    }
}
// END LINE OF CODE - checked 
