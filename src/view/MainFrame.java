package view;

import java.awt.*;


import javax.swing.*;

import model.Plot2D_test;
 
// Swing Program Template
@SuppressWarnings("serial")
public class MainFrame extends JPanel {
   // Name-constants
   public static final int CANVAS_WIDTH = 1280;
   public static final int CANVAS_HEIGHT = 680;
   public static final String TITLE = "Matrix Graphics";
   // ......
 
   // private variables of GUI components
   // ......
 
   int[] input_data;
   
   /** Constructor to setup the GUI components */
   public MainFrame() {
      setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      // "this" JPanel container sets layout
      // setLayout(new ....Layout());
 
      // Allocate the UI components
      // .....
 
      // "this" JPanel adds components
      // add(....)
 
      // Source object adds listener
      // .....
   }
 
   /** Custom painting codes on this JPanel */
   @Override
   public void paintComponent(Graphics g) {
	   
	   // paint background
      super.paintComponent(g);  
      setBackground(Color.BLACK);

      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
//    Draw lines.
//      double xInc = (double)(w - 2*PAD)/(data.length-1);
//      double scale = (double)(h - 2*PAD)/getMax();
//      
//      Mark data points
//      g2.setPaint(Color.RED);
//      for(int i = 0 ; i < data.length ; i++){
//    	  double x = PAD + i*xInc;
//    	  double y = h-PAD - scale*data[i];
//    	  g2.fill(new Ellipse2D.Double(x-2,y-2,4,4));
//      }
      
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	Plot2D_test test = new Plot2D_test();
        	Plot2D_test test2 = new Plot2D_test();
        	
            JFrame frame = new JFrame(TITLE);
            frame.setContentPane(new MainFrame());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(test.getContent());
            frame.add(test2.getContent());
            
            frame.pack();             // "this" JFrame packs its components
            frame.setLocationRelativeTo(null); // center the application window
            frame.setVisible(true);            // show it
         }
      });
   }
}