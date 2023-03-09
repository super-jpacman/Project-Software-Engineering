package UC001.board;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Board test.
 */
public class BoardTest {

    private Square square;

    /**
     * Creates a new BasicSquare for each test method .
     */
    @BeforeEach
    public void setup() {
        square = new BasicSquare();
    }

    /**
     * Tests board creation with a valid grid.
     */
    /*@Test
    public void testBoard() {
        Board test = new Board(new Square[][] {{ square }});
        assertThat(test.squareAt(0, 0)).isEqualTo(square);
    }*/
}
