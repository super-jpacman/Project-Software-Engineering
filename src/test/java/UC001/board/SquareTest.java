package UC001.board;

import nl.tudelft.jpacman.board.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
class SquareTest {
    private SquareForTest square;

    @BeforeEach
    void setUp() {
        square = new SquareForTest();
    }
    @DisplayName("Test Function Occupy put")
    @Test
    void testOccupy() {
        Unit occupant = mock(Unit.class);
        square.put(occupant);
        assertThat(square.getOccupants()).contains(occupant);
    }
    @DisplayName("Test Function Occupy put and remove")
    @Test
    void testLeave() {
        Unit occupant = mock(Unit.class);
        square.put(occupant);
        System.out.println(square.getOccupants());
        square.remove(occupant);
        System.out.println(square.getOccupants());
        assertThat(square.getOccupants()).doesNotContain(occupant);
    }

    @DisplayName("Test Function Occupy put 2 unit")
    @Test
    void testOrder() {
        Unit o1 = mock(Unit.class);
        Unit o2 = mock(Unit.class);
        square.put(o1);
        square.put(o2);
        assertThat(square.getOccupants()).containsSequence(o1, o2);
    }
}
