
//*********************************************************************************************************************************************************************************************************************
// Cylinder.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 1 Inheritance 
// this program calculates and outputs cylinder's volume & surface area by given radius & height, 3D shape's name.
//**********************************************************************************************************************************************************************************************************************


import java.text.DecimalFormat; // to show cylinder's volume & surface area with fixed decimals 

public class Cylinder extends shape3D{// extends parent class to use its method

  private double radius = 0.0; // declaring method to store radius & height of cylinder
  private double height = 0.0;

    public Cylinder(double radius, double height){// a constructor to store cylinder's given data about radius & heights, and set cylinder's string name 
        super("Cylinder");// setting cylinder's string name
        this.radius = radius;// setting given radius 
        this.height = height;// setting given height  
    }
      
    public double Volume (){ // override parent's method to calculate Volume for cylinder.
        return Math.PI*radius*radius*height; // return calculations 
    }
      
    public double SurfaceArea(){ // override parent's method to calculate SurfaceArea for cylinder.
        return 2*Math.PI*radius*(radius+height);  // return calculations        
    }
    
    public String toString() { // display cylinder's string name, given data, and surface area and volume.
        DecimalFormat dcml = new DecimalFormat(".00"); // using DecimalFormat to show 2 decimals for surface area and volume 
        return super.toString()+" Radius=" + radius + ", Height=" + height + " "+ "Surface area ="+dcml.format(SurfaceArea())+" Volume="+dcml.format(Volume()); // display final output 
    }

}
 


