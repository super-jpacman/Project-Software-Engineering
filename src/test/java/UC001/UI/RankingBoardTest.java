package UC001.UI;

import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.RankingBoard;
import nl.tudelft.jpacman.ui.RankingMode;
import nl.tudelft.jpacman.ui.selectMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RankingBoardTest {
    PacManUI pacManUI = mock(PacManUI.class);
    @DisplayName("TC01 : When click back Expected go to Game Ranking")
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        RankingBoard rankingBoard = new RankingBoard(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rankingBoard);
        frame.pack();
        frame.setVisible(true);
        rankingBoard.ClickBackBTN();
        verify(pacManUI).GAMAE_RANKING();
    }
}
