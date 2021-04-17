import java.awt.*;
import javax.swing.*;
public class C1 
{
private String player1;
private String date;
private int score;
  public C1 (String player1, String date, int score)
{
this.score=score;
this.player1=player1;
this.date=date;
}
public void setScore(int newScore)
{
this.score=newScore;
}
public int getScore()
{
return score;
}
public void setDate(String newDate)
{
this.date=newDate;
}
public void setPlayer1(String newplayer1)
{
this.player1=newplayer1;
}
public String getPlayer1()
{
return player1;
}
public String getDate()
{
return date;
}
}

