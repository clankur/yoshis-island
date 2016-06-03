import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Comparator;
import java.util.Timer.*;
import java.util.ArrayList;
import java.awt.PointerInfo;
import javax.swing.JOptionPane;
import java.awt.MouseInfo;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;
/**
 * The GamePanel class is called when the game starts
 * Created by Ankur Mishra on 3/7/2015.
 */
public class GamePanel extends JPanel {
    private static final int FRAME = 600;
    private static final Color BACKGROUND = new Color(0, 125, 255);
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Player yoshi;
    private ArrayList<Enemy> list;
    private ArrayList<Ammo> appleList;
    private ArrayList<Integer> numAmmoList;
    private Timer t, t1, enemyT, fallingT,throwT, testerT, gameOverT, appleT, fallingAT;
    private java.util.Timer timer;
    private Projectile egg;
    private int score, enemyTime,checkX,checkY,counter3, die, check;
    private JLabel label;
    private PointerInfo p;
    private MouseInfo stewart;
    private Ammo apple;
    JFrame newFrame, frame, frame2;

    /**
     * Default constructor
     */
    public GamePanel() {
        check = 0;
        timer = new java.util.Timer();
        die=0;
        counter3=0;
        list = new ArrayList<Enemy>();
        appleList = new ArrayList<Ammo>();
        numAmmoList = new ArrayList<Integer>();
        fallingAT= new Timer(70, new Listener5());
        fallingAT.start();
        appleT = new Timer(3000, new appleListener());
        appleT.start();
        myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0, 0, FRAME, FRAME);
        score = 0;
        enemyTime=1000;
        enemyT=new Timer(enemyTime, new Listener2());
        enemyT.start();
        fallingT=new Timer(60, new Listener3());
        fallingT.start();
        t = new Timer(5, new Listener());
        yoshi = new Player();
        egg = new Projectile();
        addMouseListener(new Mouse());
        addKeyListener(new Key());
        setFocusable(true);
        t.start();
    }

    /**
     * Paints the game screen
     * @param g
     */
    public void paintComponent(Graphics g) {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }
    private class Mouse extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            t1 = new Timer(5, new Listener1());
            if (e.isMetaDown()) {

            }
            else {
                if(yoshi.getLength() ==70&&yoshi.getAmmo()!=0){
                    egg.myLength = 75;egg.myWidth = 50;
                    egg.setX(e.getX() + 10);egg.setY(e.getY() + 20);
                    yoshi.setAmmo(yoshi.getAmmo()-1); System.out.println(yoshi.getAmmo());
                    if (t1.isRunning()) {t1.stop();}t1.start();
                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            egg.myLength = 0;
                            egg.myWidth = 0;
                            egg.setX(yoshi.getX());
                            egg.setY(1000);
                            t1.stop();
                        }
                    }, 300);
                }
            }
        }
    }
    private class Key extends KeyAdapter {
        //Controls
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A && yoshi.getX() >= 40) {
                int x =0;
                while(x < 10) {
                    yoshi.setX(yoshi.getX() - 2);
                    x++;
                }
                // System.out.println("Moved Left and X =" + yoshi.getX());
            }
            if (e.getKeyCode() == KeyEvent.VK_D && yoshi.getX() <= 560) {
                yoshi.setX(yoshi.getX() + 20);
                //System.out.println("Moved Right and X =" + yoshi.getX());
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT && yoshi.getX() >= 40) {
                yoshi.setX(yoshi.getX() - 20);
                //System.out.println("Moved Left and X =" + yoshi.getX());
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && yoshi.getX() <= 560) {
                yoshi.setX(yoshi.getX() + 20);
                //  System.out.println("Moved Right and X =" + yoshi.getX());
            }
            if (e.getKeyChar() == 27) {
                System.exit(0);
            }
        }
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myBuffer.setColor(BACKGROUND);    //cover the
            myBuffer.fillRect(0, 0, FRAME, FRAME);   //old ball
            yoshi.draw(myBuffer);
            for(int x = 0; x<list.size();x++)
            {
                list.get(x).draw(myBuffer);
            }
            for(int x=0; x<appleList.size(); x++)
                appleList.get(x).draw(myBuffer);

            myBuffer.setColor(Color.RED);
            final int style = Font.BOLD;
            Font font = new Font ("Cooper Black", style , 20);
            myBuffer.setFont(font);
            myBuffer.drawString("Score: " + score, FRAME - 130, 25);
            myBuffer.drawString("Ammo: " + yoshi.getAmmo(), 0 + 15, 25);

            repaint();
            //System.out.println(list.size());
            for(int x = 0; x<list.size(); x++)
            {
                if(Math.abs(egg.getX()-list.get(x).getX())<40&&Math.abs(egg.getY()-list.get(x).getY())<40){
                    list.get(x).die(); score = score + 100;
                }
                if(Math.abs(yoshi.getX()-list.get(x).getX())<50&&Math.abs(yoshi.getY()-list.get(x).getY())<35){
                    yoshi.die();
                    die++;
                }
            }
