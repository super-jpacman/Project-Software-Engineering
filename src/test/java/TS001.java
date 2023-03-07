import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class TS001 {
    private MultiLevelLauncher multiLevelLauncher;
    @BeforeEach
    void setUpPacman() {
        multiLevelLauncher = new MultiLevelLauncher();
        multiLevelLauncher.launch();
    }
    @Disabled
    @DisplayName("When pacman eat pellet player should get score")
    @Test
    public void TC08() throws InterruptedException {
        Game game = multiLevelLauncher.getGame();
        Player player = game.getPlayers().get(0);
        // start the game.
        game.start();
        int Total_Pellet = game.getLevel().remainingPellets();
        while(Total_Pellet == game.getLevel().remainingPellets()) {
            move(game,getRandomDirection(),1);
        }
        assertEquals(10,player.getScore());
    }
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
