//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 1) 
// Sorting.java - This program test the functionality of Shell sort in Sorting.java.
// we give 3 test cases for shell sort, including given sample, 10 & 20 random integer numbers 
// If swapping occurs, then it the program will print the current scenario of the array. 
//**********************************************************************************************************************************************************************************************************************

import java.util.*;

class Driver {
    public static void main(String[] args)
    {
            // create 3 different integer array for test.
            // this may include the given sample, 10 random numbers, and 20 random numbers
            Integer[] arrSample = {9,6,8,12,3,1,7}; 
            Integer[] arr10 = new Integer[10];
            Integer[] arr20 = new Integer[20];
            
            // create random object to generate random numbers
            Random rand = new Random();
            
            // generate a 10 random numbers between 0 and 399 into Integer array
            for (int i =0; i<10; i++){
                arr10[i] = rand.nextInt(400);
            }
            
            // generate a 20 random numbers between 0 and 999 into Integer array
            for (int i =0; i<20; i++){
                arr20[i] = rand.nextInt(600);
            }
            
            // Test 1 - with given sample  
            int size = arrSample.length;
            System.out.println("Test case 1"); 
            System.out.println("original unsorted array : "+ Arrays.toString(arrSample)+"\n"); 
            Sorting.shellsort(arrSample,size);
            System.out.println();
            System.out.println("final sorted array :"+ Arrays.toString(arrSample)+"\n");
            
            // Test 2 - with 10 random numbers
            int size2 = arr10.length;
            System.out.println("Test case 2");
            System.out.println("original unsorted array : "+ Arrays.toString(arr10)+"\n"); 
            Sorting.shellsort(arr10,size2);
            System.out.println();
            System.out.println("final sorted array"+ Arrays.toString(arr10));

            // Test 3 - with 20 random numbers
            int size3 = arr20.length;
            System.out.println("Test case 3");
            System.out.println("original unsorted array : "+ Arrays.toString(arr20)+"\n"); 
            Sorting.shellsort(arr20,size3);
            System.out.println();
            System.out.println("final sorted array"+ Arrays.toString(arr20));

    }
}

