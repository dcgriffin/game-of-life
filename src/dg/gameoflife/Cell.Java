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

public class Cell extends Rectangle {

    // Returns 'true' if cell is alive and 'false' if it is dead.
    public Boolean cellStatus() {
        if (this.getFill() == Color.BLACK)
            return true;
        else
            return false;
    }

    // Turns a cell black to represent an alive state.
    public void turnCellBlack (int x, int y) {
        this.setFill(Color.BLACK);
    }

    // Turns a cell white to represent a dead state.
    public void turnCellWhite (int x, int y) {
        this.setFill(Color.WHITE);
    }

    // A method that is called when a cell is clicked. It changes the dead/alive
    // status of the cell.
    public cellClicked void() {
        if (this.cellStatus == true)
            this.turnCellWhite;
        else
            this.turnCellBlack;
    }
}
