package UC001.Game;

import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMultiLevelGame {
    MultiLevelGame multiLevelGame;
    Player player = mock(Player.class);
    List<Level> levels;
    PacManUI pacManUI = mock(PacManUI.class);
    PointCalculator pointCalculator = mock(PointCalculator.class);
    @BeforeEach
    public void setup(){
        levels = new ArrayList<>();
        levels.add(mock(Level.class));
        levels.add(mock(Level.class));
        multiLevelGame = new MultiLevelGame(player,levels,pointCalculator,pacManUI);
    }
    @DisplayName("MultiLevelGame:Start game and stop game")
    @Test
    public void TC04() throws InterruptedException {
        multiLevelGame.start();
        assertEquals(true,multiLevelGame.getLevel() == levels.get(0));
        assertEquals(true,multiLevelGame.isInProgress());
        multiLevelGame.stop();
        assertEquals(false,multiLevelGame.isInProgress());
    }
    @DisplayName("MultiLevelGame:Level won stage 1")
    @Test
    public void TC05() throws InterruptedException {
        multiLevelGame.start();
        multiLevelGame.levelWon();
        assertEquals(true,multiLevelGame.getLevel() == levels.get(1));
        assertEquals(true,multiLevelGame.isInProgress());
        multiLevelGame.stop();
        assertEquals(false,multiLevelGame.isInProgress());
    }
}
