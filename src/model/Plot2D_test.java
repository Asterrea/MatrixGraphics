package model;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.List;
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
}