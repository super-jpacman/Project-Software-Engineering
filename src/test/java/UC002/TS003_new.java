package UC002;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.TestMultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Disabled
public class TS003_new {
    @DisplayName("CheckStage")
    @Test
    public void TC03() throws InterruptedException {
        TestMultiLevelLauncher testMultiLevelLauncher = new TestMultiLevelLauncher();
        testMultiLevelLauncher.setMapTest("_Without_Ghost");
        testMultiLevelLauncher.setLengthOfMap(7,11);
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PacManUI_PLAY_RANK(game);
        Player player = game.getPlayers().get(0);
        game.start();
        while(game.getLevelNumber()!=4){
            move(player,game, getRandomDirection(),1);
            game.start();
        }
        assertEquals(4,game.getLevelNumber());

    }
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Player player, Game game, Direction dir, int numSteps) throws InterruptedException {
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(0);
        }
    }
}
