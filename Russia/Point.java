public class Point 
{
 int X;
 int Y;

 public Point(int x,int y)
  {
   X=x;Y=y;
  }

 boolean equ(Point a)
  {
    if((X==a.X)&&(Y==a.Y))  return true;
    else                  return false;
  }
}