package model;

import java.awt.*;

import javax.swing.JPanel;

public class Parabola extends JPanel
{   

   double A = 1;
   double B = 0;
   double C = 0;
   
   public Parabola() {
	   setPreferredSize(new Dimension(500,500));
	   repaint();
   }
    public void paint(Graphics g)
    {   
        curve(g);
    }
    
    public void curve(Graphics g)
    {
       g.setColor(Color.red);
       for (double x=-10;x<=10;x = x+0.1)
       {
         double y = A*x*x+B*x+C;
         int xp = (int)Math.round(200 + x*20);
         int yp = (int)Math.round(200 - y*20); 
         g.fillOval(xp-2,yp-2,5,5); 
       }
    }
}
