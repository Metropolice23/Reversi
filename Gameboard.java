import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gameboard extends JPanel
{
private Square[][] squares;
private String turn;
private Board board;
private Timer timer;
private Timer time;
private int sec;
private Gameboard gameboard;
private String player2;
private String clock;
public Gameboard(Board board,String player2,String clock)
{
setSize(648,648);
setLocation(313,25);
setBorder(null);
setOpaque(false);
this.player2=player2;
this.board=board;
this.clock=clock;
setLayout(new GridLayout(8,8));
squares= new Square [8][8];
timer =new Timer(700,new TimerListener());
time =new Timer(1000,new TimeListener());
gameboard=this;
MyActionListener al=new MyActionListener();
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
squares [i][j]= new Square(i,j);
squares [i][j].addActionListener(al);
add(squares[i][j]);
}
}


squares [3][3].setColor("White");
squares [4][4].setColor("White");
squares [4][3].setColor("Black");
squares [3][4].setColor("Black");



turn= "Black";
if (!player2.equals ("מחשב")&&clock.equals ("כן"))
{
sec=10;
//board.updatetime(sec);
time.start();
}
}

public Square[][] getSquares()
{
  return squares;
}
// public String Cturn ()
// {
// 
// }
public boolean able(String turn) 
{
int count=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Empty"))
{count=count+checksum (turn,i,j);}
if (count>0)
{return false;}
return true;
}
}
return true;
}
public void ofra ()
{
// System.out.println("---------------------------------------------");
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
String x;
x=squares [i][j].getColor();
System.out.print(x.charAt(0));
}

// System.out.println();
}
}
public void ccount(int bcount, int wcount)
{
bcount=0;
wcount=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Black"))
{bcount++;}
if (squares [i][j].getColor().equals("White"))
{wcount++;}
}
}
board.updatecount(bcount,wcount);
}
public int checksum (String turn, int x, int y)
{
int sum=0;
int count;
count=check0(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check1(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check2(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check3(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check4(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check5(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check6(turn,x,y);
if(count>0)
{
sum=sum+count;
}
count=check7(turn,x,y);
if(count>0)
{
sum=sum+count;
}
return sum;
}
public int[] check (String turn, int x, int y)
{
int[] sides = new int[8];
for (int i=0;i<8;i++)
{
sides [i]=0;
}
if(check0 (turn,x,y)>=1)
{
sides [0]=1;
}
if(check1 (turn,x,y)>=1)
{
sides [1]=1;
}
if(check2 (turn,x,y)>=1)
{
sides [2]=1;
}
if(check3 (turn,x,y)>=1)
{
sides [3]=1;
}
if(check4 (turn,x,y)>=1)
{
sides [4]=1;
}
if(check5 (turn,x,y)>=1)
{
sides [5]=1;
}
if(check6 (turn,x,y)>=1)
{
sides [6]=1;
}
if(check7 (turn,x,y)>=1)
{
sides [7]=1;
}
return sides;
}

public int check0 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx++;
String a;
if (xx>7)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty") || a.equals(turn))
{return 0;}
xx++;
count++;
while (xx<8 &&  squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx++;
count++;
}
//System.out.println("end yy="+yy);
if ((xx<8)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check1 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx++;
yy--;
String a;
if(yy<0||xx>7)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
xx++;
yy--;
count++;
while ((xx<8)&&(yy>-1)&& squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx++;
yy--;
count++;
}
//System.out.println("end yy="+yy);
if ((xx<8)&&(yy>-1)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check2 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
yy--;
String a;
if (yy<0)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
yy--;
count++;
while ((yy>-1)&&squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
yy--;
count++;
}
//System.out.println("end yy="+yy);
if ((yy>-1)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check3 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx--;
yy--;
String a;
if(yy<0||xx<0)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
xx--;
yy--;
count++;
while ((xx>-1)&&(yy>-1)&&squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx--;
yy--;
count++;
}
//System.out.println("end yy="+yy);
if ((xx>-1)&&(yy>-1)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check4 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx--;
String a;
if (xx<0)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
xx--;
count++;
while (xx>-1 &&  squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx--;
count++;
}
//System.out.println("end yy="+yy);
if ((xx>-1)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check5 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx--;
yy++;
String a;
if(yy>7||xx<0)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
xx--;
yy++;
count++;
while ((xx>-1)&&(yy<8)&&squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx--;
yy++;
count++;
}
//System.out.println("end yy="+yy);
if ((xx>-1)&&(yy<8)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check6 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
yy++;
String a;
if (yy>7)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
yy++;
count++;
while (yy<8 &&  squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
yy++;
count++;
}
//System.out.println("end yy="+yy);
if ((yy<8)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}
public int check7 (String turn, int x, int y)
{
int count=0;
int xx=x;
int yy=y;
xx++;
yy++;
String a;
if(yy>7||xx>7)
{return 0;}
a=squares[xx][yy].getColor();
if (a.equals("Empty")||a.equals(turn))
{return 0;}
xx++;
yy++;
count++;
while ((xx<8)&&(yy<8)&&squares[xx][yy].getColor().equals(a))
{
//System.out.println("xx="+xx+" yy="+yy);
xx++;
yy++;
count++;
}
//System.out.println("end yy="+yy);
if ((xx<8)&&(yy<8)&&(!squares [xx][yy].getColor().equals("Empty")))
{return count;}
return 0;
}





public boolean change (int[] sides, int x, int y)
{
boolean checking=false;
if (sides[0]==1)
{
change0(x,y);
checking=true;
}
if (sides[1]==1)
{
change1(x,y);
checking=true;
}
if (sides[2]==1)
{
change2(x,y);
checking=true;
}
if (sides[3]==1)
{
change3(x,y);
checking=true;
}
if (sides[4]==1)
{
change4(x,y);
checking=true;
}
if (sides[5]==1)
{
change5(x,y);
checking=true;
}
if (sides[6]==1)
{
change6(x,y);
checking=true;
}
if (sides[7]==1)
{
change7(x,y);
checking=true;
}
return checking;
}

public void change0 (int x, int y)
{
int xx=x;
int yy=y;
xx++;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx++;
while (squares[xx][yy].getColor().equals("Black"))
{   
squares[xx][yy].setColor("White");
xx++;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx++;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx++;
}
}
}

public void change1 (int x, int y)
{
int xx=x;
int yy=y;
xx++;
yy--;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx++;
yy--;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
xx++;
yy--;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx++;
yy--;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx++;
yy--;
}
}
}

public void change2 (int x, int y)
{
int xx=x;
int yy=y;
yy--;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White")  ;
yy--;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
yy--;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
yy--;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
yy--;
}
}
}

public void change3 (int x, int y)
{
int xx=x;
int yy=y;
xx--;
yy--;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx--;
yy--;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
xx--;
yy--;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx--;
yy--;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx--;
yy--;
}
}
}

public void change4 (int x, int y)
{
int xx=x;
int yy=y;
xx--;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx--;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
xx--;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx--;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx--;
}
}
}

public void change5 (int x, int y)
{
int xx=x;
int yy=y;
xx--;
yy++;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx--;
yy++;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
xx--;
yy++;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx--;
yy++;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx--;
yy++;
}
}
}

public void change6 (int x, int y)
{
int xx=x;
int yy=y;
yy++;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
yy++;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
yy++;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
yy++;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
yy++;
}
}
}

