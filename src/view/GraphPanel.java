package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.GraphInput;
import model.Plot2D;
 
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

      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
          SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	
        	Plot2D before = new Plot2D();
        	Plot2D after = new Plot2D();
        	GraphInput input = new GraphInput();
        	
            JFrame frame = new JFrame(TITLE);
            frame.setContentPane(new GraphPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(input);
            
            frame.add(before.getContent());
//            frame.add(before.getUIPanel());
            
            frame.add(after.getContent());
//            frame.add(after.getUIPanel());
            
            frame.pack();             			// "this" JFrame packs its components
            frame.setLocationRelativeTo(null);  // center the application window
            frame.setVisible(true);             // show it
         }
      });
   }
}