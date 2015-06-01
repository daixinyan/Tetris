public class DoubleBar extends Geometry
{
  public DoubleBar()
   {
        changedTime = 0;
        a[0] = new Point(5,0);
        a[1] = new Point(6,0);
        a[2] = new Point(6,1);
        a[3] = new Point(7,1);
   }

  public void rotate()
  {
    if(changedTime%2 == 0)
     {
       a[0].X = a[2].X+1;  a[0].Y = a[2].Y-1;
       a[1].X = a[2].X+1;  a[1].Y = a[2].Y;
       a[3].X = a[2].X;    a[3].Y = a[2].Y+1; 
     }
    if(changedTime%2 == 1)
     {  
       a[2].X = a[1].X;    a[2].Y = a[1].Y; 
       a[0].X = a[2].X-1;  a[0].Y = a[2].Y-1;
       a[1].X = a[2].X;    a[1].Y = a[2].Y-1;
       a[3].X = a[2].X+1;  a[3].Y = a[2].Y;        
     }
    

    changedTime++;

  }
}