import javax.swing.*;
import java.awt.*;

/**
 * The Ammo class is represented by the Apple icon and if falls to the bottom of the screen and
 * when the player captures this object it gives him more ammunition to shoot the bad guys.
 * Created by Ankur on 4/24/2015.
 */
public class Ammo {
    private int myX, myY;
    private double myLength,myWidth;
    public ImageIcon ammo;
    public Ammo(){
        myX = 240 ;
        myY = 240 ;
        myLength = 90;
        myWidth = 60;
        ammo = new ImageIcon("Apple.png");
    }

    /**
     * The ammo constructor.
     * @param x - x co-ordinate
     * @param y - y co-ordinate
     * @param l - length
     * @param w - width
     * @param p - The image icon representing the Ammo object
     */
    public Ammo(int x, int y, int l, int w, ImageIcon p){
        myX = x ;
        myY = y ;
        myLength = l;
        myWidth = w ;
        ammo = p ;
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
        myBuffer.drawImage(ammo.getImage(), (int) (myX - myWidth / 2), (int) (myY - myLength / 2), (int) myWidth, (int) myWidth, null);
        //myBuffer.setColor(Color.blue);
        //myBuffer.fillOval((int)(myX - myLength/2), (int)(myY-myWidth/2), (int)myLength, (int)myWidth);

    }
        public void fall(Graphics myBuffer)
    { 
      myY = myY +20;
      draw(myBuffer);
    }
    public void feed()
    {
      myX=900;
      myY=900;
    }
      }

