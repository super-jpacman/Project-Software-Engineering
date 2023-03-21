
package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
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
    private String path = "src/main/resources/gm.gif";
    String[] Desc_Text = {"<html><div style='text-align: center;'>Ranking Mode will recorded your score and compete on the leader board</html>"
        ,"<html><div style='text-align: center;'>You can select map that you want to play in Casual Mode and your will not record</html>"};
    private JLabel Desc;

    private Image image = new ImageIcon(path).getImage();
    private JButton CasualMode;
    private JButton RankingMode;

    private JButton BACK;

    private String Text_Header;
    private Game game;
    private JLabel Header;
    private int Text_Score;
    private boolean enable;
    private static final int SQUARE_SIZE = 16;
    public void ClickBack(){
        BACK.doClick();
    }
    public void ClickCasual(){
        CasualMode.doClick();
    }
    public void ClickRanking(){
        RankingMode.doClick();
    }

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

        this.Text_Header=Text_Header;
        this.Text_Score=Text_Score;

        Desc = new JLabel("Description");


        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        Header=new JLabel("Header");
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        Header.setText("Game Mode");
        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,20));
        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(90, 10, 600, 40);

        Desc.setText("");

        Desc.setForeground(Color.YELLOW);
        Desc.setFont(new Font("Emulogic",Font.PLAIN,10));
        Desc.setIconTextGap(-60);
        Desc.setBackground(new Color(1f,0f,0f,0f ));
        Desc.setOpaque(false);
        Desc.setBounds(35, 90, 300, 70);

        BACK=new JButton();
        BACK.setLayout(new FlowLayout());
        BACK.setText("<html><div style='text-align: center;'>BACK</html>");
        BACK.setFont(new Font("Emulogic",Font.PLAIN,12));
        BACK.setFocusPainted(false);
        BACK.setBackground(Color.black);
        BACK.setForeground(Color.white);
        BACK.setBorder(null);
        BACK.setBounds(10, 290, 70, 30);
//
        BACK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                BACK.setBackground(Color.white);
                BACK.setForeground(Color.BLACK);
                BACK.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
                PM.MainMenuUI();
            }
        });
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BACK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                BACK.setFont(new Font("Emulogic",Font.PLAIN,14));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BACK.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                BACK.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        CasualMode=new JButton();
        CasualMode.setLayout(new FlowLayout());
        CasualMode.setText("<html><div style='text-align: center;'>Casual!</html>");
        CasualMode.setFont(new Font("Emulogic",Font.PLAIN,12));
        CasualMode.setFocusPainted(false);
        CasualMode.setBackground(Color.black);
        CasualMode.setForeground(Color.white);
        CasualMode.setBorder(null);
        CasualMode.setBounds(140, 180, 100, 30);
        CasualMode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                CasualMode.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                PM.GAMAE_CASUAL();
            }
        });
        CasualMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Desc.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                Desc.setText(Desc_Text[1]);
                CasualMode.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                CasualMode.setFont(new Font("Emulogic",Font.PLAIN,14));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Desc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                Desc.setText("");
                CasualMode.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                CasualMode.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        RankingMode=new JButton();

        RankingMode.setLayout(new FlowLayout());
        RankingMode.setText("<html><div style='text-align: center;'>Ranking!!</html>");
        RankingMode.setFont(new Font("Emulogic",Font.PLAIN,12));
        RankingMode.setFocusPainted(false);
        RankingMode.setBackground(Color.black);
        RankingMode.setForeground(Color.white);
        RankingMode.setBorder(null);
        RankingMode.setBounds(140, 220, 100, 30);
        RankingMode.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                RankingMode.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                PM.getGame().getLevel().setInProgress(false);
                PM.getGame().getLevel().updateObservers();
                PM.getGame().getLevel().start();
                PM.getGame().getLevel().stop();
//                PM.getGame().restart();
                Launcher.GAME_MODE_NOW="";
                PM.GAMAE_RANKING();
            }
        });
        RankingMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                Desc.setText(Desc_Text[0]);
                Desc.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                RankingMode.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                RankingMode.setFont(new Font("Emulogic",Font.PLAIN,14));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Desc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                Desc.setText("");
                RankingMode.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                RankingMode.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        background.add(BACK);
//        background.add(Header);
        background.add(RankingMode);
        background.add(CasualMode);
        background.add(Desc);
        setVisible(true);
        PM.setResizable(false);
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

