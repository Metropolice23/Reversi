import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;

public class Scorelist extends JFrame
{
private Mybutton exit;
private Vector <C1> scores;
private JLabel [][] labels;
public Scorelist()
{
setSize(1043,696);
setLocation(220,80);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
 getScores();
labels= new JLabel [10][3];
for (int i=0;i<10;i++)
{
for (int j=0;j<3;j++)
{
labels [i][j]= new JLabel (scores.get(i).getScore()+"");
labels [i][j].setHorizontalAlignment(JLabel.RIGHT);
labels [i][j].setSize (75,30);
labels [i][j].setLocation (140+j*350,200+i*35);
labels [i][j].setFont(new Font("Ariel",Font.BOLD,14));
labels [i][j].setForeground(Color.white);
p.add (labels [i][j]);
}
}
for (int i=0;i<10;i++)
{
labels [i][1].setText (scores.get(i).getDate());
labels [i][2].setText (scores.get(i).getPlayer1());
}
MyActionListener al=new MyActionListener();
exit=new Mybutton(166,57,42,610);
exit.addActionListener(al);
p.add(exit);
JLabel scorelist=new JLabel(new ImageIcon("scorelist.png"));
scorelist.setSize(1043,696);
p.add(scorelist);
add(p);
setVisible(true);
//checkscore(43,"ofra");
}
public boolean checkscore(int score, String player1)
{
//System.out.println(score+ "   checkscore"+(score>scores.get(9).getScore())+" "+player1);
if (score>scores.get(9).getScore())
{
for (int i=0;i<10;i++)
{
if (score>scores.get(i).getScore())
{
//System.out.println("checkscore123");
Date now = new Date();
DateFormat df= DateFormat.getDateInstance(DateFormat.SHORT);
String date=df.format (now);
scores.add (i,new C1(player1,date,score));
scores.remove (10);
saveScores ();
return true;
}
}
}
return false;
}
public void getScores()
{
scores=new Vector <C1>();
try
{
Scanner s= new Scanner(new BufferedReader(new FileReader("scores.txt")));
s.useDelimiter("\\s*\n\\s*");
while(s.hasNext())
{

String date=s.next();
String player1=s.next();
int score=s.nextInt();
scores.add(new C1(player1,date,score));
}
s.close();
}
catch(Exception e)
{
System.out.println("File not found");
e.printStackTrace();
}
}
public void saveScores()
{
try
{
FileWriter myFile=new FileWriter ("scores.txt");
PrintWriter fileOutput=new PrintWriter(myFile);
for(int i=0;i<scores.size();i++)
{
fileOutput.println(scores.get(i).getDate());
fileOutput.println(scores.get(i).getPlayer1());
fileOutput.println(scores.get(i).getScore());

}
fileOutput.close();
}
catch(IOException e)
{
System.err.println("Caught IOException : " + e.getMessage());
}
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
