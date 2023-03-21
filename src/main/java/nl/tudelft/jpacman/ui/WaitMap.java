package nl.tudelft.jpacman.ui;
    import nl.tudelft.jpacman.Launcher;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;

public class WaitMap extends JPanel {
    private String path = "src/main/resources/waitmap/waitmap1.jpg";
    private Image image = new ImageIcon(path).getImage();
    public WaitMap(int currentmap,PacManUI PM) {
        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);
        System.out.println("🤩🤩🤩🤩🤩🤩🤩🤩🤩");
        path = "src/main/resources/waitmap/waitmap"+ currentmap +".gif";

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);

        System.out.println("Enter Class Waitmap");

        addMouseListener(new MouseAdapter() {
            //override the method
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("🤩🤩🤩🤩🤩LOADING PAGE🤩🤩🤩🤩");
                System.out.println("Launcher.GAME_MODE_NOW : "+ Launcher.GAME_MODE_NOW);
                System.out.println("Launcher GAME MODE : "+ PM.getContentPane());
//                background.removeAll();
                setVisible(false);
                setEnabled(false);
                removeAll();
                if (Launcher.GAME_MODE_NOW == "CASUAL")
                {
                PM.PLAY_AT_MAP(currentmap);
                } else if(Launcher.GAME_MODE_NOW == "RANK"){
                    PM.PacManUI_PLAY_RANK(PM.getGame());
                }else {}
                System.out.println("🤩🤩🤩🤩🤩🤩🤩🤩🤩");


            }
        });
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/

        add(background);
        setVisible(true);
    }

}
