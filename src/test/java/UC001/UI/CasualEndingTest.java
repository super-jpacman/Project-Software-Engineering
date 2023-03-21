package UC001.UI;

import nl.tudelft.jpacman.ui.CasualEnding;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.selectMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import javax.swing.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class CasualEndingTest {
    PacManUI pacManUI = mock(PacManUI.class);
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        String Text_header = "Test";
        int Text_score = 450;
        double time = 50.0;
        CasualEnding casualEnding = new CasualEnding(Text_header,Text_score,time,pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(casualEnding);
        frame.pack();
        frame.setVisible(true);
        /*casualEnding.ClickBackBTN();
        verify(pacManUI).GAMAE_CASUAL();*/
    }
}
