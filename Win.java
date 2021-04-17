import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Win extends JFrame
{
private Mybutton exit;
private int bcount;
private String name;
public Win(String name, int bcount)
{
//System.out.println(name+"      "+bcount);
setSize(640,480);
setLocation(400,200);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
this.name=name;
this.bcount=bcount;
MyActionListener al=new MyActionListener();
exit=new Mybutton(112,59,29,395);
exit.addActionListener(al);
p.add(exit);
JLabel win=new JLabel(new ImageIcon("win.png"));
JLabel me = new JLabel(name);
me.setSize(100,50);
me.setFont(new Font("Ariel",Font.BOLD,24));
me.setForeground(Color.white);
me.setLocation(310,40);
win.setSize(640,480);
p.add(me);
p.add(win);

add(p);
setVisible(true);
}
public class MyActionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JButton b=(JButton)e.getSource();
if(b==exit)
{
Scorelist sl=new Scorelist();
sl.setVisible (false);
if (!name.equals("מחשב") && sl.checkscore(bcount,name))
{
new Scorelist();
dispose();
}
else
{
new Mainframe();
dispose();
}
}
}
}
}
