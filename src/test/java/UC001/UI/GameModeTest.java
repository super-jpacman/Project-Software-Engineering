package UC001.UI;

import nl.tudelft.jpacman.ui.FirstMenu;
import nl.tudelft.jpacman.ui.GameMode;
import nl.tudelft.jpacman.ui.PacManUI;
import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameModeTest {
    private FrameFixture mFrame;
    PacManUI pacManUI = mock(PacManUI.class);
    @DisplayName("TC01 : When click back it should go back to main menu")
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        GameMode gameMode = new GameMode(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameMode);
        frame.pack();
        frame.setVisible(true);
        gameMode.ClickBack();
        verify(pacManUI).MainMenuUI();
    }
    @DisplayName("TC02 : When click Ranking it should go back to Ranking")
    @Test
    public void TC02() throws InterruptedException {
        JFrame frame = new JFrame();
        GameMode gameMode = new GameMode(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameMode);
        frame.pack();
        frame.setVisible(true);
        gameMode.ClickRanking();
        verify(pacManUI).GAMAE_RANKING();
    }
    @DisplayName("TC03 : When click Casual it should go back to Casual")
    @Test
    public void TC03() throws InterruptedException {
        JFrame frame = new JFrame();
        GameMode gameMode = new GameMode(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameMode);
        frame.pack();
        frame.setVisible(true);
        gameMode.ClickCasual();
        verify(pacManUI).GAMAE_CASUAL();
    }
}
