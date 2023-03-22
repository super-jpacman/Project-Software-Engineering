package UC001.UI;

import nl.tudelft.jpacman.Test.RankingModeForTest;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.GameMode;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.RankingMode;
import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RankingModeTest {
    private FrameFixture mFrame;
    PacManUI pacManUI = mock(PacManUI.class);
    @DisplayName("TC01 : When start Expected go to game")
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        RankingModeForTest rankingMode = new RankingModeForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rankingMode);
        frame.pack();
        frame.setVisible(true);
        rankingMode.ClickStart();
        assertEquals(true,rankingMode.isClickstart());
    }
    @DisplayName("TC01 : When Leaderboard Expected go to Leaderboard")
    @Test
    public void TC02() throws InterruptedException {
        JFrame frame = new JFrame();
        RankingMode rankingMode = new RankingMode(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rankingMode);
        frame.pack();
        frame.setVisible(true);
        rankingMode.ClickLeaderboard();
        verify(pacManUI).RANKING_BOARD();
    }
    @DisplayName("TC03 : When click back it should go back to game mode")
    @Test
    public void TC03() throws InterruptedException {
        JFrame frame = new JFrame();
        RankingMode rankingMode = new RankingMode(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rankingMode);
        frame.pack();
        frame.setVisible(true);
        rankingMode.ClickBack();
        verify(pacManUI).GAME_MODE();
    }
}
