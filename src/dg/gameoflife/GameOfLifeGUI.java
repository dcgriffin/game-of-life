/* *****************************************************************************
* Description: A class used to create the visuals for Conway's Game of Life.
*
* Purpose: Hobby Project.
*
* Date last modified: 29/08/16
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;


public class GameOfLifeGUI extends Application {

	private Grid squareGrid;
	private GridPane squareGridPane, buttonPane;
	private VBox rootPane;
	private Stage mainStage;
	private Scene mainScene;
    private Timeline timeline;

	// Displays the stage and creates the initial scene within it.
    @Override
    public void start(Stage primaryStage) {
    	mainStage = primaryStage;
    	squareGridPane = new GridPane();
    	squareGrid = new Grid();

        // Creates a 40 by 40 grid of Cells and adds them to the Pane.
    	for (int x=0; x<40; x++) {
    		for (int y=0; y<40; y++) {
		        Cell c = new Cell(15,15);
                c.setStroke(Color.GRAY);
                squareGridPane.add(c,x,y);
                squareGrid.add(c,x,y);

                c.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        c.cellClicked();
                    }
                });
    		}
        }

        squareGrid.turnCellBlack(17,18);
        squareGrid.turnCellBlack(17,19);
        squareGrid.turnCellBlack(17,20);
        squareGrid.turnCellBlack(18,20);
        squareGrid.turnCellBlack(19,20);
        squareGrid.turnCellBlack(19,19);
        squareGrid.turnCellBlack(19,18);
        squareGrid.turnCellBlack(18,17);

    	Button startButton = new Button("Start");

    	// When the startButton is clicked it continously
        // executes a function which applies the rules of the game and updates
        // the grid.
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline = new Timeline(new KeyFrame( Duration.seconds(0.5),
                    timelineEvent -> {
                        GameOfLifeAlgorithm.createUpdatedGrid(squareGrid);
                }));

                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
        });

        Button stopButton = new Button("Stop");

        // Stops the simulation.
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeline.stop();
            }
        });

        buttonPane = new GridPane();
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.add(startButton,1,1);
        buttonPane.add(stopButton,2,1);

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
