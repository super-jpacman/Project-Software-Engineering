package UC001.UI;

import nl.tudelft.jpacman.TestLauncher;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.ui.Action;
import nl.tudelft.jpacman.ui.ButtonPanel;
import nl.tudelft.jpacman.ui.GameEnd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonPanelTest {
    TestLauncher testLauncher = new TestLauncher();
    @Test
    public void test1() throws InterruptedException {
        GameEnd t = testLauncher.gameEnd("tae",100,10.0);
        t.setVisible(true);
        Thread.sleep(2000);
    }
}
