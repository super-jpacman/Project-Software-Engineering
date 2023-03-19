package UC001.UI;

import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.FirstMenu;
import nl.tudelft.jpacman.ui.PacManUI;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import org.fest.swing.testing.FestSwingTestCaseTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FirstMenuTest{
    private FrameFixture mFrame;
    PacManUI pacManUI = mock(PacManUI.class);
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        FirstMenu firstMenu = new FirstMenu(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(firstMenu);
        frame.pack();
        frame.setVisible(true);
        firstMenu.ClickPlay();
        verify(pacManUI).GAMAE_MODE();
    }
}
