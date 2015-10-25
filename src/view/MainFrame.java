package view;

import java.awt.*;

import javax.swing.*;
 
// Swing Program Template
@SuppressWarnings("serial")
public class MainFrame extends JPanel {
   // Name-constants
   public static final int CANVAS_WIDTH = 1280;
   public static final int CANVAS_HEIGHT = 680;
   public static final String TITLE = "Matrix Graphics";

 
   int[] input_data;
   
   /** Constructor to setup the GUI components */
   public MainFrame() {
      setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
   }
 
   /** Custom painting codes on this JPanel */
   @Override
   public void paintComponent(Graphics g) {
	   
	   // paint background
      super.paintComponent(g);  
      setBackground(Color.BLACK);

      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	Plot2D_test test = new Plot2D_test();
        	
            JFrame frame = new JFrame(TITLE);
            frame.setContentPane(new MainFrame());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(test.initGraph());
            test.addPlot(5,5);
            test.addPlot(3, -2);
            test.addPlot(20, -20);
            test.addPlot(-13, 12);
            
            frame.pack();             // "this" JFrame packs its components
            frame.setLocationRelativeTo(null); // center the application window
            frame.setVisible(true);            // show it
         }
      });
   }
}
