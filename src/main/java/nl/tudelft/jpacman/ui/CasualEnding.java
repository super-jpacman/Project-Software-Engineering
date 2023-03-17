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
import java.io.IOException;
import java.util.Objects;

public class CasualEnding extends JPanel {
    private String path = "src/main/resources/end2.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton BackBTN;
    private JLabel Header;
    private JLabel Score;
    private String Text_Header;
    private Game game;
    private int Text_Score;
    private boolean enable;
    private static final int SQUARE_SIZE = 16;
    public CasualEnding(){}
    // default constructor
    public CasualEnding(String Text_Header, int Text_Score, double totalTime)
    {
        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);

        this.Text_Header=Text_Header;
        this.Text_Score=Text_Score;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        Header=new JLabel("Header");
        BackBTN=new JButton();
        Score=new JLabel("Score");


        Header.setText(Text_Header);

        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,50));

        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(60, 20, 600, 40);

        Score.setLayout(new FlowLayout());
        Score.setText("Score "+String.valueOf(Text_Score));
        Score.setHorizontalTextPosition(JLabel.CENTER);
        Score.setVerticalTextPosition(JLabel.TOP);
        Score.setAlignmentX(JLabel.CENTER);

        Score.setForeground(new Color(0xFFFFFF));
        Score.setFont(new Font("Emulogic",Font.PLAIN,32));

        Score.setIconTextGap(-60);
        Score.setBackground(new Color(1f,0f,0f,0f ));
        Score.setOpaque(true);
        Score.setBounds(110, 90, 420, 30);

        BackBTN.setLayout(new FlowLayout());
        BackBTN.setText("BACK");
        BackBTN.setFocusPainted(false);
        BackBTN.setBounds(130, 280, 100, 30);
        BackBTN.setBorder(new RoundedButton(10));
        BackBTN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PASS BACK");

            }
        });
        background.add(Header);
        background.add(Score);
        background.add(BackBTN);
        setVisible(true);

    }
    class RoundedButton implements Border {
        private int roundRadius;

        RoundedButton(int roundRadius) {
            this.roundRadius = roundRadius;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int r = roundRadius;
            int w = width - 1;
            int h = height - 1;

            Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
            Container parent = c.getParent();
            if (Objects.nonNull(parent)) {
                g2.setPaint(parent.getBackground());
                Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
                corner.subtract(round);
                g2.setColor(Color.black);
                g2.fill(corner);
            }
            g2.draw(round);
            g2.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.roundRadius + 1, this.roundRadius + 1, this.roundRadius + 2, this.roundRadius + 2);
        }


        public boolean isBorderOpaque() {
            return true;
        }
    }
    public final class LengthRestrictedDocument extends PlainDocument {

        private final int limit;

        public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offs, str, a);
            }
        }
    }

    public class HintTextField extends JTextField {
        public HintTextField(String hint) {
            _hint = hint;
        }
        @Override public void setBorder(Border border) {
            // No!
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getText().length() == 0) {
                int h = getHeight();
                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Insets ins = getInsets();
                FontMetrics fm = g.getFontMetrics();
                int c0 = getBackground().getRGB();
                int c1 = getForeground().getRGB();
                int m = 0xfefefefe;
                int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
                g.setColor(new Color(c2, true));
                g.drawString(_hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }
        }
        private final String _hint;
    }
    public void SetOnClick(){
        assert BackBTN != null;
        BackBTN.doClick();
    }

    public void showData(){
        System.out.println("BackBTN : "+BackBTN);
        System.out.println("Text_Header : "+Text_Header);
        System.out.println("Text_Score : "+Text_Score);
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

//    public static void main(String[] args) throws IOException {
//        JFrame j = new JFrame();
//        Container contentPanel = j.getContentPane();
//        contentPanel.setLayout(new BorderLayout());
//
//        contentPanel.add(new CasualEnding("Test",999,12));
//        j.setSize(590,400);
//        j.setVisible(true);
//    }
}
