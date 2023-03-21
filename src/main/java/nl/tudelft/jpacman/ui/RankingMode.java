package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.MultiLevelLauncher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.points.SaveScore;

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

public class RankingMode extends JPanel {
    private String path = "src/main/resources/rm.gif";
    private Image image = new ImageIcon(path).getImage();
    private JButton Start;
    private JButton Leaderboard;
    private JButton back;
    private JLabel Ranking;
    private String Text_Header;
    private Game game;
    private int Text_Score;
    private boolean enable;
    private static final int SQUARE_SIZE = 16;
    public void ClickStart(){
        Start.doClick();
    }
    public void ClickLeaderboard(){
        Leaderboard.doClick();
    }
    public void ClickBack(){
        back.doClick();
    }
    public RankingMode(PacManUI PM) {
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
        this.Text_Header = Text_Header;
        this.Text_Score = Text_Score;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        add(background);
        Ranking=new JLabel("Ranking Mode");
        Ranking.setText("Ranking Mode");
        Ranking.setForeground(new Color(0xFFFFFF));
//        Ranking.setHorizontalTextPosition(JLabel.CENTER);
//        Ranking.setVerticalTextPosition(JLabel.TOP);
//        Ranking.setAlignmentX(JLabel.CENTER);
        Ranking.setFont(new Font("Emulogic",Font.BOLD,20));
        Ranking.setIconTextGap(-60);
        Ranking.setBackground(new Color(1f,0f,0f,0f ));
        Ranking.setOpaque(true);
//        Ranking.setBackground(Color.black);
//        Ranking.setForeground(Color.white);
//        Ranking.setBounds(75, 0, 300, 30);
        Ranking.setBounds(65, 10, 600, 40);

        Start=new JButton();

        Start.setLayout(new FlowLayout());
        Start.setText("Start");
        Start.setFont(new Font("Emulogic",Font.PLAIN,12));
        Start.setFocusPainted(false);
        Start.setBackground(Color.black);
        Start.setForeground(Color.white);
        Start.setBorder(null);
        Start.setBounds(135, 140, 100, 30);
//        Play.setBorder(new RoundedButton(10));
        Start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PASS Start");
                Launcher.GAME_MODE_NOW="RANK";
                System.out.println("Launcher GAME MODE : "+ Launcher.GAME_MODE_NOW);
                System.out.println("Launcher GAME MODE : "+ PM.getGame().getPlayers().get(0).getMap());
                Launcher.GAME_THEME_NOW=PM.getGame().getPlayers().get(0).getMap();
                Launcher.setTheme();
                PM.getGame().setSkin_Pac();
                PM.LoadingPage(PM.getGame().getPlayers().get(0).getMap());
            }
        });
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Start.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                Start.setFont(new Font("Emulogic",Font.PLAIN,15));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Start.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                Start.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        Leaderboard=new JButton();

        Leaderboard.setLayout(new FlowLayout());
        Leaderboard.setText("Leaderboard");
        Leaderboard.setFont(new Font("Emulogic",Font.PLAIN,12));
        Leaderboard.setFocusPainted(false);
        Leaderboard.setBackground(Color.black);
        Leaderboard.setForeground(Color.white);
        Leaderboard.setBorder(null);
        Leaderboard.setBounds(86, 190, 200, 30);
//        Play.setBorder(new RoundedButton(10));
        Leaderboard.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PASS Leaderboard");
                PM.RANKING_BOARD();
            }
        });
        Leaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Leaderboard.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                Leaderboard.setFont(new Font("Emulogic",Font.PLAIN,15));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Leaderboard.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                Leaderboard.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });
        back=new JButton();

        back.setLayout(new FlowLayout());
        back.setText("<html><div style='text-align: center;'>BACK</html>");
        back.setFont(new Font("Emulogic",Font.PLAIN,12));
        back.setFocusPainted(false);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorder(null);
        back.setBounds(10, 290, 70, 30);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                PM.GAME_MODE();
            }
        });
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                back.setFont(new Font("Emulogic",Font.PLAIN,15));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                back.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                back.setFont(new Font("Emulogic",Font.PLAIN,14));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                back.setFont(new Font("Emulogic",Font.PLAIN,11));
            }
        });
//        background.add(Ranking);
        background.add(Start);
        background.add(Leaderboard);
        background.add(back);
        setVisible(true);
        PM.setResizable(false);
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
//        contentPanel.add(new RankingMode());
//        j.setSize(368,336);
//        j.setVisible(true);
//    }
}
