package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EquationController;

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
    private JLabel lblInitial;
    private JLabel lblTrans;
    private JTextField inputInitial;
    private JTextField inputTrans;

    private List<Double> xValues;
    private List<Double> yValues;
    private List<double[][]> dataPoints;
    
    public OperationBox() {
    	
        //construct components
        btnTranspose = new JButton ("Translate");
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
        lblInitial = new JLabel("Initial Equation:");
        inputInitial = new JTextField(1);
        lblTrans = new JLabel("New Equation:");
        inputTrans = new JTextField(1);

        //adjust size and set layout
        setPreferredSize (new Dimension (550, 500));
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
        add (lblInitial);
        add (lblTrans);
        add (inputInitial);
        add (inputTrans);
        
        btnTranspose.setEnabled(false);
    	btnReflect.setEnabled(true);
    	btnRotate.setEnabled(true);
    	btnShear.setEnabled(true);
    	btnScale.setEnabled(true);
    	inputInitial.setEnabled(false);
    	inputInitial.setDisabledTextColor(Color.BLACK);
    	inputTrans.setEnabled(false);
    	inputTrans.setDisabledTextColor(Color.ORANGE);
    	
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
    	lblInitial.setBounds(10, 250, 85, 25);
    	lblTrans.setBounds(10, 360, 85, 25);
    	inputInitial.setBounds(150, 300, 300, 25);
    	inputTrans.setBounds(150, 400,300, 25);
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

        xValues = new ArrayList<Double>();
        yValues = new ArrayList<Double>();
        dataPoints = new ArrayList<double[][]>();
    }

	public void showActionListenerDemo(){               
	    	
			if(!btnTranspose.isEnabled()){
	    		inputInitial.setText("P " + xValues +"," + yValues);
	    	}
		
	        btnReflect.addActionListener(new CustomActionListener());
	        btnTranspose.addActionListener(new CustomActionListener());
	        btnRotate.addActionListener(new CustomActionListener());
	        btnScale.addActionListener(new CustomActionListener());
	        btnShear.addActionListener(new CustomActionListener());
	        
	        btnOK.addActionListener(new OperationListener());
	      
	}
	
	 public List<Double> getXValues(){
	    	return xValues;
	    }
	    public List<Double> getYValues(){
	    	return yValues;
	    }

		public List<double[][]> getDataPoints() {
			return dataPoints;
		}

		public void setDataPoints(List<double[][]> dataPoints) {
			this.dataPoints = dataPoints;
		}
		
		public void addDataPoints(double[][] dataPoints){
			this.dataPoints.add(dataPoints);
		}

	class OperationListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
			EquationController eq = new EquationController();

			if(e.getSource().equals(btnOK)){
				if(!btnTranspose.isEnabled()){
					eq.setDataPoints(dataPoints);
					eq.translate(Double.parseDouble(inputX.getText()),Double.parseDouble(inputY.getText()));
				}
			}
		}
	}
	class CustomActionListener implements ActionListener{
	    	
	        public void actionPerformed(ActionEvent e) {
	        	
	            if(e.getSource().equals(btnTranspose)){
	            	btnTranspose.setEnabled(false);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	            	lblX.show();
	            	inputX.show();
	            	inputY.show();
	            	lblY.show();
	            	lblScalar.hide();
	            	inputScalar.hide();
	            	lblDegree.hide();
	            	inputDegree.hide();
	            	rXAxis.hide();
	            	rYAxis.hide();
	            	rDegree90CC.hide();
	            	rDegree180.hide();
	            	rDegree90C.hide();
	
	            }else if(e.getSource().equals(btnScale)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(false);
	            	
	            	lblX.hide();
	            	inputX.hide();
	            	inputY.hide();
	            	lblY.hide();
	            	lblScalar.show();
	            	inputScalar.show();
	            	lblDegree.hide();
	            	inputDegree.hide();
	            	rXAxis.hide();
	            	rYAxis.hide();
	            	rDegree90CC.hide();
	            	rDegree180.hide();
	            	rDegree90C.hide();
	            	
	            	
	            }else if(e.getSource().equals(btnRotate)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(false);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	            	
	            	lblX.hide();
	            	inputX.hide();
	            	inputY.hide();
	            	lblY.hide();
	            	lblScalar.hide();
	            	inputScalar.hide();
	            	lblDegree.hide();
	            	inputDegree.hide();
	            	rXAxis.hide();
	            	rYAxis.hide();
	            	rDegree90CC.show();
	            	rDegree180.show();
	            	rDegree90C.show();
	            	
	            }else if(e.getSource().equals(btnReflect)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(false);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(true);
	            	btnScale.setEnabled(true);
	            	
	            	lblX.hide();
	            	inputX.hide();
	            	inputY.hide();
	            	lblY.hide();
	            	lblScalar.hide();
	            	inputScalar.hide();
	            	lblDegree.hide();
	            	inputDegree.hide();
	            	rXAxis.show();
	            	rYAxis.show();
	            	rDegree90CC.hide();
	            	rDegree180.hide();
	            	rDegree90C.hide();
	            	
	            }else if(e.getSource().equals(btnShear)){
	            	btnTranspose.setEnabled(true);
	            	btnReflect.setEnabled(true);
	            	btnRotate.setEnabled(true);
	            	btnShear.setEnabled(false);
	            	btnScale.setEnabled(true);
	            	
	            	lblX.hide();
	            	inputX.hide();
	            	inputY.hide();
	            	lblY.hide();
	            	lblScalar.hide();
	            	inputScalar.hide();
	            	lblDegree.show();
	            	inputDegree.show();
	            	rXAxis.hide();
	            	rYAxis.hide();
	            	rDegree90CC.hide();
	            	rDegree180.hide();
	            	rDegree90C.hide();
	            }
	        }
	}	
}
