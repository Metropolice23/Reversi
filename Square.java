import java.awt.*;
import javax.swing.*;
public class Square extends JButton
{
private String color;// שחור,לבן,ריק
private int x;
private int y;
  public Square(int x,int y)
{
this.x=x;
this.y=y;
setIcon(new ImageIcon ("Empty.jpg"));
this.color="Empty";
setBorder(null);
setFocusPainted(false);
setContentAreaFilled(false);
}
public void setColor(String newColor)
{
this.color=newColor;
setIcon(new ImageIcon (color+".png"));
}
public String getColor()
{
return color;
}
public void setSquareX(int newX)
{
this.x=newX;
}
public void setSquareY(int newY)
{
this.y=newY;
}
public int getSquareX()
{
return x;
}
public int getSquareY()
{
return y;
}
}