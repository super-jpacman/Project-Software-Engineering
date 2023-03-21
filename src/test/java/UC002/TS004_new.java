package UC002;

import nl.tudelft.jpacman.Test.TestMultiLevelLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class TS004_new {
    TestMultiLevelLauncher testMultiLevelLauncher;
    @BeforeEach
    public void setup(){
        testMultiLevelLauncher = spy(new TestMultiLevelLauncher());
        testMultiLevelLauncher.setMapTest("");
        testMultiLevelLauncher.GAME_MODE_NOW = "CASUAL";
    }
    @DisplayName("TC01 : when at stage 3 and click restart Expected got to stage 3 and score 0")
    @Test
    public void TC01() throws InterruptedException {
        testMultiLevelLauncher.setLengthOfMap(1,5);
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PLAY_AT_MAP(3);
        Player player = game.getPlayers().get(0);
        game.start();
        game.restart();
        assertEquals(3,player.getMap());
        assertEquals(0,player.getScore());
    }
    @DisplayName("TC02 : When end stage 1 Expected stage is 1 as before")
    @Test
    public void TC02() throws InterruptedException {
        testMultiLevelLauncher.setLengthOfMap(7,11);
        testMultiLevelLauncher.setMapTest("_Without_Ghost");
        testMultiLevelLauncher.launch();
        MultiLevelGame game = testMultiLevelLauncher.getGame();
        PacManUI pacManUI = testMultiLevelLauncher.getPacManUI();
        pacManUI.PLAY_AT_MAP(1);
        Player player = game.getPlayers().get(0);
        game.start();
        while(game.isInProgress() != false){
            move(player,game,getRandomDirection(),1);
        }
        assertEquals(1,player.getMap());
    }
    @AfterEach
    public void teardown(){
        testMultiLevelLauncher.dispose();
        testMultiLevelLauncher.GAME_MODE_NOW = "";
        testMultiLevelLauncher.GAME_THEME_NOW = 2;
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
