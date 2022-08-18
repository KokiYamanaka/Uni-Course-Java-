//*********************************************************************************************************************************************************************************************************************
// ToppingsOptionPane.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 5 Pizza Toppings 
// Summary : this program creates a pane for pizza toppings. The main function of this program is to update pizza cost once a checkbox (topping) is selected.
////*********************************************************************************************************************************************************************************************************************

// import necessary libraries
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import java.text.NumberFormat;


public class ToppingsOptionPane extends VBox{ // create class for toppings pane 
    private Text phrase; //create phrase object to display total toppings price 
    private double totalPrice; // variable to hold current total toppings price 
    private CheckBox ExtraCheese , Pepperoni , Sausage , GreenPepper , Onion , Anchovies ; // create checkbox object for each different toppings
    NumberFormat fmt1 = NumberFormat.getCurrencyInstance(); // create format object to support display currency symbol 


    public ToppingsOptionPane(){ // a constructor to hold overall GUI elements (each topping)

        totalPrice = 10; // set initial price to 10 
        phrase = new Text("Pizza Cost: " + fmt1.format(totalPrice)); // create text object to display current total price 
        phrase.setFont(new Font("Courier", 30)); // setting font stlye for total price 

        // create checkboxes and actionObject for each different topping
        ExtraCheese = new CheckBox("Extra Cheese");
        ExtraCheese.setOnAction(this::processCheckBoxAction);
        GreenPepper = new CheckBox("Green Pepper");
        GreenPepper.setOnAction(this::processCheckBoxAction);
        Pepperoni = new CheckBox("Pepperoni");
        Pepperoni.setOnAction(this::processCheckBoxAction);
        Onion = new CheckBox("Onion");
        Onion.setOnAction(this::processCheckBoxAction);
        Sausage = new CheckBox("Sausage");
        Sausage.setOnAction(this::processCheckBoxAction);
        Anchovies = new CheckBox("Anchovies");
        Anchovies.setOnAction(this::processCheckBoxAction);

        // group toppings horizontally with Hbox
        HBox toppings1 = new HBox(ExtraCheese,GreenPepper);
        toppings1.setAlignment(Pos.CENTER);
        toppings1.setSpacing(20);
        HBox toppings2 = new HBox(Pepperoni,Onion);
        toppings2.setAlignment(Pos.CENTER);
        toppings2.setSpacing(20);
        HBox toppings3 = new HBox(Sausage,Anchovies);
        toppings3.setAlignment(Pos.CENTER);
        toppings3.setSpacing(20);

        setSpacing(20); // set spacing between topping text and checkboxes
        getChildren().addAll(toppings1,toppings2,toppings3,phrase);
    }

    
    public void processCheckBoxAction(ActionEvent event){ // handle the events for checkboxes 

        int sum = 0; // variable to hold how many buttons (toppings) are selected 
        double toppings = 0; // calculate total amount of toppings

        // if each item is selected, then update the current amount of selected button
        if (ExtraCheese.isSelected())
            sum+=1;
        if (GreenPepper.isSelected())
            sum+=1;
        if (Pepperoni.isSelected())
            sum+=1;
        if (Onion.isSelected())
            sum+=1;
        if (Sausage.isSelected())
            sum+=1;
        if (Anchovies.isSelected())
            sum+=1;

        toppings = sum * 0.50; // calculate the current total price for toppings
        phrase.setText("Pizza Cost: " + fmt1.format(totalPrice + toppings)); // set text object with current price 
    }
}
 
    
