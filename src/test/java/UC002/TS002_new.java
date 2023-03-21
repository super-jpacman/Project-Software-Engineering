package UC002;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TS002_new {
    @DisplayName("TC03: Pacman collision Inky Expected pacman die")
    @Test
    public void TC03() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Collision_Inky");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        move(player,game,Direction.EAST,1);
        assertEquals(false,player.isAlive());
        testLauncher.dispose();
    }
    @DisplayName("TC04: Pacman collision Blinky Expected pacman die")
    @Test
    public void TC04() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Collision_Blinky");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        move(player,game,Direction.EAST,1);
        assertEquals(false,player.isAlive());
        testLauncher.dispose();
    }
    @DisplayName("TC05: Pacman collision Clyde Expected pacman die")
    @Test
    public void TC05() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Collision_Clyde");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        move(player,game,Direction.EAST,1);
        assertEquals(false,player.isAlive());
        testLauncher.dispose();
    }
    @DisplayName("TC06: Pacman collision Pinky Expected pacman die")
    @Test
    public void TC06() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Collision_Pinky");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        move(player,game,Direction.EAST,1);
        assertEquals(false,player.isAlive());
        testLauncher.dispose();
    }
    
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Player player,Game game, Direction dir, int numSteps) throws InterruptedException {
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(0);
        }
    }
}
