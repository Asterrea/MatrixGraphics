package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Matrix;
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
    private JTextArea inputInitial;
    private JTextArea inputTrans;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private List<Double> xValues;
    private List<Double> yValues;
    private List<double[][]> dataPoints;
    private List<double[][]> newPoints;
   
    private String typeObject;
    private Plot2D_test plot;

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
        lblInitial = new JLabel("Initial Point Matrix:");
        inputInitial = new JTextArea(5,5);
        lblTrans = new JLabel("New Point Matrix:");
        inputTrans = new JTextArea(5,5);
        scroll = new JScrollPane(inputInitial);
        scroll2 = new JScrollPane(inputTrans);

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
//        add (inputInitial); 
        add (scroll);
        add(scroll2);
//        add (inputTrans);
        
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
    	lblInitial.setBounds(10, 250, 150, 25);
    	lblTrans.setBounds(10, 360, 150, 25);
    	inputInitial.setBounds(150, 250, 300, 100);
    	scroll.setBounds(150,250,300,100);
    	inputTrans.setBounds(150, 400,300, 100);
    	scroll2.setBounds(150, 400, 300, 100);
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
        newPoints = new ArrayList<double[][]>();
    }

	public void showActionListenerDemo(EquationController eq){     
			
			for(int i = 0 ; i < dataPoints.size() ; i++){
				double data[][] = dataPoints.get(i);
				 for (int j = 0; j < data.length-1; j++) {
			            for (int k = 0; k < data[0].length; k++) {
			            	String point = ""+data[j][k] + "\n";
			            	inputInitial.append(point); 
			            }
				 }
				 inputInitial.append("\n");
			}
		
	        btnReflect.addActionListener(new CustomActionListener());
	        btnTranspose.addActionListener(new CustomActionListener());
	        btnRotate.addActionListener(new CustomActionListener());
	        btnScale.addActionListener(new CustomActionListener());
	        btnShear.addActionListener(new CustomActionListener());
	        
	        btnOK.addActionListener(new OperationListener());
	      
	}
	

	class OperationListener implements ActionListener {
		public void actionPerformed(ActionEvent e){

			EquationController eq = new EquationController();
			eq.setDataPoints(dataPoints);
			
			//DO OPERATIONS
			if(e.getSource().equals(btnOK)){
				if(!btnTranspose.isEnabled()){
					eq.translate(Double.parseDouble(inputX.getText()),Double.parseDouble(inputY.getText()));
					callFunction(eq);
				}else if(!btnScale.isEnabled()){
					eq.scale(Double.parseDouble((inputScalar.getText())));
					callFunction(eq);
				}else if(!btnRotate.isEnabled()){
//					if(e.getSource().equals(btnRotate)) inputTrans.setText(null);
					double degreeRotate = 0;
					if(rDegree90CC.isSelected()){
						degreeRotate = 90;
					}else if(rDegree180.isSelected()){
						degreeRotate = 180;
					}else if(rDegree90C.isSelected()){
						degreeRotate = -90;
					}
					eq.rotate_cc(degreeRotate);
					callFunction(eq);
				}else if(!btnReflect.isEnabled()){
//					if(e.getSource().equals(btnReflect)) inputTrans.setText(null);
					double x = 0 ,y = 0;
					if(rXAxis.isSelected()){
						callFunction(eq);
					}else if(rYAxis.isSelected()){
						x = -1; y = 1;
					}
					eq.reflect(x, y);
					callFunction(eq);
				}else if(!btnShear.isEnabled()){
//					if(e.getSource().equals(btnShear)) inputTrans.setText(null);
					eq.shearX(Double.parseDouble(inputDegree.getText()));
					callFunction(eq);
				}
			}
		}
	}
	
	private void plotNewGraph(){
		boolean line = false, polygon = false;
		
		if(typeObject.equalsIgnoreCase("POINT")){
			line = false;
			polygon = false;
		} else if (typeObject.equalsIgnoreCase("LINE") || typeObject.equalsIgnoreCase("PARABOLA") ||
					typeObject.equalsIgnoreCase("HYPERBOLA") || typeObject.equalsIgnoreCase("VECTOR")){
			line = true;
			polygon = false;
		} else if (typeObject.equalsIgnoreCase("ELLIPSE") || typeObject.equalsIgnoreCase("POLYGON")){
			line = true;
			polygon = true;
		}
		
		for(String rowLine : inputTrans.getText().split("\\n")){
			System.out.println(rowLine);
			double x = Double.parseDouble(rowLine);
			double y = Double.parseDouble(rowLine);
			plot.addPlot(x, y, line, polygon, typeObject);
			//add data point -> matrix
			double[][] data = {{x},{y},{1}};
			dataPoints.add(data);
		}
		
	}
		
	public double parseConvert(String[] s , int pos){
	    	return Double.parseDouble(s[s.length - pos]);
	}
	    
	private void callFunction(EquationController eq){
		for(int i = 0 ; i < eq.getOriginalMatrixPoints().size() ; i++){
			double data[][] = eq.getOriginalMatrixPoints().get(i).printMatrix();
			double newData[][] = eq.getNewMatrixPoints().get(i).printMatrix();
			 for (int j = 0; j < data.length-1; j++) {
		            for (int k = 0; k < data[0].length; k++) {
//		            	String point = ""+data[j][k] + "\n";
		            	String newPoints = "" + newData[j][k] + "\n";
//		            	inputInitial.append(point); 
		            	inputTrans.append(newPoints);
		            }
			 }
//			 inputInitial.append("\n");
			 inputTrans.append("\n");
		}
		plotNewGraph();
	}
	class CustomActionListener implements ActionListener{
	    	
	        public void actionPerformed(ActionEvent e) {
				
	            if(e.getSource().equals(btnTranspose)){
	            	inputTrans.setText(null);
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
	            	inputTrans.setText(null);
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
	            	inputTrans.setText(null);
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
	            	inputTrans.setText(null);
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
	            	inputTrans.setText(null);
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
		public List<Double> getXValues(){
	    	return xValues;
	    }
	
		public void setTypeObject(String typeObject) {
			this.typeObject = typeObject;
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
		public Plot2D_test getPlot() {
				return plot;
		}

		public void setPlot(Plot2D_test plot) {
				this.plot = plot;
		}
}
