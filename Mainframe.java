import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Mainframe extends JFrame
{
private Mybutton start1;
private Mybutton start2;
private Mybutton instruction;
private Mybutton scorelist;
private Mybutton options;
private Mybutton exit;
private String lvl;
private String clock;
private Mainframe mf;
public Mainframe()
{
setSize(1043,696);
setLocation(220,80);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
lvl="";
clock="";
mf=this;
MyActionListener al=new MyActionListener();
start1=new Mybutton(289,57,646,188);
start1.addActionListener(al);
start2=new Mybutton(289,57,646,260);
start2.addActionListener(al);
instruction=new Mybutton(289,57,646,334);
instruction.addActionListener(al);
scorelist=new Mybutton(289,57,646,407);
scorelist.addActionListener(al);
options=new Mybutton(289,57,646,476);
options.addActionListener(al);
exit=new Mybutton(166,57,47,610);
exit.addActionListener(al);
p.add(options);
p.add(exit);
p.add(instruction);
p.add(start1);
p.add(start2);
p.add(scorelist);
JLabel menu=new JLabel(new ImageIcon("Main.png"));
menu.setSize(1043,696);
p.add(menu);
add(p);
setVisible(true);
}
public void setlvl (String lvl)
{
this.lvl=lvl;
}
public void setclock (String clock)
{
this.clock=clock;
}

public class MyActionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Mybutton b=(Mybutton)e.getSource();
if(b==exit)
{
System.exit(0);
}
if(b==start1)
{
new Opengame("מחשב","");
dispose();
}
if(b==start2)
{
new Opengame("",clock);
dispose();
}
if(b==instruction)
{
new Instruction();
dispose();
}
if(b==scorelist)
{
new Scorelist();
dispose();
}
if(b==options)
{
new Option(mf);
mf.setVisible (false);
}

 }
}}

