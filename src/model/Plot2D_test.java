package model;

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
    
    public double[] getData(double min, double max) {
        double[] d = new double[SIZE];
        for(int i = 0; i < SIZE; i++) {
            d[i] = min + seed.nextDouble()*(max - min);
            //System.out.printf("%5.1f ", d[i]);
        }
        //System.out.println();
        return d;
    }
    
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
 
    public static void main(String[] args) {
        Plot2D_test test = new Plot2D_test();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.initGraph());
        
        test.addPlot(5, 5);
        test.addPlot(15, 15);
        f.setSize(400,400);
        f.setLocation(50,50);
        f.setVisible(true);
    }
}