package UC001.Game;

import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestSinglePlayer {
    @DisplayName("Single player:player alive and have 10 pellet")
    @Test
    public void TC01() throws InterruptedException {
        Player player = mock(Player.class);
        Level level = mock(Level.class);
        PointCalculator pointCalculator = mock(PointCalculator.class);
        SinglePlayerGameForTest singlePlayerGameForTest = new SinglePlayerGameForTest(player,level,pointCalculator);
        when(player.isAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(10);
        singlePlayerGameForTest.makeGame();
        singlePlayerGameForTest.launch();
        Game game = singlePlayerGameForTest.getGame();
        game.start();
        game.getPlayers().get(0);
        assertEquals(true,game.isInProgress());
    }
    @DisplayName("Single player:player not alive and have 10 pellet")
    @Test
    public void TC02(){
        Player player = mock(Player.class);
        Level level = mock(Level.class);
        PointCalculator pointCalculator = mock(PointCalculator.class);
        SinglePlayerGameForTest singlePlayerGameForTest = new SinglePlayerGameForTest(player,level,pointCalculator);
        when(player.isAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(10);
        singlePlayerGameForTest.makeGame();
        singlePlayerGameForTest.launch();
        Game game = singlePlayerGameForTest.getGame();
        game.start();
        game.getPlayers().get(0);
        assertEquals(true,game.isInProgress());
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
