
//*********************************************************************************************************************************************************************************************************************
// HeapSort.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 5 - Question 1 HeapSort
// HeapSort.java - The program provides efficient method to heap sort based on array.
////*****************************************************************************************************************************************************************************************

public class HeapSort<T> {
    
    //Sorts the specified array using a Heap Sort. 
    public void heapSort(T[] data) {
        ArrayHeap<T> heap = new ArrayHeap<T>();

        // copy the array into a heap
        for (int i = 0; i < data.length; i++)
            heap.addElement(data[i]);

        // place the sorted elements back into the array
        int count = 0;
        while (!(heap.isEmpty())) {
            data[count] = heap.removeMin();
            count++;
        }
    }

    // sort an array based max heap with a better sorting algorithm.
    // First, we build a heap in place using array. Next, place each element in array starting from the root element.
    // Then, we iterate and throw each element to the back of the array from front to end of array.
    public void efficientHeapSort(T[] data) {
        // number of nodes in a heap
        int size = data.length;

        // first node 
        int start = (size - 1) / 2;

        // build a max heap in place 
        for (int i = start; i >= 0; i--)
            heapify(data, size, i);

        // remove element from tree one by one from root to leaf (array-based) until array is sorted appropriate.
        for (int i = size - 1; i >= 0; i--) {
            // place current selected element to the end of the array 
            T temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            // heapify remaining elements
            heapify(data, i, 0);
        }
    }

    // build a maxheap from an array's element.
    private void heapify(T[] data, int size, int i) {
        // get parent's node, note that this is the largest element 
        int max = i;

        // get left child index
        int left = 2 * i + 1;

        // get right child index
        int right = 2 * i + 2;

        // ordering management 
        
        // swap max index if left child element is greater than parent
        if (left < size && ((Comparable) data[left]).compareTo(data[max]) > 0)
            max = left;

        // swap max index if right child less than max 
        if (right < size && ((Comparable) data[right]).compareTo(data[max]) > 0)
            max = right;

        // if parent index is not max, swap parent element and max element
        if (max != i) {
            T temp = data[i];
            data[i] = data[max];
            data[max] = temp;

            // heapify the subtree 
            heapify(data, size, max);
        }
    }
} // end line of code 