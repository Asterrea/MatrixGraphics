package view;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JPanel {
	// Name-constants
	public static final int CANVAS_WIDTH = 1280;
	public static final int CANVAS_HEIGHT = 680;
	public static final String TITLE = "Matrix Graphics";
	
	/** Constructor to setup the GUI components */
	public MainFrame(){
		// Create a layout
		GridBagLayout layout = new GridBagLayout();
		// Create a constraint for GridBagLayout (for padding)
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(0,0,0,10);
		
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		setLayout(layout);
		
		// Add the graph and input panel with the constraints
		add(new GraphPanel(), constraint);
		add(new InputPanel(), new GridBagConstraints());
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
