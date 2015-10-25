package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.EquationController;

import static java.lang.Math.sqrt;

class PlotPanel extends JPanel {
    ArrayList<Double> x;
    ArrayList<Double> y;
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    final int PAD = 10;
    final boolean DEBUG = false;
    boolean line; 
    boolean polygon; 
    boolean firstTime; 
    String type;
    EquationController equation;
 
    public PlotPanel(ArrayList<Double> x, ArrayList<Double> y) {
        setData(x, y, false, false, null);
        setPreferredSize(new Dimension(700,600));
        
    }
    
    public void setEquation(EquationController equation){
    	this.equation = equation;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        double xScale = (w - 2*PAD)/(xMax - xMin);
        double yScale = (2*PAD - h)/(yMax - yMin);
        if(firstTime)
            System.out.printf("xScale = %.1f  yScale = %.1f%n",
                               xScale, yScale);
        Point2D.Double origin = new Point2D.Double(); // Axes origin.
        Point2D.Double offset = new Point2D.Double(); // Locate data.
        
        if(xMax < 0) {
            origin.x = w - PAD;
            offset.x = origin.x - xScale*xMax;
        } else if(xMin < 0) {
            origin.x = PAD - xScale*xMin;
            offset.x = origin.x;
        } else {
            origin.x = PAD;
            offset.x = PAD - xScale*xMin;
        }
        if(yMax < 0) {
            origin.y = PAD;
            offset.y = origin.y - yScale*yMax;
        } else if(yMin < 0) {
            origin.y = PAD - yScale*yMax;
            offset.y = origin.y;
        } else {
            origin.y = h - PAD;
            offset.y = PAD - yScale*yMax;
        }
        if(firstTime) {
            System.out.printf("origin = [%6.1f, %6.1f]%n", origin.x, origin.y);
            System.out.printf("offset = [%6.1f, %6.1f]%n", offset.x, offset.y);
        }
 
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, origin.y, w-PAD, origin.y));
        // Draw ordinate.
        g2.draw(new Line2D.Double(origin.x, PAD, origin.x, h-PAD));
        g2.setPaint(Color.red);
        // Mark origin.
        g2.fill(new Ellipse2D.Double(origin.x-2, origin.y-2, 4, 4));
 
        // Plot data if one or many points exist.
        if (!(x.isEmpty()) && !(y.isEmpty())){
	        g2.setPaint(Color.blue);
	        for(int i = 0; i < x.size(); i++) {
	            double x1 = offset.x + xScale*x.get(i);
	            double y1 = offset.y + yScale*y.get(i);
	            if(firstTime)
	                System.out.printf("i = %d  x1 = %6.1f  y1 = %.1f%n", i, x1, y1);
	            g2.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
	            String coor = "[" + (x.get(i)) +"," + (y.get(i))+"]";
	            g2.drawString(coor, (float)x1+3, (float)y1-3);
	        }
	        
	        // Draw Line
	        if(line){
	        	drawLine(g2, offset, w, h, polygon);
	        }
        }
        
        // Draw extreme data values.
        g2.setPaint(Color.black);
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        String s = String.format("%.1f", xMin);
        float width = (float)font.getStringBounds(s, frc).getWidth();
        double x = offset.x + xScale*xMin;
        g2.drawString(s, (float)x, (float)origin.y+lm.getAscent());
        s = String.format("%.1f", xMax);
        width = (float)font.getStringBounds(s, frc).getWidth();
        x = offset.x + xScale*xMax;
        g2.drawString(s, (float)x-width, (float)origin.y+lm.getAscent());
        s = String.format("%.1f", yMin);
        width = (float)font.getStringBounds(s, frc).getWidth();
        double y = offset.y + yScale*yMin;
        g2.drawString(s, (float)origin.x+1, (float)y+lm.getAscent());
        s = String.format("%.1f", yMax);
        width = (float)font.getStringBounds(s, frc).getWidth();
        y = offset.y + yScale*yMax;
        g2.drawString(s, (float)origin.x+1, (float)y);
        if(firstTime)
        	firstTime = false;
        
    }
    
    public void drawLine(Graphics2D g2, Point2D.Double offset, int w, int h, boolean polygon){
    	double x1, y1, x2, y2;
    	// Draw lines
        double xInc = (double)(w - 2*PAD)/(xMax-xMin);
        double scale = (double)(h - 2*PAD)/(yMax-yMin);
        g2.setPaint(Color.GREEN.darker());
        for(int i = 0; i < y.size(); i++){
        	if (i < y.size() - 1){
        		x1 = offset.x + x.get(i)*xInc;
        		y1 = offset.y - scale * y.get(i);
        		x2 = offset.x + x.get(i+1)*xInc;
        		y2 = offset.y - scale * y.get(i+1);
        		g2.draw(new Line2D.Double(x1, y1, x2, y2));
        	}
        	
        	if (type.equalsIgnoreCase("PARABOLA")){
        		if (equation.getOrientation().equalsIgnoreCase("VERTICAL")){
        			for(int j = 0; j <= 500; j++){
        				double vertParabola = sqrt(4 * equation.getMagnitude() * (j - y.get(0))) + x.get(0);
        				int X = (int) vertParabola;
        				g2.drawLine( (int) (offset.x + x.get(0)*xInc) + j, (int) (offset.y - scale * y.get(0)) - X, (int) (offset.x + x.get(0)*xInc) + j, (int) (offset.y - scale * y.get(0)) - X);
        				g2.drawLine( (int) (offset.x + x.get(0)*xInc) + j, (int) (offset.y - scale * y.get(0)) + X, (int) (offset.x + x.get(0)*xInc) + j, (int) (offset.y - scale * y.get(0)) + X);
        			}
        		}
        	}
        	
        	if (polygon){
        		x1 = offset.x + x.get(i)*xInc;
        		y1 = offset.y - scale * y.get(i);
        		x2 = offset.x + x.get(0)*xInc;
        		y2 = offset.y - scale * y.get(0);
        		g2.draw(new Line2D.Double(x1, y1, x2, y2));
        	}
        }
    }
    
    public void setData(ArrayList<Double> x, ArrayList<Double> y, boolean line, boolean polygon, String type) {
    	this.line = line;
    	this.polygon = polygon;
    	this.type = type;
    	
        if(x.size() != y.size()) {
            throw new IllegalArgumentException("x and y data arrays " +
                                               "must be same length.");
        }
        this.x = x;
        this.y = y;
        double[] xVals = getExtremeValues(x);
        xMin = xVals[0];
        xMax = xVals[1];
        if(DEBUG)
            System.out.printf("xMin = %5.1f  xMax = %5.1f%n", xMin, xMax);
        double[] yVals = getExtremeValues(y);
        yMin = yVals[0];
        yMax = yVals[1];
        if(DEBUG)
            System.out.printf("yMin = %5.1f  yMax = %5.1f%n", yMin, yMax);
        firstTime = DEBUG;
        
        // Check if the graph has no points
        if (xMin == Double.MAX_VALUE && xMax == -(Double.MAX_VALUE)){
        	xMin = -10;
        	xMax = 10;
        }
        if (yMin == Double.MAX_VALUE && yMax == -(Double.MAX_VALUE)){
        	yMin = -10;
        	yMax = 10;
        }
        
        // Offset the min and max of x and y axis if there is only one point
        if (xMin == xMax){
        	xMin -= 10;
        	xMax += 10;
        }
        if (yMin == yMax){
        	yMin -= 10;
        	yMax += 10;
        }
        
        // Show the correct origin if the min value exceeds 0 and vice versa.
        if (xMin > 0){
        	xMin = 0;
        } else if (xMax < 0){
        	xMax = 0;
        }
        if (yMin > 0){
        	yMin = 0;
        } else if (yMax < 0){
        	yMax = 0;
        }
        repaint();
    }
 
    private double[] getExtremeValues(ArrayList<Double> d) {
        double min = Double.MAX_VALUE;
        double max = -min;
        for(int i = 0; i < d.size(); i++) {
            if(d.get(i) < min) {
                min = d.get(i);
            }
            if(d.get(i) > max) {
                max = d.get(i);
            }
        }
        return new double[] { min, max };
    }
}