//*********************************************************************************************************************************************************************************************************************
// Sorting.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 1) 
// Sorting.java - This program has the functionality to sort an unsorted array in an ascending order.
// Shell sort is used as our sorting algorithm.
// In brief, the algorithm breaks an unsorted array into smaller subsets 
// and each of those is sorted using Insertion sort. 
//**********************************************************************************************************************************************************************************************************************

import java.util.Arrays;

// a class that contains all necessary functionality for sorting 
public class Sorting 
{
    public static <T extends Comparable<T>> 
    
        // method to sort unsorted array using shell sort
        void shellsort(T[] data, int size){
            
            // variable to hold the incoming gap size
            int gap = size/2; 
            
            // variable to track whether a swap is made in a single pass 
            boolean swapflag;
            
            // iterate the array until the gap reach less than 0
            while(gap>0){ 
                // set to assume that a swap has made first
                swapflag = true; 
                
                // iterate through the array until there are no swap for a single pass 
                 while(swapflag == true) { 
                    
                    // set swap tracker to assume there is not swap happening for now
                    swapflag = false;
                     
                    // iterate n/2 size of the array (e.g: if 3,2,9,8,5,6 -> 3,2,9)
                    for (int s =0; s< (size-gap); s++){
                        
                        // compare the iterated element with its gap element (e.g: if array is 3,2,9,8,5,6, then compare 3 <-> 8) 
                        // if the iterated element is greather than its gap element, then we swap the values.
                        // if not, we let both elements to stay in their original position. 
                        if (data[s].compareTo(data[s+gap]) > 0) {
                            
                            //swap the iterating element with its gap element 
                            swap(data,s,s+gap);
                            
                            // set to assume a swap has been made
                            swapflag = true;
                            
                            // notify two compared values are not in the correct position 
                            System.out.println( data[s+gap] + " and "+ data[s] + " are not in order,so swap");
                            
                            // show the entire array after a single swap of 2 elements 
                            System.out.println("after swap:" + Arrays.toString(data));
                        }
                    }
                }
                
                // if n/2 elements of the array has completed their comparison, then we reduce the gap size for 2nd pass, 3rd, nth pass
                gap = gap/2;
            };
        }

    // method to switch 2 elements in an array 
    private static <T extends Comparable<T>> 
    void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    
}
// end line of code 