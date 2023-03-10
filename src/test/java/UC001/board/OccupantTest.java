package UC001.board;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square target = new BasicSquare();
        unit.occupy(target);

        // The assignment did not make it clear what exactly is to be tested here so we tested both
        assertThat(unit.getSquare()).isEqualTo(target);
        assertThat(target.getOccupants().contains(unit)).isTrue();
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square target = new BasicSquare();
        unit.occupy(target);

        BasicUnit unit2 = new BasicUnit();
        unit2.occupy(target);

        // The assignment did not make it clear what exactly is to be tested here so we tested both
        assertThat(unit.getSquare()).isEqualTo(target);
        assertThat(target.getOccupants().contains(unit)).isTrue();
    }
}
