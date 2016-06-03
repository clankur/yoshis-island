import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * It is the Class that setups the GUI
 */
public class MenuPanel extends JPanel
{
   JFrame frame;
   JFrame newFrame;
   JLabel label, label1, label2;
   JButton play, highScores, rules;
   public MenuPanel(JFrame frame)
   {
      this.frame = frame;
      setBackground(Color.black);
      setLayout(new BorderLayout());
      label2=new JLabel();
      add(label2, BorderLayout.CENTER);
      JPanel subPanel = new JPanel();
      subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));
      subPanel.setBackground(Color.black);
      add(subPanel, BorderLayout.NORTH);
      label = new JLabel("Yoshi Land");
      label.setFont(new Font("Serif", Font.BOLD, 40));
      label.setForeground(Color.GREEN);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      subPanel.add(label);
      label1 = new JLabel("By Ankur Mishra and Jefferson Pan");
      label1.setFont(new Font("Serif", Font.BOLD, 20));
      label1.setForeground(Color.GREEN);
      label1.setAlignmentX(Component.CENTER_ALIGNMENT);
      subPanel.add(label1);
      JPanel subPanel2=new JPanel();
      subPanel2.setLayout(new FlowLayout());
      subPanel2.setBackground(Color.black);
      add(subPanel2, BorderLayout.SOUTH);
      
      play = new JButton("Play");
      subPanel2.add(play);
      play.addActionListener(new playListener());
      play.setEnabled(false);

      rules = new JButton("How to play");
      subPanel2.add(rules);
      rules.addActionListener(new rulesListener());
      
      highScores = new JButton("Highscores");
      subPanel2.add(highScores);
      highScores.addActionListener(new highListener());
      highScores.setEnabled(false);

   }
   private class playListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         frame.setVisible(false);
         if(newFrame == null){
            newFrame=new JFrame("Yoshi Land");
            newFrame.setVisible(true);
            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newFrame.setContentPane(new GamePanel());
            newFrame.setSize(600,600);
         }
         else{
            newFrame.setVisible(true);
         }
      }
   }
   private class rulesListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         label2.setFont(new Font("Serif", Font.PLAIN, 25));
         label2.setForeground(Color.GREEN);
         label2.setText("<html>The goal of the game is to hit as many goombas as possible and to not get hit by goombas which can kill you. You kill by goombas by throwing eggs with your mouse, and you can dodge goombas with the WASD keys or Arrow keys. You can get more eggs by eating apples<html>");
         play.setEnabled(true);
         highScores.setEnabled(true);
         rules.setEnabled(false);
      }
   }
   private class highListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         label2.setVisible(false);
         Scanner scanny = null;
         try{
            scanny = new Scanner(new File("highscore.txt"));
         }
         catch(FileNotFoundException f)
         {
            JOptionPane.showMessageDialog(null,"The file could not be found.");
            System.exit(0);
         }
         JPanel subPanel3 = new JPanel();
         subPanel3.setBackground(Color.black);
         add(subPanel3,BorderLayout.CENTER);
         subPanel3.setLayout(new BoxLayout(subPanel3, BoxLayout.PAGE_AXIS));
         JLabel[] scorArray = new JLabel[11];
         Font f = new Font("Serif", Font.BOLD, 30);
         for(int x = 0; x<5; x++){
            scorArray[x]=new JLabel();
            scorArray[x].setForeground(Color.green);
            scorArray[x].setAlignmentX(Component.CENTER_ALIGNMENT);
            subPanel3.add(scorArray[x]);
            scorArray[x].setFont(f);
         }
         for(int x = 0; x<10; x++){
            if(scanny.hasNextLine()){
               scorArray[x].setText((x+1)+". "+scanny.nextInt());
               scanny.nextLine();
            }
         }
      }
   }

}

