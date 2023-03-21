package UC001.UI;

import nl.tudelft.jpacman.Test.selectMapForTest;
import nl.tudelft.jpacman.ui.GameMode;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.selectMap;
import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SelectMapTest {
    PacManUI pacManUI = mock(PacManUI.class);
    @DisplayName("TC01 : When click Map1 and Click Next Expected Map_lv = 1 and go to game")
    @Test
    public void TC01() throws InterruptedException {
        JFrame frame = new JFrame();
        selectMapForTest selectMap = new selectMapForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(selectMap);
        frame.pack();
        frame.setVisible(true);
        selectMap.ClickMap1();
        selectMap.ClickNext();
        assertEquals(1,selectMap.getMap_lv());
        assertEquals("yes",selectMap.getMove_Map());
    }
    @DisplayName("TC02 : When click Map2 and Click Next Expected Map_lv = 2 and go to game")
    @Test
    public void TC02() throws InterruptedException {
        JFrame frame = new JFrame();
        selectMapForTest selectMap = new selectMapForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(selectMap);
        frame.pack();
        frame.setVisible(true);
        selectMap.ClickMap2();
        selectMap.ClickNext();
        assertEquals(2,selectMap.getMap_lv());
        assertEquals("yes",selectMap.getMove_Map());
    }
    @DisplayName("TC03 : When click Map3 and Click Next Expected Map_lv = 3 and go to game")
    @Test
    public void TC03() throws InterruptedException {
        JFrame frame = new JFrame();
        selectMapForTest selectMap = new selectMapForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(selectMap);
        frame.pack();
        frame.setVisible(true);
        selectMap.ClickMap3();
        selectMap.ClickNext();
        assertEquals(3,selectMap.getMap_lv());
        assertEquals("yes",selectMap.getMove_Map());
    }
    @DisplayName("TC04 : When click Map4 and Click Next Expected Map_lv = 4 and go to game")
    @Test
    public void TC04() throws InterruptedException {
        JFrame frame = new JFrame();
        selectMapForTest selectMap = new selectMapForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(selectMap);
        frame.pack();
        frame.setVisible(true);
        selectMap.ClickMap4();
        selectMap.ClickNext();
        assertEquals(4,selectMap.getMap_lv());
        assertEquals("yes",selectMap.getMove_Map());
    }
    @DisplayName("TC05 : When click Map5 and Click Next Expected Map_lv = 5 and go to game")
    @Test
    public void TC05() throws InterruptedException {
        JFrame frame = new JFrame();
        selectMapForTest selectMap = new selectMapForTest(pacManUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(selectMap);
        frame.pack();
        frame.setVisible(true);
        selectMap.ClickMap5();
        selectMap.ClickNext();
        assertEquals(5,selectMap.getMap_lv());
        assertEquals("yes",selectMap.getMove_Map());
    }
}
