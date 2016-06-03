import javax.swing.*;
import java.awt.*;

/**
 * The Enemy class that represents the bad guy in the game, The aim is to defeat the
 * bad guys. When the bad guy succeeds in his attack the player loses life and eventually
 * the player dies and game ends. When the Enemy dies, the players' score increases
 *
 * Created by Ankur on 4/24/2015.
 */
public class Enemy implements Character {
    private int myX, myY;
    private double myLength,myWidth;
    public ImageIcon enemy;
    public Enemy(){
        myX = 240 ;
        myY = 240 ;
        myLength = 90;
        myWidth = 60;
        enemy = new ImageIcon("Paragomba.png");
    }

    /**
     * The constructor for Enemy
     * @param x - x co-ordinate
     * @param y - y co-ordinate
     * @param l - length
     * @param w - width
     * @param p - The image icon representing the Enemy object
     */
    public Enemy(int x, int y, int l, int w, ImageIcon p){
        myX = x ;
        myY = y ;
        myLength = l;
        myWidth = w ;
        enemy = p ;
    }
    public int getX()
    {
        return myX;
    }
    public int getY()
    {
        return myY;
    }
    public double getLength()
    {
        return myLength;
    }
    public double getWidth()
    {
        return myWidth;
    }
    public void setX(int x)
    {
        myX = x;
    }
    public void setY(int y)
    {
        myY = y;
    }
    public void setLength(double l) {
        myLength = l;
    }
    public void setWidth(double w){
        myWidth = w;
    }
    public void respawn(){
        setX(240);
        setY(480);
    }
    public void draw(Graphics myBuffer)
    {
        //System.out.println("drawing" + myY);
        myBuffer.drawImage(enemy.getImage(), (int) (myX - myWidth / 2), (int) (myY - myLength / 2), (int) myWidth, (int) myWidth, null);
        //myBuffer.setColor(Color.blue);
        //myBuffer.fillOval((int)(myX - myLength/2), (int)(myY-myWidth/2), (int)myLength, (int)myWidth);

    }
        public void fall(Graphics myBuffer)
    { 
      myY=myY+5;
      draw(myBuffer);
    }
    public void attack(Graphics myBuffer, int playerCord)
    {
      if(myX>playerCord)
         myX=myX-2;
      if(myX<playerCord)
         myX=myX+2;
         draw(myBuffer);
    }
    public void die()
    {
      myX=900;
      myY=900;
    }
      }

