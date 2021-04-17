import java.awt.*;
import javax.swing.*;
public class Mybutton extends JButton
{
public Mybutton(int w,int l, int x, int y)
{
setSize(w,l);
setLocation(x,y);
setBorder(null);
setFocusPainted(false);
setContentAreaFilled(false);
setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
}
}
