//*********************************************************************************************************************************************************************************************************************
// HeapSortTest.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 5 - Question 1 HeapSort
// LinkedStack.java - The program is the test case for heapsort.java   
////*****************************************************************************************************************************************************************************************

import java.util.Arrays;
public class HeapSortTest {
    public static void main(String[] args) {
        // test cases
        Integer[] array1 = { 45, 13, 27, 18, 2, 7, 0 }; // unsorted 
        Integer[] array2 = { 45, 42, 40, 35, 3,1, 0 }; // sorted - descending 
        String[] array3 = { "D","E","F","B","C","A"};// unsorted 
        String[] array4 = { "A","B","C","D","E","F" };// sorted  
        
        // create heapsort object 
        HeapSort sorter = new HeapSort();
        
        // unsorted 
        // print array before heap sort
        System.out.println("BEFORE: " + Arrays.toString(array1));
        // run heapsort
        sorter.efficientHeapSort(array1);
        // print heaped array 
        System.out.println("AFTER: " + Arrays.toString(array1)+"\n");

        // sorted 
        // print array before heap sort
        System.out.println("BEFORE: " + Arrays.toString(array2));
        // run heapsort
        sorter.efficientHeapSort(array2);
        // print heaped array 
        System.out.println("AFTER: " + Arrays.toString(array2)+"\n");


         // unsorted 
        // print array before heap sort
        System.out.println("BEFORE: " + Arrays.toString(array3));
        // run heapsort
        sorter.efficientHeapSort(array3);
        // print heaped array 
        System.out.println("AFTER: " + Arrays.toString(array3)+"\n");
         
        // sorted 
        // print array before heap sort
        System.out.println("BEFORE: " + Arrays.toString(array4));
        // run heapsort
        sorter.efficientHeapSort(array4);
        // print heaped array 
        System.out.println("AFTER: " + Arrays.toString(array4)+"\n");

     
    }
}