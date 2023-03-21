package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.game.Game;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.text.*;
import java.util.*;


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
    public void ClickBackBTN(){
        BackBTN.doClick();
    }

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

        Comparator<JSONObject> jsonObjectComparator = new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                int point1 = Integer.parseInt(o1.get("point").toString());
                int point2 = Integer.parseInt(o2.get("point").toString());
                double time1 = Double.parseDouble(o1.get("time").toString());
                double time2 = Double.parseDouble(o2.get("time").toString());

                if (point1 == point2) {
                    return Double.compare(time1, time2);
                } else {
                    return Integer.compare(point2, point1);
                }
            }
        };


        try {

            JSONArray jsonArray = (JSONArray) new JSONParser().parse(new FileReader("src/main/resources/score_board.json"));
            Collections.sort(jsonArray, jsonObjectComparator);

            if (jsonArray.size()>10){
                for (int i = 0;i<10;i++){
                    JLabel list = new JLabel();
                    JSONObject obj = (JSONObject) jsonArray.get(i);
                    int num = i+1;
                    String name = (String) obj.get("name");
                    Long point = (Long) obj.get("point");
                    double time = (Double) obj.get("time");
                    String s = String.format("%06d", (int)time);
                    DateFormat format__ = new SimpleDateFormat("mmss");
                    DateFormat format_ = new SimpleDateFormat("mm:ss");
                    Date formattime = format__.parse(s);
                    String format2 = "%1$-7s %2$-16s %3$-12s %4$-10s\n";
                    list.setText(String.format(format2,num,name,point,format_.format(formattime)));
                    list.setFont(new Font("Emulogic",Font.ITALIC,6));
                    list.setBounds(45, 90+(i*20), 323, 20);
                    background.add(list);
                }
            }else{
                for (int i = 0;i<jsonArray.size();i++){
                    JLabel list = new JLabel();
                    JSONObject obj = (JSONObject) jsonArray.get(i);
                    int num = i+1;
                    String name = (String) obj.get("name");
                    Long point = (Long) obj.get("point");
                    double time = (Double) obj.get("time");
                    String s = String.format("%06d", (int)time);
                    DateFormat format__ = new SimpleDateFormat("mmss");
                    DateFormat format_ = new SimpleDateFormat("mm:ss");

                    Date formattime = format__.parse(s);
                    String format2 = "%1$-7s %2$-16s %3$-12s %4$-10s\n";
                    list.setText(String.format(format2,num,name,point,format_.format(formattime)));
                    list.setFont(new Font("Emulogic",Font.ITALIC,6));
                    list.setBounds(45, 90+(i*20), 323, 20);
                    background.add(list);
                }
            }

        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
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
//        contentPanel.add(new FirstMenu());
//        j.setSize(368,336);
//        j.setVisible(true);
//    }
}

