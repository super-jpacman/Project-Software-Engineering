package nl.tudelft.jpacman.ui;

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

public class RankingBoard extends JPanel {
    private String path = "src/main/resources/ranking.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton Play;
    private JLabel headTable;
    private String Text_Header;
    private Game game;
    private int Text_Score;
    private boolean enable;
    private static final int SQUARE_SIZE = 16;
    private JButton BackBTN;

    // default constructor
    public RankingBoard(PacManUI PM)
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
        headTable = new JLabel();
        BackBTN=new JButton();
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);


        //head table
        String format = "%1$-5s %2$-10s %3$-10s %4$-10s\n";
        headTable.setText(String.format(format,"No.","Name","Score","Time"));
        headTable.setFont(new Font("Emulogic",Font.ITALIC,8));
        headTable.setBounds(45, 70, 323, 30);
//        headTable.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));

        //SCORE DISPLAY LIST
        String format2 = "%1$-7s %2$-16s %3$-12s %4$-10s\n";
        for (int i = 0;i<10;i++){
            JLabel list = new JLabel();
            int num = i+1;
            String name = "name "+String.valueOf(i+1);
            int point = (i+1)*10;
            String time = String.format("%d:%d",i*10,i*10);
            list.setText(String.format(format2,num,name,point,time));
            list.setFont(new Font("Emulogic",Font.ITALIC,6));
            list.setBounds(45, 90+(i*20), 323, 20);
            background.add(list);
        }

        //END DISPLAY
        Play=new JButton();
        Play.setLayout(new FlowLayout());
        Play.setText("Ranking Board");
        Play.setFont(new Font("Emulogic",Font.PLAIN,16));
        Play.setFocusPainted(false);
        Play.setBackground(Color.black);
        Play.setForeground(Color.white);
        Play.setBorder(null);
        Play.setBounds(70, 20, 220, 30);
//        Play.setBorder(new RoundedButton(10));


        BackBTN.setLayout(new FlowLayout());
        BackBTN.setText("BACK");
        BackBTN.setFocusPainted(false);
        BackBTN.setBounds(140, 295, 100, 30);
        BackBTN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println("PRESS BACK");
                PM.GAMAE_RANKING();

            }
        });
        background.add(BackBTN);
        background.add(Play);
        background.add(headTable);
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

