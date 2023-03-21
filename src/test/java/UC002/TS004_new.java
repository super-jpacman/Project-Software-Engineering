package UC002;

import nl.tudelft.jpacman.TestMultiLevelLauncher;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.*;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TS004_new {
    TestMultiLevelLauncher testMultiLevelLauncher;
    @BeforeEach
    public void setup(){
        testMultiLevelLauncher = new TestMultiLevelLauncher();
        testMultiLevelLauncher.setMapTest("");
        testMultiLevelLauncher.setLengthOfMap(1,5);
    }
    @DisplayName("Game stop Expected Inky,Pinky,Clyde,Blinky cannot move")
    @Test
    public void TC01() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PacManUI_PLAY_RANK(game);
        Player player = game.getPlayers().get(0);
        Board board = game.getLevel().getBoard();
        Inky inky = Navigation.findUnitInBoard(Inky.class,board);
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,board);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,board);
        Pinky pinky = Navigation.findUnitInBoard(Pinky.class,board);
        Square Inkybefore = inky.getSquare();
        Square Blinkybefore = blinky.getSquare();
        Square Clydebefore = clyde.getSquare();
        Square Pinkybefore = pinky.getSquare();
        Thread.sleep(1000);
        Square Inkyafter = inky.getSquare();
        Square Blinkyafter = blinky.getSquare();
        Square Clydeafter = clyde.getSquare();
        Square Pinkyafter = pinky.getSquare();
        assertEquals(Inkybefore,Inkyafter);
        assertEquals(Blinkybefore,Blinkyafter);
        assertEquals(Clydebefore,Clydeafter);
        assertEquals(Pinkybefore,Pinkyafter);
    }
    @DisplayName("Game stop Expected Inky,Pinky,Clyde,Blinky cannot move")
    @Test
    public void TC02() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PacManUI_PLAY_RANK(game);
        Player player = game.getPlayers().get(0);
        Board board = game.getLevel().getBoard();
        Inky inky = Navigation.findUnitInBoard(Inky.class,board);
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,board);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class,board);
        Pinky pinky = Navigation.findUnitInBoard(Pinky.class,board);
        Square Inkybefore = inky.getSquare();
        Square Blinkybefore = blinky.getSquare();
        Square Clydebefore = clyde.getSquare();
        Square Pinkybefore = pinky.getSquare();
        game.start();
        Thread.sleep(1000);
        Square Inkyafter = inky.getSquare();
        Square Blinkyafter = blinky.getSquare();
        Square Clydeafter = clyde.getSquare();
        Square Pinkyafter = pinky.getSquare();
        assertNotEquals(Inkybefore,Inkyafter);
        assertNotEquals(Blinkybefore,Blinkyafter);
        assertNotEquals(Clydebefore,Clydeafter);
        assertNotEquals(Pinkybefore,Pinkyafter);
    }
    @DisplayName("Game start Expected pacman cannot move")
    @Test
    public void TC03() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PacManUI_PLAY_RANK(game);
        Player player = game.getPlayers().get(0);
        Board board = game.getLevel().getBoard();
        Square before = player.getSquare();
        for(int i = 0 ; i <= 10 ; i++){
            move(player,game,getRandomDirection(),1);
        }
        Square after = player.getSquare();
        assertEquals(before,after);
    }
    @DisplayName("Game start Expected pacman can move")
    @Test
    public void TC04() throws InterruptedException {
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PacManUI_PLAY_RANK(game);
        Player player = game.getPlayers().get(0);
        Square before = player.getSquare();
        game.start();
        for(int i = 0 ; i <= 10 ; i++){
            move(player,game,getRandomDirection(),1);
            Thread.sleep(500);
        }
        Square after = player.getSquare();
        assertNotEquals(before,after);
    }
    @AfterEach
    public void teardown(){
        testMultiLevelLauncher.dispose();
    }
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Player player, Game game, Direction dir, int numSteps) throws InterruptedException {
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(5);
        }
    }
}
