import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
  Panel[][] panel = new Panel[20][10];
  
  public Frame()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setLayout(new GridLayout(20,10));
      
      int i,j;
      for(i=0;i<20;i++)
        for(j=0;j<10;j++)
          {
            panel[i][j] = new Panel();
            panel[i][j].setBackground(Color.white);
                       
            getContentPane().add(panel[i][j]);
          }  
  
      setSize(310,530);
      setVisible(true);           
   }
    
}