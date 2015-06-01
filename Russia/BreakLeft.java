public class BreakLeft extends Geometry
{
 
  public BreakLeft()
  {
       a[0] = new Point(5,1);
       a[1] = new Point(5,2);
       a[2] = new Point(6,2);
       a[3] = new Point(7,2); 
       changedTime = 0;       
  }
  
 void rotate()
  {
       if((changedTime%4)==0)  
         {
             a[0].X = a[2].X+1;  a[0].Y = a[2].Y-1;  
             a[1].X = a[2].X;    a[1].Y = a[2].Y-1;  
             a[3].X = a[2].X;    a[3].Y = a[2].Y+1;               
         }
       if((changedTime%4)==1)  
         {
             a[0].X = a[2].X+1;  a[0].Y = a[2].Y+1;  
             a[1].X = a[2].X+1;  a[1].Y = a[2].Y;  
             a[3].X = a[2].X-1;  a[3].Y = a[2].Y;   
         }
       if((changedTime%4)==2)  
         {
            a[0].X = a[2].X-1;  a[0].Y = a[2].Y+1;  
            a[1].X = a[2].X;    a[1].Y = a[2].Y+1;   
            a[3].X = a[2].X;    a[3].Y = a[2].Y-1;   
         }
       if((changedTime%4)==3)  
         {
            a[0].X = a[2].X-1;  a[0].Y = a[2].Y-1;  
            a[1].X = a[2].X-1;  a[1].Y = a[2].Y;  
            a[3].X = a[2].X+1;  a[3].Y = a[2].Y;   
         }
     
     changedTime ++; 
  } 
}