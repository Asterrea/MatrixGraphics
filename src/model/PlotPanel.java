package model;

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

import javax.swing.JPanel;

class PlotPanel extends JPanel {
    double[] x;
    double[] y;
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    final int PAD = 20;
    final boolean DEBUG = false;
    boolean polygon = true; // If set to true, the lines will close
    boolean firstTime;  // Set at end of setData method.
 
    public PlotPanel(double[] x, double[] y) {
        setData(x, y);
        setPreferredSize(new Dimension(400,400));
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
            origin.y = h- PAD;
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
 
        // Plot data.
        g2.setPaint(Color.blue);
        for(int i = 0; i < x.length; i++) {
            double x1 = offset.x + xScale*x[i];
            double y1 = offset.y + yScale*y[i];
            if(firstTime)
                System.out.printf("i = %d  x1 = %6.1f  y1 = %.1f%n", i, x1, y1);
            g2.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
            g2.drawString(String.valueOf(i), (float)x1+3, (float)y1-3);
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
            System.out.println("------------------------------");
        firstTime = false;
    }
 
    public void setData(double[] x, double[] y) {
        if(x.length != y.length) {
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
        repaint();
    }
 
    private double[] getExtremeValues(double[] d) {
        double min = Double.MAX_VALUE;
        double max = -min;
        for(int i = 0; i < d.length; i++) {
            if(d[i] < min) {
                min = d[i];
            }
            if(d[i] > max) {
                max = d[i];
            }
        }
        return new double[] { min, max };
    }
}