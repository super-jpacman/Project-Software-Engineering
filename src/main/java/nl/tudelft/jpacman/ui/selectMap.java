package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;

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
    private String path = "src/main/resources/sm.gif";
    private String[] Map_Title = {"Map1 Desc"
        ,"Map2 Desc"
        ,"Map3 Desc"
        ,"Map4 Desc"
        ,"Let's play Pacman Original!"};

    private String[] Theme = {"Christmas"
        ,"Easter Egg"
        ,"Halloween"
        ,"Valentine"
        ,"Original"};
    private String[] BG = {"src\\main\\resources\\img\\1.jpg",
        "src\\main\\resources\\img\\2.jpg",
        "src\\main\\resources\\img\\3.jpg",
        "src\\main\\resources\\img\\4.jpg",
        "src\\main\\resources\\img\\5.jpg"};

    private Image image = new ImageIcon(path).getImage();
    private JButton Map1;
    private JButton Map2;
    private PacManUI PM;
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


    public int getMap_lv() {
        return Map_lv;
    }
    public void ClickMap1(){
        Map1.doClick();
    }
    public void ClickMap2(){
        Map2.doClick();
    }
    public void ClickMap3(){
        Map3.doClick();
    }
    public void ClickMap4(){
        Map4.doClick();
    }
    public void ClickMap5(){
        Map5.doClick();
    }
    public void ClickBack(){
        BACK.doClick();
    }
    public void ClickNext(){
        NEXT.doClick();
    }


    private int Map_lv=1;
    private JLabel img_map;

    private JLabel Title;
    private JLabel Detail;
    private static final int SQUARE_SIZE = 16;
    private boolean map1_click_state = true;
    private boolean map2_click_state = false;
    private boolean map3_click_state = false;
    private boolean map4_click_state = false;
    private boolean map5_click_state = false;
    // default constructor
    public selectMap(PacManUI PM)
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
        this.PM = PM;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        img_map = new JLabel();
        Header=new JLabel("Header");
        Detail=new JLabel("Detail");
        Title=new JLabel("Title");
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        // SETTING IMAGE SELECT
        img_map.setBounds(125, 82, 220, 160);
        img_map.setBackground(Color.white);
        img_map.setOpaque(true);
        img_map.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\1.jpg");
        img_map.setIcon(icon);

        // END SETTING

        Header.setText("Select Map");
        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,20));
        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(86, 10, 600, 40);

        //Title
        Title.setText(Map_Title[0]);
        Title.setForeground(new Color(0xFFFFFF));
        Title.setFont(new Font("Emulogic",Font.BOLD,14));
        Title.setIconTextGap(-60);
        Title.setBackground(new Color(1f,0f,0f,0f ));
        Title.setOpaque(true);
        Title.setBounds(125, 200, 200, 40);
        //Theme
        Detail.setText("Theme : "+ Theme[0]);
        Detail.setForeground(Color.white);
        Detail.setFont(new Font("Emulogic",Font.BOLD,11));
        Detail.setIconTextGap(-60);
        Detail.setBackground(new Color(1f,0f,0f,0f ));
        Detail.setOpaque(true);
        Detail.setBounds(125, 235, 300, 40);

        Map5=new JButton();
        Map5.setLayout(new FlowLayout());
        Map5.setText("<html><div style='text-align: center;'>MAP 5</html>");
        Map5.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map5.setFocusPainted(false);
        Map5.setBackground(Color.black);
        Map5.setForeground(Color.white);
        Map5.setBorder(null);
//        Map5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map5.setBounds(20, 220, 70, 30);
//        NEXT.setBorder(new RoundedButton(10));
        Map5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                img_map.setBackground(Color.GREEN);
                Map5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                PM.setResizable(false);
                Map_lv=5;
                Title.setText(Map_Title[4]);
                Detail.setText("Theme : "+Theme[4]);
                Detail.setForeground(Color.YELLOW);
                setImageBackground(BG[4]);

                map5_click_state = true;
                map4_click_state = false;
                map3_click_state = false;
                map2_click_state = false;
                map1_click_state = false;

            }
        });
        Map5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (map5_click_state) {
                    Map5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                }    else {
                    Map5.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!map5_click_state)
                    Map5.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));

            }
        });

        Map4=new JButton();
        Map4.setLayout(new FlowLayout());
        Map4.setText("<html><div style='text-align: center;'>MAP 4</html>");
        Map4.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map4.setFocusPainted(false);
        Map4.setBackground(Color.black);
        Map4.setForeground(Color.white);
        Map4.setBorder(null);
//        Map4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map4.setBounds(20, 185, 70, 30);
//        NEXT.setBorder(new RoundedButton(10));
        Map4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                img_map.setBackground(Color.BLUE);
                Map4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                PM.setResizable(false);
                Map_lv=4;
                Title.setText(Map_Title[3]);
                setImageBackground(BG[3]);
                Detail.setForeground(Color.PINK);
                Detail.setText("Theme : "+Theme[3]);

                map5_click_state = false;
                map4_click_state = true;
                map3_click_state = false;
                map2_click_state = false;
                map1_click_state = false;

            }
        });
        Map4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (map4_click_state) {
                    Map4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                }    else {
                    Map4.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!map4_click_state)
                    Map4.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));

            }
        });

        Map3=new JButton();
        Map3.setLayout(new FlowLayout());
        Map3.setText("<html><div style='text-align: center;'>MAP 3</html>");
        Map3.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map3.setFocusPainted(false);
        Map3.setBackground(Color.black);
        Map3.setForeground(Color.white);
        Map3.setBorder(null);

