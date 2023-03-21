package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.points.SaveScore;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GameEnd extends JPanel {
    private String path = "src/main/resources/end.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton BackBTN;
    private JLabel Header;
    private JLabel Score;
    private JTextField name;
    private String Text_Header;
    private int Text_Score;
    private boolean enable;
    public GameEnd(){}
    // default constructor
    public GameEnd(String Text_Header,int Text_Score,double totalTime,PacManUI PM)
    {
        Dimension size = new Dimension(368, 336);
        setSize(size);
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

        this.Text_Header=Text_Header;
        this.Text_Score=Text_Score;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
//        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
        add(background);

        Header=new JLabel("Header");
        BackBTN=new JButton();
        Score=new JLabel("Score");
        name = new HintTextField("                     Enter your name");


        Header.setText(Text_Header);

        Header.setForeground(new Color(0xFFFFFF));
        Header.setFont(new Font("Emulogic",Font.BOLD,50));

        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(0, 20, 600, 40);

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
        Score.setBounds(140, 90, 420, 30);

        name.setLayout(new FlowLayout());
        name.setSize(100,50);
        name.setBounds(180,260,230,30);
        name.setBorder(null);
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setDocument(new LengthRestrictedDocument(16));
//        name.setCaretColor(Color.WHITE);

        BackBTN.setLayout(new FlowLayout());
        BackBTN.setText("SAVE");
        BackBTN.setFocusPainted(false);
        BackBTN.setBounds(250, 310, 100, 30);
        BackBTN.setBorder(new RoundedButton(10));
        BackBTN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                if(!name.getText().isEmpty()){
                    new SaveScore(name.getText(),totalTime,Text_Score);
                    Launcher.GAME_MODE_NOW="RANK";
                    PM.MainMenuUI();

                }else if(name.getText().length()>16) {
                    JOptionPane.showMessageDialog(new JFrame(), "Length must less than 16");

                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Enter Your Name!");
                }
            }
        });
        background.add(Header);
        background.add(Score);
        background.add(name);
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
    public void SetName(String name){
        this.name.replaceSelection(name);
    }
    public void SetOnClick(){
        assert BackBTN != null;
        BackBTN.doClick();
    }

    public void showData(){
        System.out.println("BackBTN : "+BackBTN);
        System.out.println("Name : "+name);
        System.out.println("Text_Header : "+Text_Header);
        System.out.println("Text_Score : "+Text_Score);
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}

