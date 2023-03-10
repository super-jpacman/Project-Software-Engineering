package nl.tudelft.jpacman.ui;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen 
 */
public class ButtonPanel extends JPanel {

    private ArrayList<Boolean> clicked = new ArrayList<Boolean>();
    private static final long serialVersionUID = 1L;
    private ArrayList<JButton> btn = new ArrayList<JButton>();
    private int count;
    /**
     * Create a new button panel with a button for every action.
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */
    ButtonPanel(Map<String, Action> buttons, final JFrame parent) {
        super();

        assert buttons != null;
        assert parent != null;
        count =0;
        for (final String caption : buttons.keySet()) {
            btn.add(new JButton(caption));
            btn.get(count).addActionListener(e -> {

                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });

            add(btn.get(count));
            count++;
        }
    }
    public void ClickStart(){
        assert btn.get(0) != null;
        btn.get(0).doClick();
    }
    public void ClickStop(){
        assert btn.get(1) != null;
        btn.get(1).doClick();
    }
    public void ClickRestart(){
        assert btn.get(2) != null;
        btn.get(2).doClick();
    }
}
