package UC002;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.TestMultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.GameEnd;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TS001_new {
    @DisplayName("TC01: Pacman move West")
    @Test
    public void TC01() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.WEST,1);
        Square after = player.getSquare();
        assertNotEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC02: Pacman move East")
    @Test
    public void TC02() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.EAST,1);
        Square after = player.getSquare();
        assertNotEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC03: Pacman move North")
    @Test
    public void TC03() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.NORTH,1);
        Square after = player.getSquare();
        assertNotEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC04: Pacman move South")
    @Test
    public void TC04() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.SOUTH,1);
        Square after = player.getSquare();
        assertNotEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC05: Pacman move West no wall")
    @Test
    public void TC05() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk_No_Wall");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.WEST,23);
        Square after = player.getSquare();
        Thread.sleep(2000);
        assertEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC06: Pacman move East no wall")
    @Test
    public void TC06() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk_No_Wall");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.EAST,23);
        Square after = player.getSquare();
        Thread.sleep(2000);
        assertEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC06: Pacman move North no wall")
    @Test
    public void TC07() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk_No_Wall");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.NORTH,5);
        Square after = player.getSquare();
        assertEquals(after,before);
        testLauncher.dispose();
    }
    @DisplayName("TC06: Pacman move South no wall")
    @Test
    public void TC08() throws InterruptedException {
        TestLauncher testLauncher = new TestLauncher();
        testLauncher.setNameoftest("_Walk_No_Wall");
        testLauncher.LenghtOfMap(1,1);
        testLauncher.launch();
        MultiLevelGame game = testLauncher.getGame();
        game.start();
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        move(player,game,Direction.SOUTH,5);
        Square after = player.getSquare();
        assertEquals(after,before);
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
