import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author: Xiyun Liu
 * About: Main file of our program. Create a CUI for calculator
 * compile: javac -cp objectdraw.jar:. Calculator.java
 * run: java -cp objectdraw.jar:. Calculator
 */
public class Calculator extends Application{

	VBox rootpane = new VBox();
	Scene scene;
	String s;
	String temp = "";
	boolean start_write = false; // Record if the user only use basic calculator or open the white board to do handwriting 
	static boolean process_pre = false; // Record if we have recognize the previous handwritten digit
	final static int WIDTH = 448; //width of the window for white board
	final static int HEIGHT = 50; //height of the window for white board
	final static int LINUX_MENU_BAR = 50; // account for menu bar on linux systems
	public static TextField operand = new TextField(); //Operand textview on the scene
	public whiteboard hello; // initialize white board which the user can write digits on
	private Set<Character> operation = new HashSet<Character>(Arrays.asList('+','-','*','/')) ;
	private Set<Character> number = new HashSet<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    
	/**
     * Main function, launch this program
     */	
	public static void main (String[] args) {
		launch(args);
		return;
	}
	
    /**
     * Start function, create a scene and calls add_button function. Then let the stage show.
     */
	public void start(Stage applicationStage) throws Exception {
		
		scene =  new Scene(rootpane,240,308,Color.BLACK);
		applicationStage.setTitle("Handwritten Calculator");
		add_button();
	    applicationStage.setScene(scene);
		applicationStage.show();
	}
	
