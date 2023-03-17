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

public class selectMap extends JPanel {
    private String path = "src/main/resources/main.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton Map1;
    private JButton Map2;

    private JButton Map3;
    private JButton Map4;

    private JButton Map5;

    private JButton BACK;
    private JButton NEXT;
    private String Text_Header;
    private Game game;
    private int Text_Score;
    private boolean enable;
    private JLabel Header;

    private JLabel img_map;
    private JLabel Title;
    private JLabel Detail;
    private static final int SQUARE_SIZE = 16;

    // default constructor
    public selectMap()
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
        img_map = new JLabel();
        Header=new JLabel("Header");
        Detail=new JLabel("Detail");
        Title=new JLabel("Title");
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        // SETTING IMAGE SELECT
        img_map.setBounds(125, 62, 200, 120);
        img_map.setBackground(Color.white);
        img_map.setOpaque(true);
        img_map.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));

        // END SETTING

        Header.setText("Select Map");
        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,20));
        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(86, 10, 600, 40);

        //Title
        Title.setText("Map Story");
        Title.setForeground(new Color(0xFFFFFF));
        Title.setFont(new Font("Emulogic",Font.BOLD,14));
        Title.setIconTextGap(-60);
        Title.setBackground(new Color(1f,0f,0f,0f ));
        Title.setOpaque(true);
        Title.setBounds(155, 190, 600, 40);
        //Theme
        String theme = "Christmas";
        Detail.setText("Theme : "+ theme);
        Detail.setForeground(new Color(0xFFFFFF));
        Detail.setFont(new Font("Emulogic",Font.BOLD,10));
        Detail.setIconTextGap(-60);
        Detail.setBackground(new Color(1f,0f,0f,0f ));
        Detail.setOpaque(true);
        Detail.setBounds(135, 220, 600, 40);

        Map5=new JButton();
        Map5.setLayout(new FlowLayout());
        Map5.setText("Map5");
        Map5.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map5.setFocusPainted(false);
        Map5.setBackground(Color.black);
        Map5.setForeground(Color.white);
        Map5.setBorder(null);
//        Map5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map5.setBounds(20, 200, 70, 30);
//        NEXT.setBorder(new RoundedButton(10));
        Map5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                img_map.setBackground(Color.GREEN);
                Map5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                System.out.println("PASS Map5");
            }
        });

        Map4=new JButton();
        Map4.setLayout(new FlowLayout());
        Map4.setText("Map4");
        Map4.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map4.setFocusPainted(false);
        Map4.setBackground(Color.black);
        Map4.setForeground(Color.white);
        Map4.setBorder(null);
//        Map4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map4.setBounds(20, 165, 70, 30);
//        NEXT.setBorder(new RoundedButton(10));
        Map4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                img_map.setBackground(Color.BLUE);
                Map4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                System.out.println("PASS Map4");
            }
        });

        Map3=new JButton();
        Map3.setLayout(new FlowLayout());
        Map3.setText("Map3");
        Map3.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map3.setFocusPainted(false);
        Map3.setBackground(Color.black);
        Map3.setForeground(Color.white);
        Map3.setBorder(null);
//        Map3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map3.setBounds(20, 130, 70, 30);
//        BACK.setBorder(new RoundedButton(10));
        Map3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                img_map.setBackground(Color.CYAN);
                System.out.println("PASS Map3");
            }
        });

        Map1=new JButton();
        Map1.setLayout(new FlowLayout());
        Map1.setText("Map1");
        Map1.setFont(new Font("Emulogic",Font.PLAIN,10));
        Map1.setFocusPainted(false);
        Map1.setBackground(Color.black);
        Map1.setForeground(Color.white);
        Map1.setBorder(null);
//        Map1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map1.setBounds(20, 60, 70, 30);
//        Play.setBorder(new RoundedButton(10));
        Map1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                img_map.setBackground(Color.white);
                System.out.println("PASS Map1");
            }
        });

        Map2=new JButton();

        Map2.setLayout(new FlowLayout());
        Map2.setText("Map2");
        Map2.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map2.setFocusPainted(false);
        Map2.setBackground(Color.black);
        Map2.setForeground(Color.white);
        Map2.setBorder(null);
        Map2.setBounds(20, 95, 70, 30);
//        Play.setBorder(new RoundedButton(10));
        Map2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                img_map.setBackground(Color.PINK);
                System.out.println("PASS Map2");

            }
        });

        NEXT=new JButton();
        NEXT.setLayout(new FlowLayout());
        NEXT.setText("NEXT");
        NEXT.setFont(new Font("Emulogic",Font.PLAIN,12));
        NEXT.setFocusPainted(false);
        NEXT.setBackground(Color.black);
        NEXT.setForeground(Color.white);
        NEXT.setBorder(null);
        NEXT.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        NEXT.setBounds(260, 290, 100, 30);
//        NEXT.setBorder(new RoundedButton(10));
        NEXT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                NEXT.setBackground(Color.white);
                NEXT.setForeground(Color.BLACK);
                NEXT.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));

                System.out.println("PASS NEXT");
            }
        });

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
                NEXT.setBackground(Color.white);
                NEXT.setForeground(Color.BLACK);
                NEXT.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
                System.out.println("PASS BACK");
            }
        });

        background.add(NEXT);
        background.add(BACK);
        background.add(img_map);
        background.add(Title);
        background.add(Detail);
        background.add(Header);
        background.add(Map5);
        background.add(Map4);
        background.add(Map3);
        background.add(Map2);
        background.add(Map1);
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

    public void closeAllBTN(){
        Map1.setBorder(null);
        Map2.setBorder(null);
        Map3.setBorder(null);
        Map4.setBorder(null);
        Map5.setBorder(null);
    }

    public static void main(String[] args) throws IOException {
        JFrame j = new JFrame();
        Container contentPanel = j.getContentPane();
        contentPanel.setLayout(new BorderLayout());

        contentPanel.add(new FirstMenu());
        j.setSize(368,336);
        j.setVisible(true);
    }
}

