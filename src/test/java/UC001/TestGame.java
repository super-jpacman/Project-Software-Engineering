package UC001;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestGame {
    @DisplayName("Single player:player alive and have 10 pellet")
    @Test
    public void TC01() throws InterruptedException {
        Player player = mock(Player.class);
        Level level = mock(Level.class);
        PointCalculator pointCalculator = mock(PointCalculator.class);
        SinglePlayerGameForTest singlePlayerGameForTest = new SinglePlayerGameForTest(player,level,pointCalculator);
        when(player.isAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(10);
        System.out.println(level.remainingPellets());
        singlePlayerGameForTest.start();
        assertEquals(true,singlePlayerGameForTest.isInProgress());
    }
    @DisplayName("Single player:player not alive and have 10 pellet")
    @Test
    public void TC02() throws InterruptedException {
        Player player = mock(Player.class);
        Level level = mock(Level.class);
        PointCalculator pointCalculator = mock(PointCalculator.class);
        SinglePlayerGameForTest singlePlayerGameForTest = new SinglePlayerGameForTest(player,level,pointCalculator);
        when(player.isAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(10);
        singlePlayerGameForTest.start();
        assertEquals(false,singlePlayerGameForTest.isInProgress());
    }
    @DisplayName("Single player:player alive and have 0 pellet")
    @Test
    public void TC03() throws InterruptedException {
        Player player = mock(Player.class);
        Level level = mock(Level.class);
        PointCalculator pointCalculator = mock(PointCalculator.class);
        SinglePlayerGameForTest singlePlayerGameForTest = new SinglePlayerGameForTest(player,level,pointCalculator);
        when(player.isAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(0);
        singlePlayerGameForTest.start();
        assertEquals(false,singlePlayerGameForTest.isInProgress());
    }
}
