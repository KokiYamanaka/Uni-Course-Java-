
//*********************************************************************************************************************************************************************************************************************
// testShape3D.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 1 Inheritance 
// this program (a driver class) takes in a shape's information (e.g Side length, radius, or height), then it calculates & outputs the shape's Volume & Surface Area.
//**********************************************************************************************************************************************************************************************************************


 
public class testshape3D { // A driver class to test sample 3D shape object

	public static void main(String[] args) { // declaring main method

    
    	shape3D shapesample[]={new Cylinder(5.5,6.0),new Sphere(5.5),new Cube(5.5)};//Create an Array of Shape3D array which holds specific 3D shape objects

    
    	for(int i=0;i<shapesample.length;i++) {// //Display info of each object
    	System.out.println(shapesample[i]);
    	}
    
    	}	

}// end of code 