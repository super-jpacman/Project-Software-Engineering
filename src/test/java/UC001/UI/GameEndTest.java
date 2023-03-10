package UC001.UI;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.GameEnd;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEndTest {
    TestLauncher testLauncher = new TestLauncher();

    @Test
    public void s1() throws InterruptedException {
        GameEnd t = testLauncher.gameEnd("You won",100,10.0);
        t.setVisible(true);
        t.SetName("Tae");
        Thread.sleep(2000);
        t.SetOnClick();
        Thread.sleep(2000);
    }
    @Test
    public void bu(){
        GameEnd t = testLauncher.gameEnd("You won",100,10.0);
        t.setVisible(true);
        JTextField textField = (JTextField) t.getContentPane().getComponent(0).getParent();

    }
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
