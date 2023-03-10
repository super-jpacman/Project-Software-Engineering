package UC001.board;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * The type Board test.
 */
public class BoardTest {
    private int MAX_WIDTH = 3;
    private int MAX_HEIGHT = 3;
    Square[][] grid;
    BoardForTest board;
    @BeforeEach
    public void setup(){
        grid = new Square[][]{
            {mock(Square.class), mock(Square.class), mock(Square.class)},
            {mock(Square.class), mock(Square.class), mock(Square.class)},
            {mock(Square.class), mock(Square.class), mock(Square.class)}
        };
    }
    @DisplayName("TC01:Test withinBorder")
    @ParameterizedTest
    @CsvSource({
        "0, 0, true",
        "0, 1, true",
        "1, 0, true",
        "1, 1, true",
        "-1, 0, false",
        "0, -1, false",
        "2, 0, true",
        "0, 2, true"
    })
    public void TC01(int x,int y,boolean expected){
        board = new BoardForTest(grid);
        assertEquals(expected,board.withinBorders(x,y));
    }
    @DisplayName("TC02:Test width of board")
    @Test
    void TC02() {
        board = new BoardForTest(grid);
        assertEquals(MAX_WIDTH,board.getWidth());
    }

    /**
     * Verifies the board has the correct height.
     */
    @DisplayName("TC03:Test height of board")
    @Test
    void TC03() {
        board = new BoardForTest(grid);
        assertEquals(MAX_HEIGHT,board.getHeight());
    }
}
