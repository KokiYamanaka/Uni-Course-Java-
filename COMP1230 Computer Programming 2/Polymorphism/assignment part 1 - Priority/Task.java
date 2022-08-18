
//*********************************************************************************************************************************************************************************************************************
// Task.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 2 Porlymorphism 
// this program blueprint to represent a certain task, manipulate priority between tasks, display task's priority and description. 
//**********************************************************************************************************************************************************************************************************************
 
public class Task implements Priority, Comparable<Task>{
   private int priority; // variable to hold priority of a task
   private String description;// variable to hold concrete description of a task 
   
   // declare constructor to set priority and description of task 
   public Task(String description, int priority){
    this.description = description; // setting description as private ones
    this.priority = priority; // setting priority as private ones
    
    // condition to check priority 
    //  priority is not less than LOW if it is set priority to LOW
    if(this.priority < LOW)
           this.priority = LOW;
    // check priority is not greater than HIGH if it is set priority to HIGH
    else if(this.priority > HIGH)
           this.priority = HIGH;
    }
    
    // declare method that compares 2 Task and returns
    public int compareTo(Task other) {
       return(priority - other.priority);
   }

   // declare method to set new priority
   public void setPriority(int priority) {
       // check priority, if valid update priority
       if(priority >= LOW && priority <= HIGH)
           this.priority = priority;
      
   }
   
   // declare method to return priority
    public int getPriority() {
       return priority;
   }
   
   // declare method to display description of task 
   public String getDescription()
   {
       return description;
   }
   
   // declare method to return display description and priority of task 
   public String toString()
   {
       return "Task: [Description: "+description+" Priority: "+priority+"]";
   }
   
}// end line of code -  for Task class 