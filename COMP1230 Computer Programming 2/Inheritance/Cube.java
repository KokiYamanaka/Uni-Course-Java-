
//*********************************************************************************************************************************************************************************************************************
// Cube.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 1 Inheritance 
// this program calculates and outputs Cube's volume & surface area by given sidelength and 3D shape's name.
//**********************************************************************************************************************************************************************************************************************


import java.text.DecimalFormat; // to show Cube's volume & surface area with fixed decimals 

public class Cube extends shape3D{// extends shape3D parent class to use its method

    private double sidelength = 0.0; // declaring method to store Cube's side length

    public Cube(double sidelength){// a constructor to store Cube's given data about sidelength, and set Cube's string name 
        super("Cube");// setting Cube's string name
        this.sidelength = sidelength;// // setting given sidelength 
    }
      
    public double Volume (){ // override parent's method to calculate Volume for Cube.
        return sidelength*sidelength*sidelength; // output calculations
    }
 
    public double SurfaceArea(){ // override parent's method to calculate SurfaceArea for Cube.
        return 6*sidelength*sidelength ;  // return calculations        
    }
    
    
    public String toString() { // display Cube's string name, given data, and surface area and volume.
        DecimalFormat dcml = new DecimalFormat(".00"); // show 2 decimals 
        return super.toString()+" Radius=" + sidelength +   " Surface area ="+dcml.format(SurfaceArea())+" Volume="+dcml.format(Volume()); // display final output 
    }

}

