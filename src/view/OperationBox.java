package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OperationBox extends JPanel{
    private JButton btnTranspose;
    private JButton btnScale;
    private JButton btnRotate;
    private JButton btnReflect;
    private JButton btnShear;
    private JLabel lblX;
    private JTextField inputX;
    private JLabel lblY;
    private JTextField inputY;
    private JButton btnOK;
    private JLabel lblScalar;
    private JTextField inputScalar;
    private JRadioButton rXAxis;
    private JRadioButton rYAxis;
    private JLabel lblDegree;
    private JTextField inputDegree;
    private JRadioButton rDegree90C;
    private JRadioButton rDegree90CC;
    private JRadioButton rDegree180;

    public OperationBox() {
        //construct components
        btnTranspose = new JButton ("Transpose");
        btnScale = new JButton ("Scale");
        btnRotate = new JButton ("Rotate");
        btnReflect = new JButton ("Reflect");
        btnShear = new JButton ("Shear");
        lblX = new JLabel ("X-Translation:");
        inputX = new JTextField (1);
        lblY = new JLabel ("Y-Translation:");
        inputY = new JTextField (1);
        btnOK = new JButton ("OK");
        lblScalar = new JLabel ("Scalar:");
        inputScalar = new JTextField (1);
        rXAxis = new JRadioButton ("X - Axis");
        rYAxis = new JRadioButton ("Y - Axis");
        lblDegree = new JLabel ("Angle in Degrees  (Clockwise):");
        inputDegree = new JTextField (1);
        rDegree90C = new JRadioButton ("90 Degrees (Clockwise)");
        rDegree90CC = new JRadioButton ("90 degrees (Counterclockwise)");
        rDegree180 = new JRadioButton ("180 Degrees");

        //adjust size and set layout
        setPreferredSize (new Dimension (550, 197));
        setLayout (null);

        //add components
        add (btnTranspose);
        add (btnScale);
        add (btnRotate);
        add (btnReflect);
        add (btnShear);
        add (lblX);
        add (inputX);
        add (lblY);
        add (inputY);
        add (btnOK);
        add (lblScalar);
        add (inputScalar);
        add (rXAxis);
        add (rYAxis);
        add (lblDegree);
        add (inputDegree);
        add (rDegree90C);
        add (rDegree90CC);
        add (rDegree180);
        
        btnTranspose.setEnabled(false);
    	btnReflect.setEnabled(true);
    	btnRotate.setEnabled(true);
    	btnShear.setEnabled(true);
    	btnScale.setEnabled(true);
    	
    	lblScalar.hide();
    	inputScalar.hide();
    	lblDegree.hide();
    	inputDegree.hide();
    	rXAxis.hide();
    	rYAxis.hide();
    	rDegree90CC.hide();
    	rDegree180.hide();
    	rDegree90C.hide();
    	
        //set component bounds (only needed by Absolute Positioning)
        btnTranspose.setBounds (5, 10, 100, 25);
        btnScale.setBounds (115, 10, 100, 25);
        btnRotate.setBounds (225, 10, 100, 25);
        btnReflect.setBounds (335, 10, 100, 25);
        btnShear.setBounds (445, 10, 100, 25);
        lblX.setBounds (145, 70, 85, 25);
        inputX.setBounds (255, 70, 125, 25);
        lblY.setBounds (145, 110, 85, 25);
        inputY.setBounds (255, 110, 125, 25);
        btnOK.setBounds (225, 160, 100, 25);
        lblScalar.setBounds (180, 90, 50, 25);
        inputScalar.setBounds (255, 90, 125, 25);
        rXAxis.setBounds (220, 65, 100, 25);
        rYAxis.setBounds (220, 105, 100, 25);
        lblDegree.setBounds (5, 80, 175, 30);
        inputDegree.setBounds (225, 80, 280, 30);
        rDegree90C.setBounds (25, 55, 170, 25);
        rDegree90CC.setBounds (25, 90, 215, 35);
        rDegree180.setBounds (25, 130, 100, 25);
    }

	public void showActionListenerDemo(){               
	    	
	        btnReflect.addActionListener(new CustomActionListener());
	        btnTranspose.addActionListener(new CustomActionListener());
	        btnRotate.addActionListener(new CustomActionListener());
	        btnScale.addActionListener(new CustomActionListener());
	        btnShear.addActionListener(new CustomActionListener());
	      
	}
	
	class CustomActionListener implements ActionListener{
	    	
	        public void actionPerformed(ActionEvent e) {
	        
	            if(e.getSource().equals(btnTranspose)){
	            	btnTranspose.setEnabled(false);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	
	            }else if(e.getSource().equals(btnScale)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(false);
	            	
	            }else if(e.getSource().equals(btnRotate)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(false);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	            	
	            }else if(e.getSource().equals(btnReflect)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(false);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	            	
	            }else if(e.getSource().equals(btnShear)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(false);
	            	btnScale.setEnabled(true);
	            	
	            }
	        }
	}	

    public static void main (String[] args) {
        JFrame frame = new JFrame ("");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new OperationBox());
        frame.pack();
        frame.setVisible (true);
    }
}
