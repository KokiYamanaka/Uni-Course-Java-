
//*********************************************************************************************************************************************************************************************************************
// shape3D.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 1 Inheritance 
// shape3D.java - This program has the below functionality & features. 
//- acts an parent class to allow child class (specific 3D shape such cylinder) to use its method  
//- methods included setting 3D shape's name, displaying shape's name, and declaring abstract method to calculate specific shape's volume and surface area.  
//**********************************************************************************************************************************************************************************************************************


public abstract  class shape3D // declaring a parent class (3D shapes in general) to allow child class (specific 3D shapes) to use its method & variable
{
    private String shapename; //variable to store given shape's name 
    
    public shape3D (String shapename){ // a constructor to set shape's name to private variable 
        super(); 
        this.shapename = shapename; // setting shape's name 
    }
    
    public abstract double Volume();  // declaring abstract methods for later use or override this method due to different types of shape's calculations 
    public abstract double SurfaceArea(); 

    public String toString() {        // Override java package's toString method 
        return "Name=" + shapename; // output final result
    }
}

