/* *****************************************************************************
* Description: Creates the GUI for Conway's Game of Life. It creates a grid of
* squares.
*
* Purpose: Hobby Project.
*
* Date last modified: 01/08/16
*
* @author Daniel Griffin
******************************************************************************/
package dg.gameoflife;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GameOfLifeGUI extends Application {
	
	// Displays the stage and creates scene within it.
    @Override
    public void start(Stage primaryStage) {  	
    	GridPane squareGrid = new GridPane();
    	
    	for (int x=0; x<30; x++) {
    		for (int y=0; y<30; y++) {
		        Rectangle r = new Rectangle(15,15);
		        r.setFill(Color.WHITE);
		        r.setStroke(Color.GRAY);
		        squareGrid.add(r,x,y);
    		}
        }

        Scene scene = new Scene(squareGrid,600,700);

        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
