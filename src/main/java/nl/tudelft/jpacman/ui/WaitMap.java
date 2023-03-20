package nl.tudelft.jpacman.ui;

    import nl.tudelft.jpacman.game.Game;

    import javax.swing.*;
    import java.awt.*;

public class WaitMap extends JPanel {
    private String path = "src/main/resources/waitmap/waitmap1.jpg";
    private Image image = new ImageIcon(path).getImage();
    public WaitMap(int currentmap) {

        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);
        path = "src/main/resources/waitmap/waitmap"+ currentmap +".jpg";
        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        add(background);
        System.out.println("Enter Class Waitmap");

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/

    }
}
