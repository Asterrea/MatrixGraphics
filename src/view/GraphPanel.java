package view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
 
// Swing Program Template
@SuppressWarnings("serial")
public class GraphPanel extends JPanel {
   // Name-constants
   public static final int CANVAS_WIDTH = 1280;
   public static final int CANVAS_HEIGHT = 720;
   public static final String TITLE = "Matrix Graphics";
   // ......
 
   // private variables of GUI components
   // ......
 
   int[] input_data;
   
   /** Constructor to setup the GUI components */
   public GraphPanel() {
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
      
      //Mark data points
      
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame(TITLE);
            frame.setContentPane(new GraphPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();             // "this" JFrame packs its components
            frame.setLocationRelativeTo(null); // center the application window
            frame.setVisible(true);            // show it
         }
      });
   }
}