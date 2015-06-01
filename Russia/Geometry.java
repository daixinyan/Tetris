import java.awt.*;
public abstract class  Geometry
{
   Point[] a = new Point[4];
   int   changedTime;
      
   abstract void  rotate();
   
 
   void  downToward()
   {
    for(Point b : a)
    b.Y +=1;
   }
   void  rightToward()
   {
    for(Point b : a)
    b.X +=1;   
   }
   void  leftToward()
   {
    for(Point b : a)
    b.X -=1; 
   }
   void  returned()
   {
    for(Point b : a)
    b.Y -=1; 
   }
}