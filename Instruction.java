import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Instruction extends JFrame
{
private Mybutton exit;
public Instruction()
{
setSize(1043,696);
setLocation(220,80);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
MyActionListener al=new MyActionListener();
exit=new Mybutton(166,57,42,610);
exit.addActionListener(al);
p.add(exit);
JLabel instruction=new JLabel(new ImageIcon("instruction.png"));
instruction.setSize(1043,696);
p.add(instruction);
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
new Mainframe();
dispose();
}
}
}
}
