package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen 
 */
class ButtonPanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<JButton> btn = new ArrayList<JButton>();

    public int getCount() {
        return count;
    }
    private PacManUI PM;
    public void setCount(int count) {
        this.count = count;
    }

    private int count =0;
    /**
     * Create a new button panel with a button for every action.
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */
    ButtonPanel(Map<String, Action> buttons,JFrame parent,PacManUI PM) {
        super();
        this.PM = PM;
        assert buttons != null;
        assert parent != null;
        count =0;
        setLayout(new GridLayout(1,4,50,50));
        for (final String caption : buttons.keySet()) {
            JButton JB = new JButton(caption);
            JB.setBackground(Color.black);
            JB.setForeground(Color.white);
            JB.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
            btn.add(JB);

            btn.get(count).addActionListener(e -> {
//                System.out.println(count+"GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"+Launcher.MODAL);
//                if(count == 2){
//                    Launcher.MODAL = false;
//                    PM.getGame().restart();
//                    System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//                }
//                if(!Launcher.MODAL){
                    try {
                        buttons.get(caption).doAction();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
//                }

                parent.requestFocusInWindow();
            });
            add(btn.get(count));
            count++;
        }
        this.setBackground(Color.black);
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
