//*********************************************************************************************************************************************************************************************************************
// TaskDriver.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism 
// 
// this program purpose is to test the functionality of Task Priority program.
// multiple certain task objects will be display as it runs through the program.
// TaskDriver.java : Java driver program to test the Task class
//**********************************************************************************************************************************************************************************************************************

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class TaskDriver {

   public static void main(String[] args) {
      
       ArrayList<Task> tasks = new ArrayList<Task>(); // declare an array list to store task objects 
      
        
       // SAMPLE INPUT 1 adding task objects to task list 
       tasks.add(new Task("Task1", Priority.LOW));
       tasks.add(new Task("Task2", Priority.HIGH));
       tasks.add(new Task("Task3", Priority.MEDIUM));
       tasks.add(new Task("Task4", Priority.LOW));
       tasks.add(new Task("Task5", Priority.HIGH));
       tasks.add(new Task("Task6", Priority.HIGH));
  
        // SAMPLE INPUT 2 adding task objects to task list 
       tasks.add(new Task("Task1", Priority.LOW));
       tasks.add(new Task("Task2", Priority.LOW));
       tasks.add(new Task("Task3", Priority.MEDIUM));
       tasks.add(new Task("Task4", Priority.HIGH));
       tasks.add(new Task("Task5", Priority.HIGH));
       tasks.add(new Task("Task6", Priority.LOW));
       

       // SAMPLE INPUT 3 adding task objects to task list 
       tasks.add(new Task("Task1", Priority.LOW));
       tasks.add(new Task("Task2", Priority.LOW));
       tasks.add(new Task("Task3", Priority.MEDIUM));
       tasks.add(new Task("Task4", Priority.HIGH));
       tasks.add(new Task("Task5", Priority.MEDIUM));
       tasks.add(new Task("Task6", Priority.HIGH));

       // SAMPLE INPUT 4 adding task objects to task list
       tasks.add(new Task("Task1", Priority.HIGH));
       tasks.add(new Task("Task2", Priority.MEDIUM));
       tasks.add(new Task("Task3", Priority.HIGH));
       tasks.add(new Task("Task4", Priority.MEDIUM));
       tasks.add(new Task("Task5", Priority.HIGH));
       tasks.add(new Task("Task6", Priority.LOW));

       
       
        // sort task in ascending order by prioriy rank
       Collections.sort(tasks, Collections.reverseOrder());
       
       // create an iterator to tasks list
       Iterator<Task> itr = tasks.iterator();
       
       // display the sorted tasks ranked by priority
       while(itr.hasNext())
       {
           System.out.println(itr.next());
        }
    }
} // end line of code - for TaskDriver class 
 