public void change7 (int x, int y)
{
int xx=x;
int yy=y;
xx++;
yy++;
String a;
a=squares[xx][yy].getColor();
if (a.equals("Black"))
{
squares[x][y].setColor("White");
squares[xx][yy].setColor("White");
xx++;
yy++;
while (squares[xx][yy].getColor().equals("Black"))
{
squares[xx][yy].setColor("White");
xx++;
yy++;
}
}
if (a.equals("White"))
{
squares[x][y].setColor("Black");
squares[xx][yy].setColor("Black");
xx++;
yy++;
while (squares[xx][yy].getColor().equals("White"))
{
squares[xx][yy].setColor("Black");
xx++;
yy++;
}
}
}

 public void checkplayerW ()
{
int count=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Empty"))
{
if (checksum("White",i,j)>0)
{
count++;
}
}
}
}
if (count==0)
{turn="Black";}
}

 public void checkplayerB ()
{
int count=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Empty"))
{
if (checksum("Black",i,j)>0)
{
count++;
}
}
}
}
if (count==0)
{turn="White";}
}

 public void checkplayer ()
{
int count=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Empty"))
{
if (checksum("Black",i,j)>0)
{
count++;
}
}
}
}
if (count==0)
{
// System.out.println("checkplayer");
ofra();
 new AIcomp(gameboard);
}
}

public boolean checkwin()
{
// System.out.println("checkwin");
int countE=0;
int countW=0;
int countB=0;
for (int i=0;i<8;i++)
{
for (int j=0;j<8;j++)
{
if (squares [i][j].getColor().equals("Empty"))
{countE++;}
if (squares [i][j].getColor().equals("Black"))
{countB++;}
if (squares [i][j].getColor().equals("White"))
{countW++;}
}
}
if(countB==0)
{board.endgame("White");}
else
if(countW==0)
{board.endgame("Black");}
else
if(countE==0)
{
if (countB>countW)
{board.endgame("Black");}
if (countW>countB)
{board.endgame("White");}
if (countB==countW)
{JOptionPane.showMessageDialog(null,"במשחק זה אין מנצחים, תוצאת המשחק היא תיקו.");
new Mainframe();
board.dispose();
}
}
else
 {
     return false;
    }
return true;  
}



public class MyActionListener implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
if (timer.isRunning()==false)
{
int bcount=0;
int wcount=0;
Square sq=(Square)e.getSource();
int x,y;
x=sq.getSquareX();
y=sq.getSquareY();
//System.out.println("x="+x+" y="+y);
if(squares [x][y].getColor().equals("Empty"))
{
int[] a = check(turn,x,y);
if(change (a,x,y))
{
if (player2.equals ("מחשב"))
  {timer.start();}
     else
     {
 if(turn.equals("Black"))
    {
     turn="White";
     if (clock.equals("כן"))
     {
     sec=10;
     board.updatetime(sec);
    }
    checkplayerW ();
   }
else
{
  turn="Black";
 if (clock.equals("כן"))
     {
     sec=10;
     board.updatetime(sec);
    }
  checkplayerB ();
}
}
}
}
ccount(bcount,wcount);
 checkwin();
}
}
}
public class TimeListener implements ActionListener
{
 public void actionPerformed(ActionEvent e)
{
sec--;
board.updatetime(sec);
if (sec==0)
{
time.stop();
 if(turn.equals("Black"))
    {
     turn="White";
     sec=10;
     board.updatetime(sec);
    checkplayerW ();
    }
else
{
  turn="Black";
  sec=10;
  board.updatetime(sec);
  checkplayerB ();
}
time.start();
}
}
}


public class TimerListener implements ActionListener
{
 public void actionPerformed(ActionEvent e)
{
// System.out.println("TimerListener");
timer.stop();
ofra();
new AIcomp(gameboard);
int bcount=0;
int wcount=0;
ccount(bcount,wcount);
}
}
}
