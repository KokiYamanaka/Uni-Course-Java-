//*********************************************************************************************************************************************************************************************************************
// Sphere.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 1 Inheritance 
// this program calculates and outputs sphere's volume & surface area by given radius and 3D shape's name.
//**********************************************************************************************************************************************************************************************************************


import java.text.DecimalFormat; // to show sphere's volume & surface area with fixed decimals 

public class Sphere extends shape3D{// extends shape3D parent class to use its method

    private double radius = 0.0; // declaring method to store radius sphere

    public Sphere(double radius){// a constructor to store cylinder's given data about radius & heights, and set cylinder's string name 
        super("Sphere");// setting Sphere's string name
        this.radius = radius;// // setting given radius 
    }
      
    public double Volume (){ // override parent's method to calculate Volume for Sphere.
        return (4*Math.PI*radius*radius*radius)/3; // output calculations
    }
 
    public double SurfaceArea(){ // override parent's method to calculate SurfaceArea for Sphere.
        return 4*(Math.PI*radius*radius) ;  // return calculations        
    }
    
    
    public String toString() { // display Sphere's string name, given data, and surface area and volume.
        DecimalFormat dcml = new DecimalFormat(".00"); // show 2 decimals 
        return super.toString()+" Radius=" + radius +   " Surface area ="+dcml.format(SurfaceArea())+" Volume="+dcml.format(Volume()); // display final output 
    }

}
