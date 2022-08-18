//*********************************************************************************************************************************************************************************************************************
// Clown.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 4 Parade
// This program simulates a specific clown by displaying its name.
////*********************************************************************************************************************************************************************************************************************
public class Clown { // declare class to represent blueprint of clown 

    private String clownName = "";// variable to hold specific clown's name

    public Clown (String clownName) { // declare constructor to initialize name of clown
        this.clownName = clownName; 
    }
    
    public String toString(){// return each specific clown in string
        return "Clown Name: " + clownName ; // return clown in string
    }
} // end line of code
