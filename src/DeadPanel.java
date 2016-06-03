import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *  * The GamePanel class is called when the game ends
 * Created by Ankur on 5/30/2015.
 */
 class DeadPanel extends JPanel {
    private static final int FRAME = 600;
    JFrame frame;
    JFrame newFrame;
    JLabel label, label2, label3;
    JLabel labelArray[] = new JLabel[5];
    int click = 0;
    private static final Color BACKGROUND = new Color(50, 40, 50);
    public DeadPanel(){
        this.frame = new JFrame();
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        subPanel.setBackground(Color.black);
        add(subPanel, BorderLayout.NORTH);
        JPanel highScorePanel = new JPanel();
        highScorePanel.setLayout(new BoxLayout(highScorePanel, BoxLayout.PAGE_AXIS));
        highScorePanel.setBackground(Color.BLACK);
        add(highScorePanel, BorderLayout.CENTER);
        label = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setForeground(Color.CYAN);
        label2.setFont(new Font("Serif", Font.BOLD, 30));
        label2.setForeground(Color.CYAN);
        label3.setFont(new Font("Serif", Font.BOLD, 30));
        label3.setForeground(Color.GREEN);
        label2.setText("                        Click to try again!");
        label.setText("            You failed to save Yoshi's Island.");
        label3.setText("                            Highscores");
        Scanner infile = null;
        try {
            infile = new Scanner(new File("highscore.txt"));
            int i = 0;
            while (infile.hasNext() && i < 5) {
                labelArray[i] = new JLabel();
                labelArray[i].setForeground(Color.GREEN);
                labelArray[i].setFont(new Font("Serif", Font.BOLD, 40));
                labelArray[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                labelArray[i].setText((i+1)+". "+infile.next());
                System.out.println(labelArray[i]);
                highScorePanel.add(labelArray[i]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        subPanel.add(label,BorderLayout.NORTH);
        subPanel.add(label2, BorderLayout.CENTER);
        subPanel.add(label3, BorderLayout.SOUTH);
        addMouseListener(new Mouse());
    }
    private class Mouse extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.isMetaDown()) {

            }
            else{
               setVisible(false);
                if(newFrame == null){
                    newFrame=new JFrame("Game");
                    newFrame.setVisible(true);
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.setContentPane(new GamePanel());
                    newFrame.setSize(600,600);
                    click = 0;
                }
            }
        }
    }
    public void output(){
        Scanner infile = new Scanner("highscore.txt");
        for(int i = 0; i < 5; i++){
            infile.next();
        }
    }
}