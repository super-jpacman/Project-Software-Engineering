package UC001.UI;

import nl.tudelft.jpacman.Test.TestMultiLevelLauncher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.MultiLevelGame;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;
import nl.tudelft.jpacman.ui.ScorePanel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@Disabled
public class CasualEndingTest {
    PacManUI pacManUI = mock(PacManUI.class);
    Game game = mock(Game.class);
    PacManUiBuilder pacManUiBuilder = mock(PacManUiBuilder.class);
    @Test
    public void TC01() throws InterruptedException {
        TestMultiLevelLauncher testMultiLevelLauncher = spy(new TestMultiLevelLauncher());
        testMultiLevelLauncher.setMapTest("");
        testMultiLevelLauncher.setLengthOfMap(1,1);
        testMultiLevelLauncher.GAME_MODE_NOW = "CASUAL";
        testMultiLevelLauncher.launch();
        MultiLevelGame game1 = testMultiLevelLauncher.getGame();
        Player player = game1.getPlayers().get(0);
        PacManUI pacManUI1 = testMultiLevelLauncher.getPacManUI();
        game1.start();
        String Text_header = "Test";
        int Text_score = 450;
        double time = 50.0;
        pacManUI1.PacManUI_LOST(Text_header,Text_score,time);
        ScorePanel scorePanel = testMultiLevelLauncher.getPacManUI().getScorePanel();
        scorePanel.ClickBack();
        assertEquals(true,scorePanel.isCheckClick());
    }
}
