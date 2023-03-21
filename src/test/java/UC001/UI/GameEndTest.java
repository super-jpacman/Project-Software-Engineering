package UC001.UI;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.GameEnd;
import nl.tudelft.jpacman.ui.PacManUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class GameEndTest {
    TestLauncher testLauncher = new TestLauncher();

    /*@DisplayName("TC01:Test Button and Test Field")
    @Test
    public void ButtonTest() throws InterruptedException {
        testLauncher.LenghtOfMap(1,5);
        testLauncher.setNameoftest("");
        testLauncher.launch();
        PacManUI ui = testLauncher.getPacManUI();
        GameEnd t = testLauncher.gameEnd("You won",100,10.0,ui);
        t.setVisible(true);
        t.SetName("Tae");
        assertEquals("Tae",t.getname());
        t.SetOnClick();
        assertEquals(true,t.isClick());

    }*/
    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    public static void move(Game game, Direction dir, int numSteps) throws InterruptedException {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
            Thread.sleep(0);
        }
    }

}
