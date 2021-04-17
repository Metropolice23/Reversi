import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Opengame extends JFrame
{
private Mybutton exit;
private Mybutton start;
private JTextField  player1;
private JTextField  player2;
private String playerNum;
private String clock;
public Opengame(String playerNum,String clock)
{
setSize(640,363);
setLocation(400,200);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
this.clock=clock;
this.playerNum=playerNum;
MyActionListener al=new MyActionListener();
exit=new Mybutton(165,48,24,293);
exit.addActionListener(al);
start=new Mybutton(290,60,185,210);
start.addActionListener(al);
player1=new JTextField();
//player1.addActionListener(al);
player1.setSize(400,35);
player1.setLocation(45,50);
player1.setHorizontalAlignment(JTextField.RIGHT);
player1.setFont(new Font("Ariel",Font.BOLD,14));
player2=new JTextField(playerNum);
//player2.addActionListener(al);
player2.setSize(400,35);
player2.setLocation(45,128);
player2.setHorizontalAlignment(JTextField.RIGHT);
player2.setFont(new Font("Ariel",Font.BOLD,14));
if(playerNum.equals("מחשב"))
{ player2.setForeground(Color.white);
   player2.setEnabled(false);
   // player2.setForeground(Color.BLACK);
}
p.add(exit);
p.add(start);
p.add(player1);
p.add(player2);
//JLabel =new JLabel (SwingConstants.RIGHT);
JLabel opengame=new JLabel(new ImageIcon("opengame.png"));
opengame.setSize(640,363);
p.add(opengame);
add(p);
setVisible(true);
}
public boolean checkName(String name)
{
int len=name.length();
int a=0;
if(name.equals("מחשב"))
{return false;}
if((len<2)||(len>15))
    {return false;}
for (int i=0;i<len;i++)
{
char ch=name.charAt(i);
if ((ch<'א'||ch>'ת')&&(ch!=' '))
    {return false;}
if ((ch>='א')&&(ch<='ת'))
{a++;}
}
if (a<2)
{return false;}
return true;
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
if(b==start)
{
String name1=player1.getText();
String name2=player2.getText();
if (!playerNum.equals("מחשב"))
{
if (checkName(name1)&&checkName(name2)&&(!name1.equals(name2)))
{

new Board(name1,name2,clock);
dispose();

}
else
{
JOptionPane.showMessageDialog(null,"מהשם חייב להכיל בין 2 ל15- תווים, השם חייב להיות בעל אותיות עבריות ורווחים בלבד (השם אינו יכול להיות המילה 'מחשב')","שגיאה- שם לא חוקי ",JOptionPane.DEFAULT_OPTION);
}
}
if (playerNum.equals("מחשב"))
{
if (checkName(name1))
{

new Board(name1,name2,clock);
dispose();

}
else
{
JOptionPane.showMessageDialog(null,"מהשם חייב להכיל בין 2 ל15- תווים, השם חייב להיות בעל אותיות עבריות ורווחים בלבד (השם אינו יכול להיות המילה 'מחשב')","שגיאה- שם לא חוקי ",JOptionPane.DEFAULT_OPTION);
}
}
}
}
}
}


