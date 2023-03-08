import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TS001 {
    @DisplayName("When pacman eat pellet player should get score")
    @Test
    public void TC08() throws InterruptedException {
        MultiLevelLauncher multiLevelLauncher = new MultiLevelLauncher();
        Game game = multiLevelLauncher.makeGame();
        multiLevelLauncher.launch();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        int Total_Pellet = game.getLevel().remainingPellets();
        while(Total_Pellet == game.getLevel().remainingPellets()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(10,player.getScore());
        multiLevelLauncher.dispose();
    }
    @DisplayName("Test when pacman walk and win")
    @Test
    public void TC09() throws InterruptedException{
        TestLauncher test = new TestLauncher();
        test.launch();
        MultiLevelGame game = test.getGame();
        game.setStartStage(7);
        Player player = game.getPlayers().get(0);
        int Total_pellet = game.getLevel().remainingPellets();
        game.start();
        int level = game.getLevelNumber();
        while(game.getLevel().remainingPellets() != 0 && level == game.getLevelNumber()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(Total_pellet*10.,player.getScore());
    }
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Game game, Direction dir, int numSteps) throws InterruptedException {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}
