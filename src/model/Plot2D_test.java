package model;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;
 
public class Plot2D_test {
    Random seed = new Random();
    final int SIZE = 8;
    final double MAX = 10.0;
    PlotPanel plotPanel;
 
    public double[] getData(double min, double max) {
        double[] d = new double[SIZE];
        for(int i = 0; i < SIZE; i++) {
            d[i] = min + seed.nextDouble()*(max - min);
            //System.out.printf("%5.1f ", d[i]);
        }
        //System.out.println();
        return d;
    }
 
    public JPanel getContent() {
        double[] x = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
        double[] y = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
        plotPanel = new PlotPanel(x, y);
        return plotPanel;
    }
 
    public JPanel getUIPanel() {
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
        Plot2D_test test = new Plot2D_test();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.getContent());
        f.add(test.getUIPanel(), "Last");
        f.setSize(400,400);
        f.setLocation(50,50);
        f.setVisible(true);
    }
}