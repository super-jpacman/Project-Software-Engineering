package UC001.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link DefaultPointCalculator}.
 */
public class DefaultPointCalculatorTest {

    Player player = mock(Player.class);
    Ghost ghost = mock(Ghost.class);
    Pellet pellet = mock(Pellet.class);
    private DefaultPointCalculator pointCalculator;

    @BeforeEach
    public void setUp() {
        pointCalculator = new DefaultPointCalculator();
    }

    @Test
    public void testCollidedWithAGhost() {
        pointCalculator.collidedWithAGhost(player, ghost);
        // No points should be added for colliding with a ghost.
        assertEquals(0, player.getScore());
    }

    @Test
    public void testConsumedAPellet() {
        when(pellet.getValue()).thenReturn(10);
        pointCalculator.consumedAPellet(player, pellet);
        // Points should be added for consuming a pellet.
        assertEquals(10, player.getScore());
    }

    @Test
    public void testPacmanMoved() {
        Player player = mock(Player.class);
        Direction direction = Direction.NORTH;
        pointCalculator.pacmanMoved(player, direction);
        // No points should be added for moving.
        assertEquals(0, player.getScore());
    }
}
