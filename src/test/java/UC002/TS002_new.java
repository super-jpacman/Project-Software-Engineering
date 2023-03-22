package UC002;

import nl.tudelft.jpacman.Test.TestMultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TS002_new {
    TestMultiLevelLauncher testMultiLevelLauncher;
    @BeforeEach
    public void setup(){
        testMultiLevelLauncher = new TestMultiLevelLauncher();
        testMultiLevelLauncher.setMapTest("_Collision_Inky");
        testMultiLevelLauncher.setLengthOfMap(1,1);
    }
    @DisplayName("TC01: Pacman collision Inky Expected game.isInProgress() = false")
    @Test
    public void TC01() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PLAY_AT_MAP(1);
        game.start();
        Player player = game.getPlayers().get(0);
        while(game.isInProgress() != false){
            move(player,game,getRandomDirection(),1);
        }
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC02: Pacman collision Blinky Expected game.isInProgress() = false")
    @Test
    public void TC02() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        while(game.isInProgress() != false){
            move(player,game,getRandomDirection(),1);
        }
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC03: Pacman collision Clyde Expected game.isInProgress() = false")
    @Test
    public void TC03() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        while(game.isInProgress() != false){
            move(player,game,getRandomDirection(),1);
        }
        assertEquals(false,game.isInProgress());
    }
    @DisplayName("TC04: Pacman collision Pinky Expected game.isInProgress() = false")
    @Test
    public void TC04() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        while(game.isInProgress() != false){
            move(player,game,getRandomDirection(),1);
        }
        assertEquals(false,game.isInProgress());
    }

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Player player,Game game, Direction dir, int numSteps) throws InterruptedException {
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(100);
        }
    }
}
