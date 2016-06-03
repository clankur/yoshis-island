import javax.swing.*;
import java.awt.*;

/**
 * Created by Ankur on 4/24/2015.
 */
public class Projectile implements Character {
    private int myX, myY;
    public double myLength,myWidth;
    public ImageIcon projectile;
    public Projectile(){
        myX = 700 ;
        myY = 700 ;
        myLength = 75;
        myWidth = 50;
        projectile = new ImageIcon("Egg.png");
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
    public void draw(Graphics myBuffer)
    {
        //System.out.println("drawing" + myY);
        myBuffer.drawImage(projectile.getImage(), (int) (myX - myWidth / 2), (int) (myY - myLength / 2), (int) myWidth, (int) myWidth, null);
        //myBuffer.setColor(Color.blue);
        //myBuffer.fillOval((int)(myX - myLength/2), (int)(myY-myWidth/2), (int)myLength, (int)myWidth);
    }
        public void thrown(Graphics myBuffer, int xTarget, int yTarget, int xStart, int yStart)
    {
      int xAbsDist=Math.abs(xTarget-xStart);
      int yAbsDist=Math.abs(yTarget-yStart);
      int gcd =gcd(xAbsDist,yAbsDist);
   //   if((myX<xTarget)&&(myY!=yTarget)){
    //  double simpSlope=(yAbsDist/gcd)/(xAbsDist/gcd);
      if(xStart-xTarget>0){
      myX=myX-xAbsDist/gcd;
      }
      else{
      myX=myX+xAbsDist/gcd;
      }
      myY=myY-yAbsDist/gcd;
      draw(myBuffer);
    //  }
    }
      private int gcd(int a, int b)
      {
		int d=0;
       for(int c = 1; c<=getMax(a,b); c++){
		 if(a%c==0&&b%c==0){
       d=c;    
		 }
       }
		 return d;
      }
		
		
		private int getMax ( int num1, int num2){
		if(num1 > num2)
			return num1;
		else
			return num2;
		}
}