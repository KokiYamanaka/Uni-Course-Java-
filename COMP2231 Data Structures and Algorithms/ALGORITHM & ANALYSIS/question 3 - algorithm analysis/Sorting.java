//*********************************************************************************************************************************************************************************************************************
// Sorting.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 3) 
// Sorting.java - This purpose of this program is to conduct algorithm analysis on 3 different sorting algorithms.
// Shell sort, original and modified bubble sort are used. 
// Each algorithm will output the number of comparisons & swaps have been made, and its total time taken to sort the array. 
//**********************************************************************************************************************************************************************************************************************

import java.util.Arrays;

// a class that contains all of the 3 different sorting algorithms 
public class Sorting 
{
    // method to sort unsorted array using "shell sort"
    public static <T extends Comparable<T>> 
        void shellsort(T[] data, int size){
            
            // algorithm analysis 
            double  startTime = System.nanoTime(); // start timer - variable to store time taken to sort an array
            int num_comparisons = 0; // variable to store number of comparisons made 
            int num_swaps = 0; // variable to store number of swaps (2 values) made 
            
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
                        
                        // (algorithm analysis section) - increment number of comparisons 
                        num_comparisons++; 
                        
                        // compare the iterated element with its gap element (e.g: if array is 3,2,9,8,5,6, then compare 3 <-> 8) 
                        // if the iterated element is greather than its gap element, then we swap the values.
                        // if not, we let both elements to stay in their original position. 
                        if (data[s].compareTo(data[s+gap]) > 0) {
                            
                            // update the tracker to record number of swap made 
                            num_swaps++; 
                            
                            //swap the iterating element with its gap element 
                            swap(data,s,s+gap);
                            
                            // set to assume a swap has been made
                            swapflag = true;
                            
                            // notify two compared values are not in the correct position 
                            // System.out.println( data[s+gap] + " and "+ data[s] + " are not in order,so swap");
                            
                            // show the entire array after a single swap of 2 elements 
                            // System.out.println("after swap:" + Arrays.toString(data));
                        }
                    }
                }
                // if n/2 elements of the array has completed their comparison, then we reduce the gap size for 2nd pass, 3rd, nth pass
                gap = gap/2;
            };
            
            // (algorithm analysis section)
            
            // stop timer - variable to store time taken to sort an array
            double  endTime = System.nanoTime();
            // get the difference of started and ended time to sort an array 
            double  timeElapsed = endTime - startTime;  
            
            System.out.println(); 
            
            // print total number of comparisons and swaps, and time taken to sort an array
            System.out.println("Total comparisons made : " + num_comparisons);
            System.out.println("Total swaps made : " + num_swaps);
            System.out.println("Execution time in milliseconds: " + timeElapsed/ 1000000);
            
            System.out.println();
    }

    // method to sort unsorted array using "original Bubble sort"
    public static <T extends Comparable<T>> 
    void bubbleSort(T[] data){

        // (algorithm analysis section) - variable to store number of comparisons
        double  startTime = System.nanoTime(); // start timer - variable to store time taken to sort an array
        int num_comparisons = 0; // variable to store number of comparisons made 
        int num_swaps = 0; // variable to store number of swaps (2 values) made 
                
        // variable to track how many passes have been made 
        int position, scan, pass = 0;
                
        for (position =  data.length - 1; position >= 0; position--)
        {
                // increment the number of passes have made 
                pass++; 
                
                // show the actual array before comparison are made 
                //System.out.println("current pass is " + pass + " : " + Arrays.toString(data));                        
                        
            for (scan = 0; scan <= position - 1; scan++)
            { 
                // algorithm analysis - increment number of comparisons 
                num_comparisons++;
                    if (data[scan].compareTo(data[scan + 1]) > 0){
                            // algorithm analysis - update the tracker to record number of swap made 
                            num_swaps++;
                            // swap 2 elements from given data 
                            swap(data, scan, scan + 1);
                        }
            }
            }
                //(algorithm analysis section)    
                // stop timer - variable to store time taken to sort an array
                double  endTime = System.nanoTime(); 
                
                System.out.println(); 
            
                // print number of comparisons and swaps, and time taken to sort an array
                System.out.println("Total comparisons made : " + num_comparisons);
                System.out.println("Total swaps made : " + num_swaps);
                System.out.println("Execution time in milliseconds: " + (endTime - startTime) / 1000000);
                
                System.out.println();
            }
    
    // method to sort unsorted array using "modified Bubble sort"
    public static <T extends Comparable<T>> 
    void bubbleSort2(T[] data)
    {
        
        // a variable to track the dynmaic size of the array and a variable to track how many passes had made       
        int position = data.length -1, pass = 0 ; 
        
        // a variable to track whether a swap of 2 elements had been made for a single pass 
        boolean swapflag = true;
        
        // (algorithm analysis section) 
        double  startTime = System.nanoTime(); // start timer - variable to store time taken to sort an array
        int number_comparison = 0 ; // variable to store number of comparisons made 
        int num_swaps = 0; // variable to store number of swaps (2 values) made 
        
                // as long as a swap have been for each pass and comparison have not reached the end of the array, keep iterate
                // otherwise (no swap has been made and comparison have reached reach the array), terminate the loop 
                while (swapflag == true && position >= 0){
                    
                    // assume no any swap occured before 1 pass 
                    swapflag = false; 
                    
                    // increment the count of passes 
                    pass++; 
                    
                    // show the actual array before comparison 
                    // System.out.println("current pass is " + pass + " : " + Arrays.toString(data));

                    // iterate the array from the first element to second last element
                    // note that, the range of scanning through the array decrease as the largest element is in a valid position 
                    for ( int scan = 0; scan <= position -1; scan ++){
                        number_comparison++;
                    // if the compared neighbor element are not in a valid position, swap their position and notify a swap has occured for the tracker  
                        if (data[scan].compareTo(data[scan+1]) >0){
                            swap(data,scan,scan+1);
                            swapflag = true;
                            num_swaps++; 
                        }
                        
                    }
                    // decrease the range of comparison for the array by updating the position
                    position--; 
                }
                
                
                // (algorithm analysis section) 
                // stop timer - variable to store time taken to sort an array
                double  endTime = System.nanoTime();
                // get the difference of started and ended time to sort an array 
                double  timeElapsed = endTime - startTime;  
            
                // print number of comparisons and swaps, and time taken to sort an array
                System.out.println("total number comparison made : " + number_comparison);
                System.out.println("TOTAL number swaps made : " + num_swaps);
                System.out.println("Execution time in milliseconds: " + timeElapsed/ 1000000);
                System.out.println();
                
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
// end line of code - code checked  
