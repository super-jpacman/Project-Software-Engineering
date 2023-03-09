package UC001;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TS001 {
    @DisplayName("TC01:Direction NORTH")
    @Test
    public void TC01(){
        Direction north = Direction.valueOf("NORTH");
        assertEquals(-1,north.getDeltaY());
    }
    @DisplayName("TC02:Direction SOUTH")
    @Test
    public void TC02(){
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
    }
    @DisplayName("TC03:Direction WEST")
    @Test
    public void TC03(){
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaX()).isEqualTo(-1);
    }
    @DisplayName("TC04:Direction EAST")
    @Test
    public void TC04(){
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaX()).isEqualTo(1);
    }
    @Test
    public void testBoard() {
        BOARD_X_SIZE = 4;
        BOARD_Y_SIZE = 4;
        int[][] grid = new int[BOARD_X_SIZE][BOARD_Y_SIZE];
        Board board = new Board(grid);
    }
}