//            for(int x= 0; x<appleList.size(); x++){
//                if(Math.abs(egg.getX()-appleList.get(x).getX())<60&&Math.abs(egg.getY()-appleList.get(x).getY())<35){
//                    appleList.get(x).feed();
//                    yoshi.setAmmo(numAmmoList.get(x)+yoshi.getAmmo());
//                }
//            }
            for(int x= 0; x<appleList.size(); x++){
                if(Math.abs(yoshi.getX()-appleList.get(x).getX())<60&&Math.abs(yoshi.getY()-appleList.get(x).getY())<35){
                    appleList.get(x).feed();
                    yoshi.setAmmo(numAmmoList.get(x)+yoshi.getAmmo());
                }
            }
            if(die==1) {
                Scanner infile = null;
                Scanner scanny = null;
                try {
                    infile = new Scanner(new File("highscore.txt"));
                    scanny = new Scanner(new File("highscore.txt"));
                } catch (FileNotFoundException p) {
                    JOptionPane.showMessageDialog(null, "The file could not be found.");
                    System.exit(0);
                }
                int numitems = 0;
                while (scanny.hasNext()) {
                    scanny.nextLine();
                    numitems++;
                }
                scanny.close();
                numitems = numitems;
                numitems = numitems + 1;
                System.out.println(numitems);
                scoreReader[] array = new scoreReader[numitems];
                for (int i = 0; i < numitems - 1; i++) {
                    array[i] = new scoreReader(infile.nextInt());
                }
                //String s1 = JOptionPane.showInputDialog("What your name son?(Only one word names)");
                array[numitems -1] = new scoreReader(score);
                infile.close();
                sort(array, new ByScores());
                PrintStream outfile = null;
                try {
                    outfile = new PrintStream(new FileOutputStream("highscore.txt"));
                } catch (FileNotFoundException q) {
                    JOptionPane.showMessageDialog(null, "The file could not be created.");
                }
                for (int x = 0; x < array.length; x++) {
                    outfile.println(array[x].getScore());
                }
                new java.util.Timer().schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setVisible(false);
                        Font font2 = new Font("Cooper Black", style, 60);
                        myBuffer.setFont(font2);
                        newFrame = new JFrame("Game");
                        newFrame.setVisible(true);
                        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        newFrame.setContentPane(new DeadPanel());
                        newFrame.setSize(600, 600);
                    }
                }, 5000);
                System.out.println("Your score was: " + score);
                die = 0;
            }
        }
    }

    /**
     * sorts the array containing the scores so that the highest score is on the top
     * @param array
     * @param c
     */
    public static void sort(Object[] array, Comparator c)
    {
        int minPos;
        for(int k = 0; k < array.length; k++)
        {
            minPos = findMin(array, array.length - k, c);
            swap(array, minPos, array.length - k - 1);
        }
    }

    /**
     * finds the minimum score
     * @param array
     * @param upper
     * @param c
     * @return
     */
    public static int findMin(Object[] array, int upper, Comparator c)
    {
        {
            int minPos = 0;
            for (int i = 0; i < upper; i++){
                if(c.compare(array[i],array[minPos]) > 0){
                    minPos = i;
                }
            }
            return minPos;
        }
    }
    public static void swap(Object[] array, int a, int b)
    {
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private class Listener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myBuffer.setColor(BACKGROUND);    //cover the
            myBuffer.fillRect(0, 0, FRAME, FRAME);   //old ball
            yoshi.draw(myBuffer);
            for(int x = 0; x<list.size();x++)
            {
                list.get(x).draw(myBuffer);
            }
            egg.draw(myBuffer);
            for(int x = 0; x<appleList.size(); x++)
                appleList.get(x).draw(myBuffer);

            myBuffer.setColor(Color.WHITE);    //cover the
            //myBuffer.drawLine(egg.getX(), egg.getY(), yoshi.getX(), yoshi.getY());
            myBuffer.setColor(Color.RED);
            int style = Font.BOLD;
            Font font = new Font ("Cooper Black", style , 20);
            myBuffer.setFont(font);
            myBuffer.drawString("Score: " + score, FRAME - 130, 25);
            myBuffer.drawString("Ammo: " + yoshi.getAmmo(), 0 + 15, 25);
            repaint();
        }
    }
    private class Listener2 implements ActionListener {
        public void actionPerformed(ActionEvent e)   {
            for (int i =0; i < 5; i++) {
                int xCord = (int) (Math.random() * 580);
                int yCord = (int) (Math.random() * 50);
                list.add(new Enemy(xCord, yCord, 90, 60, new ImageIcon("Paragomba.png")));
                for (int x = 0; x < list.size(); x++) {
                    list.get(x).draw(myBuffer);
                }
                //enemyTime=enemyTime-50;
            }
        }
    }
    private class Listener3 implements ActionListener {
        public void actionPerformed(ActionEvent e)   {
            for(int x= 0; x<list.size();x++)
            {
                if(list.get(x).getY()>580)
                {
                    list.get(x).attack(myBuffer, yoshi.getX());
                }
                else
                {
                    list.get(x).fall(myBuffer);
                }
            }
            for(int x = 0; x<appleList.size(); x++)
            {
                if(appleList.get(x).getY()>=580){
                    appleList.get(x).setY(580);
                }
                else{
                    appleList.get(x).fall(myBuffer);
                }
            }
        }
    }
//    private class GameOverListener implements ActionListener {
//        public void actionPerformed(ActionEvent e)   {
//        }
//    }
    private double distance(double x1, double y1, double x2, double y2) {
        return (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
        //calculates distance between to objects
    }
    private class appleListener implements ActionListener   {
        public void actionPerformed(ActionEvent e)   {
            int aXCord = (int) (Math.random() * 580);
            int aYCord = (int) (Math.random() * 50);
            appleList.add(new Ammo(aXCord, aYCord, 50, 50, new ImageIcon("Apple.png")));
            for(int x = 0; x<appleList.size();x++){
                appleList.get(x).draw(myBuffer);
            }
            System.out.println("I'm Working");
            System.out.println();
            int numAmmo = (int)(Math.random()*10 +1);
            if (aYCord == 550)
                numAmmo = 100;
            numAmmoList.add(numAmmo);
        }
    }
    private class Listener5 implements ActionListener   {
        public void actionPerformed(ActionEvent e)   {
            for(int x = 0; x< appleList.size();x++){
                appleList.get(x).fall(myBuffer);
            }
        }
    }
}