import java.awt.*;

public class test 
{
   public static void main(String[] args)
    {
        Frame frame = new Frame();
        Square aa = new Square();
        for(Point point : aa.a)
        frame.panel[point.Y - 1][point.X- 1].setBackground(Color.red);

        frame.panel[0][8].setBackground(Color.green);
    }
}