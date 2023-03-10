package UC001.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("TC01: loadDefaultCalculator")
    public void TC01() {
        pointCalculator.collidedWithAGhost(player, ghost);
        // No points should be added for colliding with a ghost.
        assertEquals(0, player.getScore());
    }

    @Test
    @DisplayName("TC02: ConsumedAPellet")
    public void TC02() {
        when(pellet.getValue()).thenReturn(10);
        System.out.println(pellet.getValue());
        System.out.println(player.getScore());
        player.addPoints(10);
        System.out.println(player.getScore());
        pointCalculator.consumedAPellet(player, pellet);
        assertNotNull(player.getScore());
    }

    @Test
    @DisplayName("TC03: PacmanMoved")
    public void TC03() {
        Player player = mock(Player.class);
        Direction direction = Direction.NORTH;
        pointCalculator.pacmanMoved(player, direction);
        // No points should be added for moving.
        assertEquals(0, player.getScore());
    }
}
