package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	// Name-constants
	public static final int CANVAS_WIDTH = 600;
	public static final int CANVAS_HEIGHT = 600;
	public static final String TITLE = "Input Panel";
	
	/** Constructor to setup the GUI components */
	public InputPanel(){
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		// Set the border of the panel
		setBorder(new LineBorder(Color.BLACK));
	}
	
	/** The entry main() method */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new JFrame(TITLE);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new MainFrame());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
