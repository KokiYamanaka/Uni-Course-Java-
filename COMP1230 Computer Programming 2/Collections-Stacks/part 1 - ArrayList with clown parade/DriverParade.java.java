//*********************************************************************************************************************************************************************************************************************
// DriverParade.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 4 Parade
// this program test the functionality of clown parades.
// we test adding, removing, and displaying clowns. And, we also check whether which specifc clown is at the head of parade.
////*********************************************************************************************************************************************************************************************************************
public class DriverParade { // declare class test functinality of clown parades
    public static void main (String args[]){
        Parade myParade = new Parade(); // instantiate parade object
        
        // create 4 clowns objects 
        Clown wayne = new Clown("wayne"); // instantiate parade object
        Clown Koki = new Clown("Koki"); // instantiate parade object
        Clown santaClown = new Clown("santa clown"); // instantiate parade object
        Clown Obama = new Clown("Obama"); // instantiate parade object
        Clown Jake = new Clown("Jake"); // instantiate parade object

        // add 4 clowns, then print the entire parade
        myParade.AddClown(wayne); 
        myParade.AddClown(Koki); 
        myParade.AddClown(santaClown);
        myParade.AddClown(Obama);
        System.out.println(myParade.toString());
        
        // check whether which clown is at the head of the parade  
        System.out.println(myParade.isFront(wayne)); 
        System.out.println(myParade.isFront(Koki));
        System.out.println(myParade.isFront(Jake));
        System.out.println("\n");

        
        // remove 2 clowns and display
        myParade.RemoveClown();  
        myParade.RemoveClown();   
        System.out.println(myParade.toString());

        // add 1 clown and display
        myParade.AddClown(Jake);  
        System.out.println(myParade.toString());

        
    }
} // end line of code
