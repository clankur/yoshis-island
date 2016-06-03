import javax.swing.*;
import java.awt.*;

/**
 * The Player class represnts the actions that will be taken by the Game player
 * Created by Ankur on 4/22/2015.
 */
public class Player implements  Character{
    private int myX, myY, myAmmo;
    private double myLength,myWidth;
    public ImageIcon player;
    public Player(){
        myX = 300 ;
        myY = 560 ;
        myLength = 70;
        myWidth = 77;
        player = new ImageIcon("Yoshi.png");        
        myAmmo = 10;
    }
    public Player(int x, int y){
        myX = x ;
        myY = y ;
    }
    public Player(int x, int y, int l, int w){
        myX = x ;
        myY = y ;
        myLength = l;
        myWidth = w ;
    }
    public Player(int x, int y, int l, int w, ImageIcon p, int li){
        myX = x ;
        myY = y ;
        myLength = l;
        myWidth = w ;
        player = p ;
        myAmmo = li;
    }
    public Player(ImageIcon p){
        player = p ;
    }
    public int getX()
    {
        return myX;
    }
    public int getY()
    {
        return myY;
    }
    public int getAmmo()
    {
        return myAmmo;
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
    public void setAmmo(int l)
    {
        myAmmo = l;
    }
    public void setLength(double l) {
        myLength = l;
    }
    public void setWidth(double w){
        myWidth = w;
    }
    public void respawn(){
        setX(240);
        setY(460);
        setLength(70);
        setWidth(77);
    }
    public void draw(Graphics myBuffer)
    {
        myBuffer.drawImage(player.getImage(), (int) (myX - myWidth / 2), (int) (myY - myLength / 2), (int) myWidth, (int) myWidth, null);
        //myBuffer.setColor(Color.blue);
        //myBuffer.fillOval((int)(myX - myLength/2), (int)(myY-myWidth/2), (int)myLength, (int)myWidth);
    }
    public void die(){
      setLength(0);
      setWidth(0);
      //setX();
      setY(1000);

    
}
}