/* *****************************************************************************
* Description: A class used to create the visuals for Conway's Game of Life.
*
* Purpose: Hobby Project.
*
* Date last modified: 05/08/16
*
* Author: Daniel Griffin
******************************************************************************/

package dg.gameoflife;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyValue;


public class GameOfLifeGUI extends Application {

	private Grid squareGrid;
	private GridPane squareGridPane, buttonPane;
	private VBox rootPane;
	private Stage mainStage;
	private Scene mainScene;
	private Button startButton;

	// Displays the stage and creates the initial scene within it.
    @Override
    public void start(Stage primaryStage) {
    	mainStage = primaryStage;
    	squareGridPane = new GridPane();
    	squareGrid = new Grid();

    	for (int x=0; x<40; x++) {
    		for (int y=0; y<40; y++) {
		        Rectangle r = new Rectangle(15,15, Color.WHITE);
		        r.setStroke(Color.GRAY);
		        squareGridPane.add(r,x,y);
		        squareGrid.add(r, x, y);
    		}
        }

    	squareGrid.turnCellBlack(20,20);
    	squareGrid.turnCellBlack(20,19);
    	squareGrid.turnCellBlack(21,19);
    	squareGrid.turnCellBlack(21,18);
    	squareGrid.turnCellBlack(19,18);

    	startButton = new Button("Start");

    	// When clicked it calls a function that continously updates the grid
        // after applying the rules.
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameOfLifeAlgorithm.createUpdatedGrid(squareGrid);
            }
        });

        buttonPane = new GridPane();
        buttonPane.add(startButton,15,35);

        rootPane = new VBox(5);
        rootPane.getChildren().addAll(squareGridPane, buttonPane);

        mainScene = new Scene(rootPane,700,700);

        mainStage.setTitle("Conway's Game of Life");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public static void main(String[] args) {
    	launch(args);
    }
}
