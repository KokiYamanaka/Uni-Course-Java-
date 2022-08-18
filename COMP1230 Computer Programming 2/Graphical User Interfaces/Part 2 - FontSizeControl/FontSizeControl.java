//*********************************************************************************************************************************************************************************************************************
// FontControl.java 
//
// Koki Yamanaka (T00681865)
// COMP 1231 Assignment 5 FontControl 
// Summary : this program appears a text in a window. The user move the sliding value, which triggers the text size to change.
////*********************************************************************************************************************************************************************************************************************

// import necessary libraries
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.*; 
import javafx.beans.binding.Bindings;
import javafx.scene.layout.BorderPane;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;


public class FontSizeControl  extends Application { // creates
    
    // creates 3 objects  
    private Text TextObject,FontSizeObject ; // create text objects to display the word, current font size
    private Slider SliderObject; // create slider to display the range of text font size 
    private StringProperty fontSizeValue; // create display notation for Current font size

    
    public void start(Stage primaryStage){ // display the window with topping buttons and price text  
        
    // create key objects to display 
    TextObject = new Text(90, 400,"hello world"); // to hold what text to display 
    FontSizeObject = new Text(10, 100,""); // object to hold current text size notation 
    SliderObject = new Slider(0,80,0); // object holds slider in the range between 0 to 80, where starting point is 0 
    fontSizeValue = new SimpleStringProperty("Current Font Size : "); // object to display current text size value 

    // grouping and scene setting 
    Group root = new Group();
    Scene scene = new Scene(root, 500, 500, Color.LIGHTYELLOW);
    
    // A display for font size changing
    FontSizeObject.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); // setting basic feature for current font size 
    FontSizeObject.textProperty().bind(fontSizeValue.concat(SliderObject.valueProperty().asString("%.2f") )); // display current font size as slider moves
    
    
    SliderObject.setShowTickLabels(true); // Show Tick Marks for slider
    SliderObject.setMajorTickUnit(10); // separate interval unit for slider
    SliderObject.setPrefWidth(400); // make slider's size longer


    TextObject.styleProperty().bind(Bindings.concat("-fx-font-size: ", SliderObject.valueProperty().asString()));  // change the text as slider value moves
   
    root.getChildren().addAll(TextObject, SliderObject, FontSizeObject); // group all object to display in scene
     
    // display scene in window
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    
    

    public static void main(String[] args){ // launch the scene stage
        launch(args);
    }
}