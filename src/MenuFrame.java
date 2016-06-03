import javax.swing.*;
/**
 * This is the Drive class for the game, To play the game run this class in JGrasp
 * The playe reads the instructions before they can play the game.
 */
public class MenuFrame
{
   public static void main(String[] args){
      JFrame frame = new JFrame("Yoshi Land by Ankur and Jefferson");
      frame.setSize(500, 500);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MenuPanel(frame));
      frame.setVisible(true);
      frame.setSize(600,600);
   }
}