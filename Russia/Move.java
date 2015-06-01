import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Move extends TimerTask 
implements KeyListener
{
  int score = 0;
  static Geometry newGe;
  static ArrayList<Geometry> al;
  boolean done = true;
  static Frame  frame;
  public Move()
  {
    al = new ArrayList<Geometry>();  
    frame = new Frame();
    frame.addKeyListener(this);
    
  }   
 
  boolean fullFill(int line)
    {
        int[]  a = new int[10];
       
        int j;
        for(j=0;j<10;j++)
           a[j] = 0;
 
        for(Geometry ge : al)
        for(Point point : ge.a)
          if(point.Y==line)      a[point.X-1] = 1;

        boolean  result = true;
        for(j=0;j<10;j++)
           if(a[j]==0)  result =  false;
              
        if(result) 
        for(Geometry ge : al)
        for(Point point : ge.a)
          if(point.Y==line)      point.Y = -9999;  

       return result;   
        
             
    } 

  public void run()
  {
   System.out.println("score:"+score);
    if(done)  
     { 
        double dou = Math.random()*6;
        
        if(dou<2)        newGe = new DoubleBar(); 
        else if(dou<3)   newGe = new Square();
        else if(dou<4)   newGe = new Bar();
        else if(dou<5)   newGe = new BreakLeft();
        else if(dou<6)   newGe = new BreakRight();
       
        done = false;       
     }
    else
     {    
      newGe.downToward();
     }

    boolean  overlap = false;
    for(Geometry ge : al)
    {
     for(Point point1 : ge.a)
     {       
       for(Point point2 : newGe.a)
        {
          if(point1.equ(point2))   overlap = true;
             
        }
     }
    }
      for(Point point2 : newGe.a)
           if(point2.Y>20)          overlap = true; 

    if(overlap) 
     {
      newGe.returned();
      al.add(newGe);
      done = true ;      
     }

    int i,j;
    for(i=0;i<20;i++)
        for(j=0;j<10;j++)
          {
            frame.panel[i][j].setBackground(Color.white);                                 
          }

     for(Geometry ge : al)
      for(Point point : ge.a)
       {
          if(point.Y>0)
          frame.panel[point.Y-1][point.X-1].setBackground(Color.green);
       }
 
    for(Point point : newGe.a)
        if(point.Y>0)
        frame.panel[point.Y-1][point.X-1].setBackground(Color.green);
   if(done)
   {
    int line;
    for(line=20;line>0;line--)
      {
         if(fullFill(line))
             {                 
                 score ++;
                 for(Geometry  ge : al)
                 for(Point point : ge.a)
                    {
                         if(point.Y<line)    
                            {
                               point.Y+=1;
                             /*  
                               boolean over = false;
                               for(Geometry g : al)
                               for(Point pot : g.a)
                                   if(point.equ(pot))  over = true;                               
                               if(point.Y>20)          over = true; 
                               if(over) point.Y-=1;
   */                         }  
                    } 
               line = 21;
             }   
      }
   }    
  }

 public void keyPressed(KeyEvent ke)
    {
     if(ke.getKeyCode()==ke.VK_LEFT)
         {
            newGe.leftToward();

            boolean b = false; 
            for(Point point : newGe.a)
             {
               if(point.X<1)  b=true;
             }

             for(Geometry ge : al)
           {
             for(Point point1 : ge.a)
               {       
                for(Point point2 : newGe.a)
                   {
                     if(point1.equ(point2))   b = true;
             
                   }
                }
           }
  
             if(b)     
            newGe.rightToward();                           
         }

       if(ke.getKeyCode()==ke.VK_RIGHT)
         {
            newGe.rightToward();  
            boolean b = false; 
            for(Point point : newGe.a)
             {
               if(point.X>10)  b=true;
             }
         for(Geometry ge : al)
           {
             for(Point point1 : ge.a)
               {       
                for(Point point2 : newGe.a)
                   {
                     if(point1.equ(point2))   b = true;
             
                   }
                }
           }

             if(b)     
             newGe.leftToward();                                
         }

       if(ke.getKeyCode()==ke.VK_DOWN)
         {
            newGe.downToward(); 

            
            boolean b = false; 
            for(Point point : newGe.a)
             {
               if(point.Y>20)  b=true;
             }
         for(Geometry ge : al)
           {
             for(Point point1 : ge.a)
               {       
                for(Point point2 : newGe.a)
                   {
                     if(point1.equ(point2))   b = true;
             
                   }
                }
           }

         if(b)   newGe.returned();
         
         }

    if(ke.getKeyCode()==ke.VK_ENTER)
    {
     newGe.rotate();

     boolean b = false; 
     for(Point point : newGe.a)
             {
               if(point.Y>20)  b=true;
               if(point.X>10)  b=true;
               if(point.X<1)   b=true;
             }
     for(Geometry ge : al)
           {
             for(Point point1 : ge.a)
               {       
                for(Point point2 : newGe.a)
                   {
                     if(point1.equ(point2))   b = true;             
                   }
                }
           }

         if(b)   
           {
              int i;
              for(i=0;i<3;i++)
               newGe.rotate();
           }
       }  
    }

    public void keyReleased(KeyEvent ke)
     {       
     }
  public void  keyTyped(KeyEvent ke)
     {             
     }   
  
}