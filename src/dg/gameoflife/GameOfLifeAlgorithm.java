/* *****************************************************************************
* Description: A class used to simulate the mechanics in Conway's Game of Life.
* It is not meant to be instantiated. It just contains static methods that carry
* out the algorithm to simulate the rules of the game. The grid wraps around so
* the bottom meets up with the top, and the left side meets up with the right side.
*
* Author: Daniel Griffin
******************************************************************************/

package dg.gameoflife;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameOfLifeAlgorithm {

	// Creates an updated grid of the current grid after applying the
    // rules of the game. The rules are:
    // -Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    // -Any live cell with two or three live neighbours lives on to the next generation.
    // -Any live cell with more than three live neighbours dies, as if by over-population.
    // -Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	public static void createUpdatedGrid(Grid currentGrid) {
		Grid tempGrid = createNewGrid();

		// Loops through each cell of the grid and checks if it is dead or alive.
		// It then calls another function to handle that cell depending on
		// whether it is dead or alive.
        	for (int x=0; x<40; x++) {
        		for (int y=0; y<40; y++) {
    		        if (currentGrid.cellStatus(x, y) == true)
    		        	liveCellNeighbourChecker(currentGrid, tempGrid, x, y);
    		        else
    		        	deadCellNeighbourChecker(currentGrid, tempGrid, x, y);
        		}
            }

        	copyTempGridToCurrentGrid(currentGrid, tempGrid);
	}

	// Creates a Grid object which contains a 40 by 40 grid of Rectangles; all white.
	public static Grid createNewGrid() {
		Grid newGrid = new Grid();

    	for (int x=0; x<40; x++) {
    		for (int y=0; y<40; y++) {
		        Rectangle r = new Rectangle(15,15, Color.WHITE);
		        newGrid.add(r, x, y);
    		}
        }

    	return newGrid;
	}

	// Checks the neighbours of alive cells and updates the tempGrid accordingly.
	public static void liveCellNeighbourChecker(Grid currentGrid, Grid tempGrid, int x, int y) {
		// Set to -1 as it will count the cell itself in the loop below.
		int numberOfNeighbours = -1;

		// Loops through 9 cells. The cell in question along with the surrounding 8.
    		for (int col = (x-1); col<(x+2); col++) {
    			for (int row = (y-1); row<(y+2); row++) {
                    int tempRow = row;
                    int tempCol = col;

                    if (tempCol == 40)
                        tempCol = 0;
                    else if (tempCol == -1)
                        tempCol = 39;

                    if (tempRow == 40)
                        tempRow = 0;
                    else if (tempRow == -1)
                        tempRow = 39;

    				if (currentGrid.cellStatus(tempCol, tempRow) == true)
    					numberOfNeighbours++;
    			}
    		}


		if (numberOfNeighbours == 2 || numberOfNeighbours == 3)
			tempGrid.turnCellBlack(x, y);
	}

	// Checks the neighbours of dead cells and updates the tempGrid accordingly.
	public static void deadCellNeighbourChecker(Grid currentGrid, Grid tempGrid, int x, int y) {
		int numberOfNeighbours = 0;

        // Loops through 9 cells. The cell in question along with the surrounding 8.
        for (int col = (x-1); col<(x+2); col++) {
        	for (int row = (y-1); row<(y+2); row++) {
                int tempRow = row;
                int tempCol = col;

                if (tempCol == 40)
                    tempCol = 0;
                else if (tempCol == -1)
                    tempCol = 39;

                if (tempRow == 40)
                    tempRow = 0;
                else if (tempRow == -1)
                    tempRow = 39;

                if (currentGrid.cellStatus(tempCol, tempRow) == true)
                    numberOfNeighbours++;
        	}
        }

		if (numberOfNeighbours == 3)
			tempGrid.turnCellBlack(x, y);
	}

	// Copies the tempGrid to the currentGrid. This is done once the tempGrid
	// has been fully completed to show the next stage after the what the
	// currentGrid shows.
	public static void copyTempGridToCurrentGrid(Grid currentGrid, Grid tempGrid) {
    	for (int x=0; x<40; x++) {
    		for (int y=0; y<40; y++) {
		        if (tempGrid.cellStatus(x, y) == true)
		        	currentGrid.turnCellBlack(x, y);
		        else
		        	currentGrid.turnCellWhite(x, y);
    		}
        }
	}
}
