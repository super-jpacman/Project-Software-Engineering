package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.points.SaveScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RankingMode extends JFrame {
    private String path = "src/main/resources/Blackwall.jpg";
    private Image image = new ImageIcon(path).getImage();
    private JButton BackBTN;
    private JLabel Header;
    private JLabel Score;
    private JTextField name;
    private String Text_Header;
    private int Text_Score;
    private boolean enable;
    private boolean btnIsClicked;
    public RankingMode(){}
    public RankingMode(String Text_Header,int Text_Score,double totalTime,PacManUI PM) {
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
        PM.setEnabled(false);
        this.btnIsClicked = false;
        this.Text_Header=Text_Header;
        this.Text_Score=Text_Score;

        ImageIcon img = new ImageIcon(path);
        JLabel background = new JLabel(img);
        background.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
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
        //        name.setCaretColor(Color.WHITE);

        BackBTN.setLayout(new FlowLayout());
        BackBTN.setText("SAVE");
        BackBTN.setFocusPainted(false);
        BackBTN.setBounds(250, 310, 100, 30);
        BackBTN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // back to home
                btnIsClicked = true;
                if(!name.getText().isEmpty()){
                    new SaveScore(name.getText(),totalTime,Text_Score);
                    dispose();
                    PM.setEnabled(true);

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

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        //Delete Bar
        setUndecorated(true);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
