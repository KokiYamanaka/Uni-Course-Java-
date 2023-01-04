//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 3) 
// Sorting.java - This purpose of this program is to provide different size of arrays to conduct algorithm analysis. 
// sorted and unsorted array with the size of 10, 100, and 1000 are prepared. 
// 3 different algorithms (shell sort, original and modified bubble sort) are being analysed with these arrays. 
//**********************************************************************************************************************************************************************************************************************

import java.util.*;

class Driver {
    public static void main(String[] args)
    {
        // create random object to generate random numbers 
        Random rand = new Random();
        
        // create original generated array 
        // define size of array (with the size of 10,100,1000)
        int arraySize = 10;   
        int arraySize2 = 100;
        int arraySize3 = 1000;
        
        // create 3 integer arrays 
        Integer[] array10_Shell = new Integer[arraySize]; 
        Integer[] array100_Shell = new Integer[arraySize2];  
        Integer[] array1000_Shell = new Integer[arraySize3];  
        
        // assign random numbers between 0 to 999 to the array with size of 10, 100, 1000 
        for (int i =0; i<arraySize; i++){
            array10_Shell[i] = rand.nextInt(1000); 
        }
        
        for (int i =0; i<arraySize2; i++){
            array100_Shell[i] = rand.nextInt(1000); 
        }
        
        for (int i =0; i<arraySize3; i++){
            array1000_Shell[i] = rand.nextInt(1000); 
        }
        
        // make copies of arrays with the size of 10, 100, 100 arrays for original and modified bubble sort
        Integer[] array10_Bubble = Arrays.copyOf(array10_Shell, arraySize);
        Integer[] array10_Bubble2 = Arrays.copyOf(array10_Shell, arraySize); 
        
        Integer[] array100_Bubble = Arrays.copyOf(array100_Shell, arraySize2);
        Integer[] array100_Bubble2 = Arrays.copyOf(array100_Shell, arraySize2); 
        
        Integer[] array1000_Bubble = Arrays.copyOf(array1000_Shell, arraySize3);
        Integer[] array1000_Bubble2 = Arrays.copyOf(array1000_Shell, arraySize3); 

        // TEST CASE 1 : size 10 array
        System.out.println("TEST CASE 1 - SIZE 10 ARRAY");
        System.out.println("===========================");
        
        // first test on shell sort  
        System.out.print("SHELL SORT" + "\n" + "<unsorted>");
        Sorting.shellsort(array10_Shell,arraySize);  // unsorted
        System.out.print("<sorted>");
        Sorting.shellsort(array10_Shell,arraySize); 
        System.out.println("---------------------------------------------------------------");
        
        // first test on bubble sort 
        System.out.print("BUBBLE SORT" + "\n" + "<unsorted>");
        Sorting.bubbleSort(array10_Bubble);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort(array10_Bubble); 
        System.out.println("---------------------------------------------------------------");
        
        // first test on bubble sort 2
        System.out.print("BUBBLE SORT 2" + "\n" + "<unsorted>");
        Sorting.bubbleSort2(array10_Bubble2);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort2(array10_Bubble2); 
        System.out.println("---------------------------------------------------------------");
        
        // ====================================================================================
        
        // TEST CASE 2 : size 100 array
        System.out.println("TEST CASE 2 - SIZE 100 ARRAY");
        System.out.println("===========================");
        
        // 2nd test on shell sort  
        System.out.print("SHELL SORT" + "\n" + "<unsorted>");
        Sorting.shellsort(array100_Shell,arraySize2);  // unsorted 
        System.out.print("<sorted>");
        Sorting.shellsort(array100_Shell,arraySize2); 
        System.out.println("---------------------------------------------------------------");
        
        // 2nd test on bubble sort 
        System.out.print("BUBBLE SORT" + "\n" + "<unsorted>");
        Sorting.bubbleSort(array100_Bubble);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort(array100_Bubble); 
        System.out.println("---------------------------------------------------------------");
        
        //2nd test on bubble sort 2
        System.out.print("BUBBLE SORT 2" + "\n" + "<unsorted>");
        Sorting.bubbleSort2(array100_Bubble2);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort2(array100_Bubble2); 
        System.out.println("---------------------------------------------------------------");
         
        // ====================================================================================
        
        // TEST CASE 3: size 1000 array
        System.out.println("TEST CASE 3 - SIZE 1000 ARRAY");
        System.out.println("===========================");
        
        // 3rd test on shell sort  
        System.out.print("SHELL SORT" + "\n" + "<unsorted>");
        Sorting.shellsort(array1000_Shell,arraySize3);  // unsorted 
        System.out.print("<sorted>");
        Sorting.shellsort(array1000_Shell,arraySize3); 
        System.out.println("---------------------------------------------------------------");
        
        // 3rd test on bubble sort 
        System.out.print("BUBBLE SORT" + "\n" + "<unsorted>");
        Sorting.bubbleSort(array1000_Bubble);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort(array1000_Bubble); 
        System.out.println("---------------------------------------------------------------");
        
        // 3rd test on bubble sort 2
        System.out.print("BUBBLE SORT 2" + "\n" + "<unsorted>");
        Sorting.bubbleSort2(array1000_Bubble2);  // unsorted 
        System.out.print("<sorted>");
        Sorting.bubbleSort2(array1000_Bubble2); 
        System.out.println("---------------------------------------------------------------");
    }
} 
// end line of code - code checked 