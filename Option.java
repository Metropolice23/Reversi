import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Option extends JFrame
{
private Mybutton exit;
private JRadioButton no;
private JRadioButton yes;
private Mainframe mf;
public Option(Mainframe mf)
{
setSize(1043,696);
setLocation(220,80);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
this.mf=mf;
MyActionListener al=new MyActionListener();
exit=new Mybutton(161,46,61,596);
exit.addActionListener(al);
//yes.addActionListener(al);
yes = new JRadioButton();
yes.setSelected(true);
yes.setSize(17,17);
yes.setLocation(709,218);
//no.addActionListener(al);
no = new JRadioButton();
no.setSelected(true);
no.setSize(16,17);
no.setLocation(512,216);
ButtonGroup timegroup=new ButtonGroup();
timegroup.add(yes);
timegroup.add(no);
p.add(exit);
p.add(yes);
p.add(no);
JLabel option=new JLabel(new ImageIcon("option.png"));
option.setSize(1043,696);
add(p);
p.add(option);
setVisible(true);
}
public class MyActionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JButton b=(JButton)e.getSource();
if(b==exit)
{
      if(yes.isSelected())
      {mf.setclock("כן");}
      if(no.isSelected())
      {mf.setclock("לא");}
mf.setVisible (true);
dispose();
}
}
}
}
