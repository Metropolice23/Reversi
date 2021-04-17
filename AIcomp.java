public class AIcomp
{
private Gameboard gameboard;
private Square[][] squares;
 public AIcomp (Gameboard gameboard)
 {
 this.gameboard=gameboard;
 squares= gameboard.getSquares();
  
 if (corners()==false)
 {
     if (sides()==false)
     {
           if (content()==false)
           {
           }
     }
 }
 if (!gameboard.checkwin())
 { 
 gameboard.checkplayer();
}
}

 public boolean corners ()
 {
int x=-1,y=-1,max=0;
if(squares[0][0].getColor().equals("Empty")&&max<gameboard.checksum("White",0,0))
{
max=gameboard.checksum("White",0,0);
 x=0;
 y=0;
}
if(squares[7][0].getColor().equals("Empty")&&max<gameboard.checksum("White",7,0))
{
max=gameboard.checksum("White",7,0);
x=7;
y=0;
}
if(squares[0][7].getColor().equals("Empty")&&max<gameboard.checksum("White",0,7))
{
max=gameboard.checksum("White",0,7);
x=0;
y=7;
}
if(squares[7][7].getColor().equals("Empty")&&max<gameboard.checksum("White",7,7))
{
max=gameboard.checksum("White",7,7);
x=7;
y=7;
}
int[] sides;
if (max==0)
{return false;}
if(x!=-1&&y!=-1)
{
sides=gameboard.check("White",x,y);
gameboard.change (sides,x,y);
}
// System.out.println("("+x+" "+y+")");
return true;
}
 
 public boolean sides ()
 {
int max=0;//gameboard.checksum("White",1,0);
int x=1;
int y=0;
for (int i=1;i<7;i++)
{
if(squares[i][0].getColor().equals("Empty")&&max<gameboard.checksum("White",i,0))
{
max=gameboard.checksum("White",i,0);
x=i;
y=0;
}
}
for (int i=1;i<7;i++)
{
if(squares[0][i].getColor().equals("Empty")&&max<gameboard.checksum("White",0,i))
{
max=gameboard.checksum("White",0,i);
x=0;
y=i;
}
}
for (int i=1;i<7;i++)
{
if(squares[7][i].getColor().equals("Empty")&&max<gameboard.checksum("White",7,i))
{
max=gameboard.checksum("White",7,i);
x=7;
y=i;
}
}
for (int i=1;i<7;i++)
{
if(squares[i][7].getColor().equals("Empty")&&max<gameboard.checksum("White",i,7))
{
max=gameboard.checksum("White",i,7);
x=i;
y=7;
}
}

if (max==0)
{return false;}
int[] sides;
sides=gameboard.check("White",x,y);
gameboard.change (sides,x,y);
//  System.out.println("("+x+" "+y+")");
return true;
}
 

public boolean content ()
 {
int max= 0;
int x=-1;
int y=-1;
for (int i=1;i<7;i++)
{
for (int j=1;j<7;j++)
{
if(squares[i][j].getColor().equals("Empty")&&max<gameboard.checksum("White",i,j))
{
max=gameboard.checksum("White",i,j);
x=i;
y=j;
}
}
}
// System.out.println("("+x+" "+y+")");

if (max==0)
{return false;}
int[] sides;
sides=gameboard.check("White",x,y);
gameboard.change (sides,x,y);
// System.out.println("("+x+" "+y+")");
return true;
}
 
}
