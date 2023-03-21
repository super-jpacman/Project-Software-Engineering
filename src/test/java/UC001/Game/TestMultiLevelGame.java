package UC001.Game;

import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMultiLevelGame {
    private String path = "src/main/resources/mainScreen.gif";
    Player player = mock(Player.class);
    List<Level> levels;
    PacManUI pacManUI = mock(PacManUI.class);
    PlayerFactory playerFactory =mock(PlayerFactory.class);
    MultiLevelLauncher multiLevelLauncher = mock(MultiLevelLauncher.class);

    PointCalculator pointCalculator = mock(PointCalculator.class);
    @BeforeEach
    public void setup(){
        levels = new ArrayList<>();
        levels.add(mock(Level.class));
        levels.add(mock(Level.class));
    }
    @DisplayName("MultiLevelGame:Start game")
    @Test
    public void TC01() throws InterruptedException {
        MultiLevelGame multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI,playerFactory,multiLevelLauncher);
        MultiLevelGame game = multiLevelGame.makeGame();
        game = multiLevelGame.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        assertEquals(true,game.isInProgress());
    }
    @DisplayName("MultiLevelGame:Start game and stop game")
    @Test
    public void TC02() throws InterruptedException {
        MultiLevelGame multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI,playerFactory,multiLevelLauncher);
        MultiLevelGame game = multiLevelGame.makeGame();
        game = multiLevelGame.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        game.stop();
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("MultiLevelGame:no start")
    @Test
    public void TC03() throws InterruptedException {
        MultiLevelGame multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI,playerFactory,multiLevelLauncher);
        MultiLevelGame game = multiLevelGame.makeGame();
        game = multiLevelGame.getGame();
        Player player = game.getPlayers().get(0);
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("MultiLevelGame:Level won stage 1")
    @Test
    public void TC04() throws InterruptedException {
        MultiLevelGame multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI,playerFactory,multiLevelLauncher);
        multiLevelGame.makeGame();
        multiLevelGame.getGame();
        when(multiLevelGame.getLevel().remainingPellets()).thenReturn(0);
        when(multiLevelGame.getLevel().isAnyPlayerAlive()).thenReturn(true);
        Player player = multiLevelGame.getPlayers().get(0);
        System.out.println(multiLevelGame.getLevel().remainingPellets());
        multiLevelGame.start();
        assertEquals(1,multiLevelGame.getLevelNumber());
    }
    @DisplayName("MultiLevelGame:Restart game")
    @Test
    public void TC06() throws InterruptedException {
        MultiLevelLauncher multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI,playerFactory,multiLevelLauncher);
        MultiLevelGame game = multiLevelGame.makeGame();
        game = multiLevelGame.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        boolean before = game.isInProgress();
        game.restart();
        boolean after = game.isInProgress();
        assertNotEquals(before,after);
    }

}
