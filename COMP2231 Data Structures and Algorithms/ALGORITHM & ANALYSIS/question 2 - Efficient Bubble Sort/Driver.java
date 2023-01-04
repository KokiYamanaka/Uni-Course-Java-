//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 2) 
// Sorting.java - This program test the functionality of original and modified Bubble sort by providing 2 different test cases. 
// Test case includes an unsorted and sorted array with 10 random integers. 
//**********************************************************************************************************************************************************************************************************************

import java.util.*;

class Driver {
    public static void main(String[] args)
    {
        // create random object to generate random numbers 
        Random rand = new Random();    
        
        // for modified bubble sorting - generate 2 integer arrays, including 10 unsorted random numbers and sorted 10 numbers 
        Integer[] arrUnsorted = new Integer[10];
        Integer[] arrSorted = {3,119,120,400,451,477,900,1000,1232,2444};
        
        // assign random numbers to array (arr10)
        for (int i =0; i<arrUnsorted.length; i++){
                arrUnsorted[i] = rand.nextInt(400);
        }
        
        // for original bubble sorting - copy the exact array from the above 2 arrays  
        Integer[] copiedUnsorted = Arrays.copyOf(arrUnsorted, arrUnsorted.length);
        Integer[] copiedSorted = Arrays.copyOf(arrSorted, arrSorted.length);
         
        // --- test case 1 - array with unsorted random integer ---
        
        // test using original bubble sort
        System.out.println("TEST1 - original bubble sort with unsorted array");
        System.out.println("before sorting : " + Arrays.toString(arrUnsorted)); 
        Sorting.bubbleSort(arrUnsorted); 
        System.out.println("after sorting : "+ Arrays.toString(arrUnsorted)); 
        
        System.out.println("------------------------------------------------"); 
        
        // test using modified Bubble sort 
        System.out.println("TEST1 - modified bubble sort with unsorted array");
        System.out.println("before sorting : " + Arrays.toString(copiedUnsorted)); 
        Sorting.bubbleSort2(copiedUnsorted); 
        System.out.println("after sorting : "+ Arrays.toString(copiedUnsorted)); 
    
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        
        // --- test case 2 - array with sorted random integer ---
        
        // test using original bubble sort
        System.out.println("TEST2 - original bubble sort with sorted array");
        System.out.println("before sorting : " + Arrays.toString(arrSorted)); 
        Sorting.bubbleSort(arrSorted); 
        System.out.println("after sorting : "+ Arrays.toString(arrSorted)); 
        
        System.out.println("------------------------------------------------"); 
        
        // test using modified Bubble sort 
        System.out.println("TEST2 - modified bubble sort with sorted array");
        System.out.println("before sorting : " + Arrays.toString(copiedSorted)); 
        Sorting.bubbleSort2(copiedSorted); 
        System.out.println("after sorting : "+ Arrays.toString(copiedSorted));
    }
}  
