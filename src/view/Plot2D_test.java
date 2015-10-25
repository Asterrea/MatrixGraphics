package view;

import java.util.Random;
import java.util.ArrayList;

import javax.swing.*;
 
public class Plot2D_test {
    Random seed = new Random();
    final int SIZE = 8;
    final double MAX = 10.0;
    PlotPanel plotPanel;
    
    ArrayList<Double> x = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();
    
    // Add initial graph
    public JPanel initGraph(){
    	plotPanel = new PlotPanel(x,y);
    	return plotPanel;
    }
    
    public JPanel addPlot(double xInput, double yInput) {
        x.add(xInput);
        y.add(yInput);
        plotPanel.setData(x, y);
        return plotPanel;
    }
}