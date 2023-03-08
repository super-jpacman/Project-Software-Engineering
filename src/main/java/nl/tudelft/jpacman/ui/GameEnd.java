package nl.tudelft.jpacman.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class GameEnd extends JFrame {
    private String path = "src/main/resources/end.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton BackBTN;
    private JLabel Header;
    private JLabel Score;
    private JTextField name;
    private String Text_Header;
    private int Text_Score;

    public GameEnd(){}
    // default constructor
    public GameEnd(String Text_Header,int Text_Score)
    {

        this.Text_Header=Text_Header;
        this.Text_Score=Text_Score;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        background.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        add(background);

        Header=new JLabel("Header");
        BackBTN=new JButton();
        Score=new JLabel("Score");
        name = new HintTextField(" Enter your name");


        Header.setText(Text_Header);
        Header.setForeground(new Color(0x00FF00));
        Header.setFont(new Font("MV Boli",Font.BOLD,50));
        Header.setIconTextGap(-60);
        Header.setBackground(new Color(1f,0f,0f,0f ));
        Header.setOpaque(true);
        Header.setBounds(155, 20, 300, 60);

        Score.setLayout(new FlowLayout());
        Score.setText("Score "+String.valueOf(Text_Score)+" Point");
        Score.setHorizontalTextPosition(JLabel.CENTER);
        Score.setVerticalTextPosition(JLabel.TOP);
        Score.setAlignmentX(JLabel.CENTER);
        Score.setForeground(new Color(0x00FF00));
        Score.setFont(new Font("MV Boli",Font.PLAIN,32));
        Score.setIconTextGap(-60);
        Score.setBackground(new Color(1f,0f,0f,0f ));
        Score.setOpaque(true);
        Score.setBounds(168, 100, 300, 40);

        name.setLayout(new FlowLayout());
        name.setSize(100,50);
        name.setBounds(180,260,230,30);
        name.setBorder(null);

        BackBTN.setLayout(new FlowLayout());
        BackBTN.setText("BACK");
        BackBTN.setFocusPainted(false);
        BackBTN.setBounds(250, 310, 100, 30);
        BackBTN.setBorder(new RoundedButton(10));


        BackBTN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                System.out.println(name.getText());
            }
        });
        background.add(Header);
        background.add(Score);
        background.add(name);
        background.add(BackBTN);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        pack();
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
    public static void main(String[] args){
        new GameEnd("You Lose !!",999);
    }
}
