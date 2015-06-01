public class Bar extends Geometry
{
  public Bar()
    { 
      if(Math.random()<0.5)
       {
        a[0] = new Point(6,1);
        a[1] = new Point(6,2);
        a[2] = new Point(6,3);
        a[3] = new Point(6,4);

        changedTime = 1;
       }
     else
       {
        a[0] = new Point(4,1);
        a[1] = new Point(5,1);
        a[2] = new Point(6,1);
        a[3] = new Point(7,1);
 
        changedTime = 0;
       }   
    }
  void rotate()
    {                     
     if((changedTime%2)==0)
      {
        changedTime++; 
        a[0].X = a[2].X;  a[0].Y = a[2].Y-2;  
        a[1].X = a[2].X;  a[1].Y = a[2].Y-1;  
        a[3].X = a[2].X;  a[3].Y = a[2].Y+1;        
      }
     else
      {
        changedTime++;

        if(a[0].X>9)
       {

       }
          
        else if(a[0].X>2)
       { 
        a[0].X = a[2].X-2;  a[0].Y = a[2].Y;
        a[1].X = a[2].X-1;  a[1].Y = a[2].Y;
        a[3].X = a[2].X+1;  a[3].Y = a[2].Y;        
       } 

        else if(a[0].X<=2)
       {

       }        
      }  
    }

}