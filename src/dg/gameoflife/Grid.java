/* *****************************************************************************
* Description: A class used to represent and store the details of the cells in
* the grid for Conway's Game of Life.
*
* Purpose: Hobby Project.
*
* Date last modified: 29/08/16
*
* Author: Daniel Griffin
******************************************************************************/

package dg.gameoflife;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid {

	private Rectangle[][] cells;

	// Constructor which creates a 40 by 40 array for the Rectangles.
	public Grid() {
		cells = new Rectangle[40][40];
	}

	// Adds a Rectangle to the array of cells in the grid.
	public void add(Rectangle r, int x, int y) {
		cells[x][y] = r;
	}

	// Turns a cell white to represent a dead state.
	public void turnCellWhite (int x, int y) {
		cells[x][y].setFill(Color.WHITE);
	}

	// Turns a cell black to represent an alive state.
	public void turnCellBlack (int x, int y) {
		cells[x][y].setFill(Color.BLACK);
	}

	// Returns 'true' if cell is alive and 'false' if it is dead.
	public Boolean cellStatus(int x, int y){
		if (cells[x][y].getFill() == Color.BLACK)
			return true;
		else
			return false;
	}

    // Resets the grid so all the cells are white/dead.
    public void resetGrid() {
        for (int x=0; x<40; x++) {
            for (int y=0; y<40; y++) {
                turnCellWhite(x,y);
        }
    }

    /*** Function not currently used ***/
	// Returns true if there are any live cells left in the grid visible to the user.
	public Boolean gridStatus() {
		for (int x=0; x<40; x++) {
    		for (int y=1; y<40; y++) {
		        if (this.cellStatus(x, y) == true) {
		        	return true;
		        }
    		}
        }
		return false;
	}
}
