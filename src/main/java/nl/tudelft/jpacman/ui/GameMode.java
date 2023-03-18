
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

public class GameMode extends JPanel {
    private String path = "src/main/resources/main2.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton CasualMode;
    private JButton RankingMode;
    String[] Desc_Text = {"This is Ranking Mode","This is Casual Mode"};
    private JButton BACK;
    private JLabel Header;
    private JLabel Desc;


    // default constructor
    public GameMode(PacManUI PM)
    {
        try {
            GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/Emulogic-zrEw.ttf")));
            GraphicsEnvironment gf =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            gf.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/LexendTera-Medium.ttf")));
            GraphicsEnvironment gg =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            gg.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/font/PacfontGood-yYye.ttf")));
        } catch (FontFormatException | IOException e) {
            //Handle exception
        }
        Dimension size = new Dimension(368, 336);
        setMinimumSize(size);

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        Header=new JLabel("Header");
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        Desc = new JLabel("Description");

        Header.setText("Game Mode");
        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,20));
        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(90, 10, 600, 40);

        Desc.setText("");
        Desc.setForeground(new Color(0xFFFFFF));
        Desc.setFont(new Font("Emulogic",Font.PLAIN,12));
        Desc.setIconTextGap(-60);
        Desc.setBackground(new Color(1f,0f,0f,0f ));
        Desc.setOpaque(false);
        Desc.setBounds(70, 70, 600, 40);

        BACK=new JButton();
        BACK.setLayout(new FlowLayout());
        BACK.setText("BACK");
        BACK.setFont(new Font("Emulogic",Font.PLAIN,12));
        BACK.setFocusPainted(false);
        BACK.setBackground(Color.black);
        BACK.setForeground(Color.white);
        BACK.setBorder(null);
        BACK.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        BACK.setBounds(10, 290, 100, 30);
//        BACK.setBorder(new RoundedButton(10));
        BACK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                BACK.setBackground(Color.white);
                BACK.setForeground(Color.BLACK);
                BACK.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));

                System.out.println("PASS BACK");
                PM.MainMenuUI();
            }
        });

        CasualMode=new JButton();
        CasualMode.setLayout(new FlowLayout());
        CasualMode.setText("Casual!");
        CasualMode.setFont(new Font("Emulogic",Font.PLAIN,12));
        CasualMode.setFocusPainted(false);
        CasualMode.setBackground(Color.black);
        CasualMode.setForeground(Color.white);
        CasualMode.setBorder(null);
        CasualMode.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        CasualMode.setBounds(130, 200, 100, 30);
//        Play.setBorder(new RoundedButton(10));
        CasualMode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PASS CasualMode");
                PM.GAMAE_CASUAL();
            }
        });
        CasualMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Desc.setText(Desc_Text[1]);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Desc.setText("");
            }
        });

        RankingMode=new JButton();

        RankingMode.setLayout(new FlowLayout());
        RankingMode.setText("Ranking");
        RankingMode.setFont(new Font("Emulogic",Font.PLAIN,12));
        RankingMode.setFocusPainted(false);
        RankingMode.setBackground(Color.black);
        RankingMode.setForeground(Color.white);
        RankingMode.setBorder(null);
        RankingMode.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        RankingMode.setBounds(130, 160, 100, 30);
//        Play.setBorder(new RoundedButton(10));
        RankingMode.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PASS RankingMode");
                PM.GAMAE_RANKING();
            }
        });
        RankingMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Desc.setText(Desc_Text[0]);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Desc.setText("");
            }
        });

        background.add(BACK);
        background.add(Header);
        background.add(RankingMode);
        background.add(CasualMode);
        background.add(Desc);
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



//    public static void main(String[] args) throws IOException {
//        JFrame j = new JFrame();
//        Container contentPanel = j.getContentPane();
//        contentPanel.setLayout(new BorderLayout());
//
//        contentPanel.add(new FirstMenu());
//        j.setSize(368,336);
//        j.setVisible(true);
//    }
}

