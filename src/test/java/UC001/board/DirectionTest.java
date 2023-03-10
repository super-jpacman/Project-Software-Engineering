package UC001.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.tudelft.jpacman.board.Direction;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {
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
        AssertionsForClassTypes.assertThat(south.getDeltaY()).isEqualTo(1);
    }
    @DisplayName("TC03:Direction WEST")
    @Test
    public void TC03(){
        Direction west = Direction.valueOf("WEST");
        AssertionsForClassTypes.assertThat(west.getDeltaX()).isEqualTo(-1);
    }
    @DisplayName("TC04:Direction EAST")
    @Test
    public void TC04(){
        Direction east = Direction.valueOf("EAST");
        AssertionsForClassTypes.assertThat(east.getDeltaX()).isEqualTo(1);
    }

}