//        Map3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map3.setBounds(20, 150, 70, 30);
//        BACK.setBorder(new RoundedButton(10));
        Map3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
                img_map.setBackground(Color.CYAN);
                PM.setResizable(false);
                Map_lv=3;
                Title.setText(Map_Title[2]);
                setImageBackground(BG[2]);
                Detail.setForeground(Color.ORANGE);
                Detail.setText("Theme : "+Theme[2]);

                map5_click_state = false;
                map4_click_state = false;
                map3_click_state = true;
                map2_click_state = false;
                map1_click_state = false;

            }
        });
        Map3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (map3_click_state) {
                    Map3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                }    else {
                    Map3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!map3_click_state)
                    Map3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));

            }
        });

        Map1=new JButton();
        Map1.setLayout(new FlowLayout());
        Map1.setText("<html><div style='text-align: center;'>MAP 1</html>");
        Map1.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map1.setFocusPainted(false);
        Map1.setBackground(Color.black);
        Map1.setForeground(Color.white);
        Map1.setBorder(null);
        Map1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        Map1.setBounds(20, 80, 70, 30);
//        Play.setBorder(new RoundedButton(10));
        Map1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                img_map.setBackground(Color.white);
                PM.setResizable(false);
                Map_lv=1;
                Detail.setText("Theme : "+Theme[0]);
                setImageBackground(BG[0]);
                Detail.setForeground(Color.white);
                Title.setText(Map_Title[0]);

                map5_click_state = false;
                map4_click_state = false;
                map3_click_state = false;
                map2_click_state = false;
                map1_click_state = true;

            }
        });
        Map1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (map1_click_state) {
                    Map1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                }    else {
                    Map1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!map1_click_state)
                    Map1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));

            }
        });

        Map2=new JButton();
        Map2.setLayout(new FlowLayout());
        Map2.setText("<html><div style='text-align: center;'>MAP 2</html>");
        Map2.setFont(new Font("Emulogic",Font.PLAIN,12));
        Map2.setFocusPainted(false);
        Map2.setBackground(Color.black);
        Map2.setForeground(Color.white);
        Map2.setBorder(null);
        Map2.setBounds(20, 115, 70, 30);
//        Play.setBorder(new RoundedButton(10));
        Map2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                closeAllBTN();
                Map2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

                System.out.println(PM.getGame().getPlayers().get(0).getSprite());
                System.out.println(PM.getGame().getPlayers().get(0).getSprites());
                img_map.setBackground(Color.PINK);
                PM.setResizable(false);
                Map_lv=2;
                Detail.setText("Theme : "+Theme[1]);
                Title.setText(Map_Title[1]);
                Detail.setForeground(Color.GREEN);
                setImageBackground(BG[1]);

                map5_click_state = false;
                map4_click_state = false;
                map3_click_state = false;
                map2_click_state = true;
                map1_click_state = false;

            }
        });
        Map2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (map2_click_state) {
                    Map2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
                }    else {
                    Map2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!map2_click_state)
                    Map2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));

            }
        });

        NEXT=new JButton();
        NEXT.setLayout(new FlowLayout());
        NEXT.setText("<html><div style='text-align: center;'>NEXT</html>");
        NEXT.setFont(new Font("Emulogic",Font.PLAIN,14));
        NEXT.setFocusPainted(false);
        NEXT.setBackground(Color.black);
        NEXT.setForeground(Color.white);
        NEXT.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        NEXT.setBounds(260, 290, 70, 30);
//        NEXT.setBorder(new RoundedButton(10));
        NEXT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                NEXT.setBackground(Color.white);
                NEXT.setForeground(Color.BLACK);
                NEXT.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));

                PM.setResizable(false);
                set_THEME(Map_lv);
                Move_Map(Map_lv,PM);
            }
        });
        NEXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NEXT.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.YELLOW));
                NEXT.setForeground(Color.YELLOW);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NEXT.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                NEXT.setForeground(Color.WHITE);
            }
        });


        BACK=new JButton();
        BACK.setLayout(new FlowLayout());
        BACK.setText("<html><div style='text-align: center;'>BACK</html>");
        BACK.setFont(new Font("Emulogic",Font.PLAIN,12));
        BACK.setFocusPainted(false);
        BACK.setBackground(Color.black);
        BACK.setForeground(Color.white);
        BACK.setBorder(null);
        BACK.setBounds(10, 290, 70, 30);
//        BACK.setBorder(new RoundedButton(10));
        BACK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                BACK.setBackground(Color.white);
                BACK.setForeground(Color.BLACK);
                BACK.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
                System.out.println("PASS BACK");
                PM.setResizable(false);
                PM.GAME_MODE();

            }
        });
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BACK.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
                BACK.setFont(new Font("Emulogic",Font.PLAIN,15));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BACK.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
                BACK.setFont(new Font("Emulogic",Font.PLAIN,12));
            }
        });

        background.add(NEXT);
        background.add(BACK);
        background.add(img_map);
//        background.add(Title);
        background.add(Detail);
//        background.add(Header);
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

    public void Move_Map(int map,PacManUI PM) {
        this.PM=PM;
        Launcher.GAME_THEME_NOW=map;
        this.PM.LoadingPage(map);
//        this.PM.PLAY_AT_MAP(map);
    }
    public void closeAllBTN(){
        Map1.setBorder(null);
        Map2.setBorder(null);
        Map3.setBorder(null);
        Map4.setBorder(null);
        Map5.setBorder(null);
    }
    public void set_THEME(int i){
        Launcher.GAME_THEME_NOW=i;
        Launcher.setTheme();
        PM.getGame().setSkin_Pac();
    }

    public void setImageBackground(String i){
        ImageIcon newIcon = new ImageIcon(i);
        img_map.setIcon(newIcon);
    }

}