    /**
     * Add all the buttons and textviews onto the scene.
     * Add actions for all the buttons.
     */
	public void add_button() {
	
		Label operand_title = new Label("Operand:");	
		operand_title.setPrefSize(80,40);
		operand.setPrefSize(160,40);
		
		Label result_title = new Label("Result:");
		result_title.setPrefSize(80,40);
		TextField result = new TextField();
		result.setPrefSize(160,40);
		
		// start creating number buttons and operator buttons
		Button zeroButton = new Button("0");	
		zeroButton.setPrefSize(60, 40);
		zeroButton.setOnAction( e -> {
			String pre = operand.getText();
			if (pre.charAt(pre.length()-1)=='/') {
				Alert alert = new Alert(AlertType.ERROR,"Divide by zero");
				alert.showAndWait();
			}
			else {
				operand.setText(pre+"0");
			}			
		});
		Button oneButton = new Button("1");
		oneButton.setPrefSize(60, 40);
		oneButton.setOnAction( e -> {
			temp = temp+"1";
			String pre = operand.getText();
			operand.setText(pre+"1");			
		});
		Button twoButton = new Button("2");
		twoButton.setPrefSize(60, 40);
		twoButton.setOnAction(e->{
			temp = temp+"2";
			String pre = operand.getText();
			operand.setText(pre+"2");
		});
		Button threeButton = new Button("3");
		threeButton.setPrefSize(60, 40);
		threeButton.setOnAction(e->{
			temp = temp+"3";
			String pre = operand.getText();
			operand.setText(pre+"3");
		});
		Button fourButton = new Button("4");
		fourButton.setPrefSize(60, 40);
		fourButton.setOnAction(e->{
			temp = temp+"4";
			String pre = operand.getText();
			operand.setText(pre+"4");
		});
		Button fiveButton = new Button("5");
		fiveButton.setPrefSize(60, 40);
		fiveButton.setOnAction(e->{
			temp = temp+"5";
			String pre = operand.getText();
			operand.setText(pre+"5");
		});
		Button sixButton = new Button("6");
		sixButton.setPrefSize(60, 40);
		sixButton.setOnAction(e->{
			temp = temp+"6";
			String pre = operand.getText();
			operand.setText(pre+"6");
		});
		Button sevenButton = new Button("7");
		sevenButton.setPrefSize(60, 40);
		sevenButton.setOnAction(e->{
			temp = temp+"7";
			String pre = operand.getText();
			operand.setText(pre+"7");
		});
		Button eightButton = new Button("8");
		eightButton.setPrefSize(60, 40);
		eightButton.setOnAction(e->{
			temp = temp+"8";
			String pre = operand.getText();
			operand.setText(pre+"8");
		});
		Button nineButton = new Button("9");
		nineButton.setPrefSize(60, 40);
		nineButton.setOnAction(e->{
			temp = temp+"9";
			String pre = operand.getText();
			operand.setText(pre+"9");
		});
		Button pointButton = new Button(".");
		pointButton.setPrefSize(60, 40);
		pointButton.setOnAction(e->{
			if (start_write && process_pre== false) {
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (pre.equals("") || operation.contains(pre.charAt(pre.length()-1))) {
				temp = "0";
				pre = pre+"0";
				temp = temp+".";
				operand.setText(pre+".");
			}
			else if (pre.charAt(pre.length()-1) == '('||pre.charAt(pre.length()-1) == ')'){
				Alert alert = new Alert(AlertType.ERROR,"Wrong input");
				alert.showAndWait();	
			}
			else {
				temp = temp+".";
				operand.setText(pre+".");
			}
		});
		Button addButton = new Button("+");
		addButton.setPrefSize(60, 40);
		addButton.setOnAction(e->{
			// if the user chooses to write digits and the previous handwritten digits has not been processed
			if (start_write && process_pre == false) { 
				System.out.println("hello.create_img_array();");
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (pre.equals("")) {
				operand.setText(pre+"0+");	
			}
			else if (operation.contains(pre.charAt(pre.length()-1))) {
				Alert alert = new Alert(AlertType.ERROR,"Wrong input");
				alert.showAndWait();	
			}
			else {
				operand.setText(pre+"+");
			}
		});
		Button subtractButton = new Button("-");
		subtractButton.setPrefSize(60, 40);
		subtractButton.setOnAction(e->{
			if (start_write && process_pre == false) {
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (pre.equals("")) {
				operand.setText(pre+"0-");	
			}
			else if (operation.contains(pre.charAt(pre.length()-1))) {
				Alert alert = new Alert(AlertType.ERROR,"Wrong input");
				alert.showAndWait();	
			}
			else {
				operand.setText(pre+"-");
			}
		});
		Button multiplyButton = new Button("*");
		multiplyButton.setPrefSize(60, 40);
		multiplyButton.setOnAction(e->{
			if (start_write && process_pre == false) {
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (pre.equals("")) {
				operand.setText(pre+"0*");	
			}
			else if (operation.contains(pre.charAt(pre.length()-1))) {
				Alert alert = new Alert(AlertType.ERROR,"Wrong input");
				alert.showAndWait();	
			}
			else {
				operand.setText(pre+"*");
			}
		});
		Button divideButton = new Button("/");
		divideButton.setPrefSize(60, 40);
		divideButton.setOnAction(e->{
			if (start_write && process_pre == false) {
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (pre.equals("")) {
				operand.setText(pre+"0/");	
			}
			else if (operation.contains(pre.charAt(pre.length()-1))) {
				Alert alert = new Alert(AlertType.ERROR,"Wrong input");
				alert.showAndWait();	
			}
			else {
				operand.setText(pre+"/");
			}
		});
		Button operandButton = new Button("=");
		operandButton.setPrefSize(60, 40);
		operandButton.setOnAction(e -> {
			if (start_write && process_pre == false) {
				hello.create_img_array();
				process_pre = true;
			}
			s = operand.getText();
			if (operation.contains(s.charAt(s.length()-1))) {
				Alert alert  = new Alert(AlertType.ERROR,"Cannot end up with an operation");
				alert.showAndWait();
			}
			Get_result final_result = new Get_result(s);
			if (final_result.final_result.equals("Infinity")) {
				Alert alert  = new Alert(AlertType.ERROR,"Divide by zero!");
				alert.showAndWait();
			}
			result.setText(final_result.final_result);	
		});
		Button delButton = new Button("Del");
		delButton.setPrefSize(60, 40);
		delButton.setOnAction(e->{
			String pre = operand.getText();
			operand.setText(pre.substring(0, pre.length()-1));
		});
		Button clearButton = new Button("Clear");
		clearButton.setPrefSize(60, 40);
		clearButton.setOnAction(e->{
			operand.setText("");
			result.setText("");
		});
		Button leftkuohaoButton = new Button("(");
		leftkuohaoButton.setPrefSize(60, 40);
		leftkuohaoButton.setOnAction(e->{
			String pre = operand.getText();
			if (number.contains(pre.charAt(pre.length()-1))||pre.charAt(pre.length()-1) == '.') {
				Alert alert  = new Alert(AlertType.ERROR,"Input error");
				alert.showAndWait();
			}
			else {
				operand.setText(pre+"(");
			}
		});
		Button rightkuohaoButton = new Button(")");
		rightkuohaoButton.setPrefSize(60, 40);
		rightkuohaoButton.setOnAction(e->{
			if (start_write && process_pre == false) {
				hello.create_img_array();
				process_pre = true;
			}
			String pre = operand.getText();
			if (operation.contains(pre.charAt(pre.length()-1))) {
				Alert alert  = new Alert(AlertType.ERROR,"Input error");
				alert.showAndWait();
			}
			else {
				operand.setText(pre+")");
			}
		});
		
		
		// add all buttons on the pane
		Insets gridPadding = new Insets(10, 10, 10, 10);
		GridPane pane1 = new GridPane();
        pane1.setPadding(gridPadding);         // Set padding around  grid
        pane1.setHgap(10);                     // Spacing between columns
        pane1.setVgap(10); 	
        pane1.add(operand_title, 0, 0);
        pane1.add(operand, 1, 0);
        pane1.add(result_title, 0, 1);
        pane1.add(result, 1, 1);
        
        GridPane pane2 = new GridPane();
        pane2.add(sevenButton, 0, 0);
        pane2.add(eightButton, 1, 0);
        pane2.add(nineButton, 2, 0);
        pane2.add(addButton, 3, 0);
        pane2.add(fourButton, 0, 1);
        pane2.add(fiveButton, 1, 1);
        pane2.add(sixButton, 2, 1);
        pane2.add(subtractButton, 3, 1);
        pane2.add(oneButton, 0, 2);
        pane2.add(twoButton, 1, 2);
        pane2.add(threeButton, 2, 2);
        pane2.add(multiplyButton, 3, 2);
        pane2.add(zeroButton, 0, 3);
        pane2.add(pointButton, 1, 3);
        pane2.add(operandButton, 2, 3);
        pane2.add(divideButton, 3, 3);
        pane2.add(leftkuohaoButton, 0, 4);
        pane2.add(rightkuohaoButton, 1, 4);
        pane2.add(clearButton, 2, 4);
        pane2.add(delButton, 3, 4);
        
	

		GridPane pane3 = new GridPane();
        Button addimag = new Button("Open writeboard to write digits(only)");
        
        addimag.setPrefSize(240, 60);
        addimag.setOnAction(e->{
    		hello = new whiteboard();
    		hello.startController(WIDTH,HEIGHT+LINUX_MENU_BAR);
    		start_write = true;
        });
        
        pane3.add(addimag,0,0);
        
        pane1.setAlignment(Pos.TOP_LEFT);
        pane2.setAlignment(Pos.BOTTOM_LEFT);
        rootpane.getChildren().addAll(pane1,pane2,pane3);
		
	}

}
