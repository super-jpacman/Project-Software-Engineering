package nl.tudelft.jpacman.ui;

    import nl.tudelft.jpacman.game.Game;

    import javax.swing.*;
    import javax.swing.border.Border;
    import javax.swing.text.AttributeSet;
    import javax.swing.text.BadLocationException;
    import javax.swing.text.PlainDocument;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.geom.Area;
    import java.awt.geom.Rectangle2D;
    import java.awt.geom.RoundRectangle2D;
    import java.io.File;
    import java.io.IOException;
    import java.util.Objects;

public class Tranfer extends JPanel {
    private String path = "src/main/resources/main.jpg";
    private Image image = new ImageIcon(path).getImage();
    private String Text_Header;
    private int Text_Score;

    // default constructor
    public Tranfer(int i) {
        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);
    }}
