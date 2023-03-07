import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testmap {

    @DisplayName("Test when pacman walk and win")
    @Test
    public void TC07() throws InterruptedException{
        MultiLevelLauncher multiLevelLauncher = new MultiLevelLauncher();
        multiLevelLauncher.makeLevelTest("1");
        multiLevelLauncher.launch();
        Thread.sleep(2000);
        Game game = multiLevelLauncher.getGame();
        Player player = game.getPlayers().get(0);
        int Total_pellet = game.getLevel().remainingPellets();
        game.start();
        while(game.getLevel().remainingPellets() != 0) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(Total_pellet*10.,player.getScore());
    }

    @AfterEach
    void tearDown() {
        multiLevelLauncher.dispose();
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
