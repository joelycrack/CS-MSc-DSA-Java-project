import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Shapes extends Application {
	 @Override     
	 public void start(Stage stage) throws Exception     
	 { 
 // creating all shapes to be displayed
		 Rectangle rectangle = new Rectangle(100, 100, 200, 100);
		 Polygon hexagon = new Polygon();
		 hexagon.getPoints().addAll(new Double[] {250.0, 300.0, 350.0, 350.0, 350.0, 450.0, 250.0, 500.0, 150.0, 450.0, 150.0, 350.0});
		 Polygon triangle = new Polygon();
		 triangle.getPoints().addAll(new Double[] {250.0, 300.0, 350.0, 450.0, 150.0, 450.0});
		 
		 Line line1 = new Line(50, 50, 200, 200); // setting up a cross shape for errors
         line1.setStroke(Color.BLACK);
         line1.setStrokeWidth(15);
         Line line2 = new Line(50, 200, 200, 50);
         line2.setStroke(Color.BLACK);
         line2.setStrokeWidth(15);
         Group cross = new Group(line1, line2);

 // creating the UI elements 
		 TextField color = new TextField();	// creating text fields to collect user input
		 color.setMaxWidth(250); 
		 TextField shape = new TextField();         
		 shape.setMaxWidth(250); 
		 
		 Label colorLabel = new Label("Enter color");	// set labels for the colour text fields
		 colorLabel.setTextFill(Color.BLACK);         
		 colorLabel.setFont(Font.font("Arial", 20));
		 Label ColourDescription = new Label("Enter red, grey, or green");

		 Label shapeLabel = new Label("Enter shape");	// set labels for the shape text fields
		 shapeLabel.setTextFill(Color.BLACK);         
		 shapeLabel.setFont(Font.font("Arial", 20));
		 Label shapeDescription = new Label("Enter triangle, rectangle, or hexagon");
		 Label resultsPrompt = new Label("Enter a shape through the input on the left first, then a color, and see results here");
		 resultsPrompt.setWrapText(true);
		 resultsPrompt.setTextFill(Color.SLATEGRAY);
		 
		 TextArea displayColor = new TextArea();     // create text area to display results and set styling options
		 displayColor.setEditable(false);         
		 displayColor.setMinSize(250,60);         
		 displayColor.setMaxSize(250,60);
		 displayColor.setWrapText(true);					
		 TextArea displayShape = new TextArea();   
		 displayShape.setEditable(false);         
		 displayShape.setMinSize(250,60);         
		 displayShape.setMaxSize(250,60);
		 displayShape.setWrapText(true);
		 
		 Button submitColor = new Button("Submit Color");	// create buttons for submitting colour and shape choice
		 Button submitShape = new Button("Submit Shape"); 
		 
 // create containers to organise the UI into two segments - user input on the left, results on the right
		 VBox resultsVBox = new VBox(10); 
		 resultsVBox.setBackground(Background.EMPTY);         
		 resultsVBox.setAlignment(Pos.CENTER);
		 resultsVBox.getChildren().addAll(resultsPrompt);
		 VBox inputVBox = new VBox(18); 
		 inputVBox.setBackground(Background.EMPTY);         
		 inputVBox.setAlignment(Pos.CENTER);
		 inputVBox.getChildren().addAll(shapeLabel, shapeDescription, shape, submitShape, displayShape, 
				 colorLabel, ColourDescription, color, submitColor, displayColor); 
		 
		 HBox hbox = new HBox(100, inputVBox, resultsVBox); // create an HBox to organise the layout of the UI and results. Create padding and layout
		 hbox.setPadding(new Insets(15, 12, 15, 12));
		 	 
// perform actions after pressing buttons, changing program state based on user input 
		 submitColor.setOnAction(e ->  {							// set action for the color submit button
			 String userColor;
			 userColor = color.getText().toLowerCase();				// switch case statement to match user input to available results. Ignore case for UX 
			 switch(userColor) {			
			 case "red": 
				 displayColor.setText("You entered: " + color.getText());  // display validation in text field
				 rectangle.setFill(javafx.scene.paint.Color.RED);
				 hexagon.setFill(javafx.scene.paint.Color.RED);
				 triangle.setFill(javafx.scene.paint.Color.RED);
				 break;
			 case "green": 
				 displayColor.setText("You entered: " + color.getText());
				 rectangle.setFill(javafx.scene.paint.Color.GREEN);
				 hexagon.setFill(javafx.scene.paint.Color.GREEN);
				 triangle.setFill(javafx.scene.paint.Color.GREEN);
				 break;
			 case "grey": 
				 displayColor.setText("You entered: " + color.getText());
				 rectangle.setFill(javafx.scene.paint.Color.GREY);
				 hexagon.setFill(javafx.scene.paint.Color.GREY);
				 triangle.setFill(javafx.scene.paint.Color.GREY);
				 break;
			 default: 
				 displayColor.setText("You didn't enter a valid color. Please try again and input red, green, or grey."); // display error and resolution to the user
				 rectangle.setFill(javafx.scene.paint.Color.BLACK);
				 hexagon.setFill(javafx.scene.paint.Color.BLACK);
				 triangle.setFill(javafx.scene.paint.Color.BLACK);
				 break;
			 }
		 }
			 ) ; 
		 
		 submitShape.setOnAction(e ->  {					// set action on pressing the shape button. Switch case statement to match input to available shapes 
			 String userShape;
			 userShape = shape.getText().toLowerCase();
			 switch(userShape) {
			 case "triangle": 
				 displayShape.setText("You entered: " + shape.getText());
				 resultsVBox.getChildren().clear();
				 resultsVBox.getChildren().addAll(triangle); 
				 break;
			 case "hexagon": 
				 displayShape.setText("You entered: " + shape.getText());
				 resultsVBox.getChildren().clear();
				 resultsVBox.getChildren().addAll(hexagon);
				 break;
			 case "rectangle": 
				 displayShape.setText("You entered: " + shape.getText());
				 resultsVBox.getChildren().clear();
				 resultsVBox.getChildren().addAll(rectangle);
				 break;
			 default: 
				 displayShape.setText("You didn't enter a valid shape. Try again with hexagon, rectangle, or triangle."); // error validation
				 resultsVBox.getChildren().clear();
		 		 resultsVBox.getChildren().addAll(cross);
				 break;
			 }
		 }
			 ) ;
 // set up the stage and scene to display the program
		 Scene scene = new Scene(hbox, 600, 520);
		 stage.setScene(scene);         
		 stage.setTitle("Shapes");        
		 stage.show();	 
	 }
 
 // method to run the program
	 public static void main(String[] args)     
	 {         
		 launch(args);     
	 }
	 
}
