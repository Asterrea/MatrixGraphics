package model;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;
 
public class Plot2D {
    Random seed = new Random();
    final int SIZE = 8;
    final double MAX = 10.0;
    PlotPanel plotPanel;
 
    private double[] getData(double min, double max) {
        double[] d = new double[SIZE];
        for(int i = 0; i < SIZE; i++) {
            d[i] = min + seed.nextDouble()*(max - min);
            //System.out.printf("%5.1f ", d[i]);
        }
        //System.out.println();
        return d;
    }
 
    private JPanel getContent() {
        double[] x = getData(-MAX, MAX);
        double[] y = getData(-MAX, MAX);
        plotPanel = new PlotPanel(x, y);
        return plotPanel;
    }
 
    private JPanel getUIPanel() {
        JButton button = new JButton("change data");
        JRadioButton[] rbs = new JRadioButton[5];
        final ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(
                    group.getSelection().getActionCommand());
                double xMin = -MAX, xMax = MAX, yMin = -MAX, yMax = MAX;
                switch(index) {
                    case 0:
                        xMax = -5;
                        break;
                    case 1:
                        xMin = 5;
                        break;
                    case 2:
                        break;
                    case 3:
                        yMax = -5;
                        break;
                    case 4:
                        yMin = 5;
                }
                double[] x = getData(xMin, xMax);
                double[] y = getData(yMin, yMax);
                plotPanel.setData(x, y);
            }
        });
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String minus = "<html>\u2013";
        String[] ids = {
            "<html>\u2013x", "+x", "<html>+/\u2013x&y", "<html>\u2013y", "+y"
        };
        for(int i = 0; i < rbs.length; i++) {
            rbs[i] = new JRadioButton(ids[i], i == 2);
            rbs[i].setActionCommand(String.valueOf(i));
            group.add(rbs[i]);
            panel.add(rbs[i], gbc);
        }
        panel.setBorder(BorderFactory.createEtchedBorder());
        gbc.weightx = 1.0;
        panel.add(button, gbc);
        return panel;
    }
 
    public static void main(String[] args) {
        Plot2D test = new Plot2D();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.getContent());
        f.add(test.getUIPanel(), "Last");
        f.setSize(400,400);
        f.setLocation(50,50);
        f.setVisible(true);
    }
}
 
class PlotPanel extends JPanel {
    double[] x;
    double[] y;
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    final int PAD = 20;
    final boolean DEBUG = false;
    boolean firstTime;  // Set at end of setData method.
 
    public PlotPanel(double[] x, double[] y) {
        setData(x, y);
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        double xScale = (w - 2*PAD)/(xMax - xMin);
        double yScale = (h - 2*PAD)/(yMax - yMin);
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
            origin.y = h - PAD;
            offset.y = origin.y - yScale*yMax;
        } else if(yMin < 0) {
            origin.y = PAD - yScale*yMin;
            offset.y = origin.y;
        } else {
            origin.y = PAD;
            offset.y = PAD - yScale*yMin;
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