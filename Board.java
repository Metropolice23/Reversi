import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Board extends JFrame
{
private Mybutton exit;
private Gameboard gb;
private int bcount;
private int wcount;
private int sec;
private JLabel bCount;
private JLabel wCount;
private JLabel time;
private JLabel playerB;
private JLabel playerW;
private String player1,player2;
public Board(String player1,String player2,String clock)
{
setSize(1043,696);
setLocation(220,80);
setUndecorated(true);
JPanel p=new JPanel();
p.setLayout(null);
gb=new Gameboard(this,player2,clock);
p.add(gb);
this.player1=player1;
this.player2=player2;
MyActionListener al=new MyActionListener();
exit=new Mybutton(166,53,32,610);
exit.addActionListener(al);
p.add(exit);
JLabel board=new JLabel(new ImageIcon("board.png"));
board.setSize(1043,696);
bcount=2;
wcount=2;
bCount=new JLabel(bcount+"");
bCount.setSize(35,35);
bCount.setLocation(148,129);
bCount.setFont(new Font("Ariel",Font.BOLD,35));
bCount.setForeground(Color.white);
p.add(bCount);
wCount=new JLabel(wcount+"");
wCount.setSize(35,35);
wCount.setLocation(148,245);
wCount.setFont(new Font("Ariel",Font.BOLD,35));
p.add(wCount);
playerB=new JLabel(player1);
playerB.setSize(200,35);
playerB.setLocation(0,90);
playerB.setFont(new Font("Ariel",Font.BOLD,37));
playerB.setHorizontalAlignment(JLabel.RIGHT);
playerB.setForeground(Color.white);
p.add(playerB);
playerW=new JLabel(player2);
playerW.setSize(200,35);
playerW.setLocation(0,205);
playerW.setFont(new Font("Ariel",Font.BOLD,37));
playerW.setHorizontalAlignment(JLabel.RIGHT);
playerW.setForeground(Color.black);
p.add(playerW);
if (!player2.equals("מחשב")&&clock.equals ("כן"))
{
sec=10;
time=new JLabel(sec+"");
time.setSize(35,35);
time.setLocation(145,479);
time.setFont(new Font("Ariel",Font.BOLD,37));
time.setForeground(Color.blue);
p.add(time);
}
p.add(board);
add(p);
setVisible(true);
}
public void endgame (String color)
{
if (color.equals ("Black"))
{new Win (player1,bcount);}
if (color.equals ("White"))
{new Win (player2,wcount);}
}
public void updatetime(int sec)
{
this.sec=sec;
time.setText(sec+"");
}
public void updatecount(int bcount,int wcount)
{
this.bcount=bcount;
this.wcount=wcount;
bCount.setText(bcount+"");
wCount.setText(wcount+"");
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

