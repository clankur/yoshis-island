/**
 * Character interface that all the characters in the game implement.
 * It defines the base methods that all the characters in the game implement
 *
 * Created by Ankur on 5/30/2015.
 */
public interface  Character {
  //  private int myX, myY;
   // private double myLength, myWidth;
    public abstract int getX();
    public abstract void setX(int x);
    public abstract int getY();
    public abstract void setY(int y);
    public abstract double getLength();
    public abstract void setLength(double length);
    public abstract double getWidth();
    public abstract void setWidth(double width) ;
}
