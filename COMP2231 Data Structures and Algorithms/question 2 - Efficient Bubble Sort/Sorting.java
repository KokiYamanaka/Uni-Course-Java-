//*********************************************************************************************************************************************************************************************************************
// Sorting.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 1 Analysis of Algorithms & Searching and Sorting (Question 2) 
// Sorting.java - This program has the functionality to sort an unsorted array in an ascending order.
// Original and modified Bubble sort are implemented and used to sort an unsorted array. 
// Note : Bubble Sort sort an unsorted array by comparing 2 neighbor elements until the largest value has reach its valid position. 
//**********************************************************************************************************************************************************************************************************************

import java.util.Arrays;

// a class that contains original and modified bubble sort
public class Sorting 
{
    public static <T extends Comparable<T>> 
        // method that implements modified bubble sort
	void bubbleSort2(T[] data)
	{
        	// a variable to track the dynmaic size of the array and a variable to track how many passes had made       
		int position = data.length -1, pass = 0 ; 
		// a variable to track whether a swap of 2 elements had been made for a single pass 
                boolean swapflag = true;
                
                // as long as a swap have been for each pass and comparison have not reached the end of the array, keep iterate
                // otherwise (no swap has been made and comparison have reached reach the array), terminate the loop 
                while (swapflag == true && position >= 0){
                    
                    // assume no any swap occured before 1 pass 
                    swapflag = false; 
                    
                    // increment the count of passes 
                    pass++; 
                    
                    // show the actual array before comparison 
                    System.out.println("current pass is " + pass + " : " + Arrays.toString(data));

                    // iterate the array from the first element to second last element
                    // note that, the range of scanning through the array decrease as the largest element is in a valid position 
                    for ( int scan = 0; scan <= position -1; scan ++){
                        
                    // if the compared neighbor element are not in a valid position, swap their position and notify a swap has occured for the tracker  
                        if (data[scan].compareTo(data[scan+1]) >0){
                            swap(data,scan,scan+1);
                            swapflag = true;
                        }
                        
                    }
                    // decrease the range of comparison for the array by updating the position
                    position--; 
                }
	}
    
    // original bubble sort 
    public static <T extends Comparable<T>> 
	void bubbleSort(T[] data)
	{
            	// variable to track how many passes have been made 
		int position, scan, pass = 0;
                
		for (position =  data.length - 1; position >= 0; position--)
		{
        		// increment the number of passes have made 
        		pass++; 
        		
        		// show the actual array before comparison are made 
                        System.out.println("current pass is " + pass + " : " + Arrays.toString(data));
                        
			for (scan = 0; scan <= position - 1; scan++)
			{
				if (data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);
			}
		}
	}

    // method to swap two elements in an array 
    private static <T extends Comparable<T>> 
    void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    
}
