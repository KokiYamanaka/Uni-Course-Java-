
//*********************************************************************************************************************************************************************************************************************
// PizzaToppings.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 5 Pizza Toppings 
// Summary : this program main function is to utilize ToppingsOptionPane and display its GUI elements (toppings)  
////*********************************************************************************************************************************************************************************************************************

// import necessary libraries
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class PizzaToppings extends Application { 
    public void start(Stage primaryStage){ // display the window with topping buttons and price text  

        ToppingsOptionPane pane = new ToppingsOptionPane(); // create object that contains toppings and price
        pane.setAlignment(Pos.CENTER); // set position of pane to center of window 
        pane.setStyle("-fx-background-color: lightgoldenrodyellow"); // set window's background color to light yellow

        Scene scene = new Scene(pane,400,250); // set the size of window  

        primaryStage.setTitle("Pizza Cost"); // set window title 
        primaryStage.setScene(scene); // display the final scene
        primaryStage.show();
    }
    
    public static void main(String[] args){ // main function to launch the pizza cost stage 
        launch(args);
    }
}