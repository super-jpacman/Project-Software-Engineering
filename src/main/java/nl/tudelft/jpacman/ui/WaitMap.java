package nl.tudelft.jpacman.ui;

<<<<<<< HEAD
    import nl.tudelft.jpacman.game.Game;

    import javax.swing.*;
    import java.awt.*;
=======
import nl.tudelft.jpacman.game.Game;

import javax.swing.*;
import java.awt.*;
>>>>>>> e7ef206e60d7843553acbc4c278de1c004d97a5f

public class WaitMap extends JPanel {
    private String path = "src/main/resources/waitmap/waitmap1.jpg";
    private Image image = new ImageIcon(path).getImage();
    public WaitMap(int currentmap) {

        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);
<<<<<<< HEAD
        path = "src/main/resources/waitmap/waitmap"+ currentmap +".jpg";
=======
        path = "src/main/resources/waitmap/waitmap"+ currentmap +".gif";
>>>>>>> e7ef206e60d7843553acbc4c278de1c004d97a5f
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
<<<<<<< HEAD
=======

>>>>>>> e7ef206e60d7843553acbc4c278de1c004d97a5f
