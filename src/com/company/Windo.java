package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static java.lang.Math.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jcoia3498 on 3/6/2017.
 */

public class Windo extends JFrame {

    private JPanel chartPanel;

    public Windo() {
        super("XY Line Chart Example with JFreechart");

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Lotka-Volterra Graph";
        String xAxisLabel = "Time (years)";
        String yAxisLabel = "Population Number";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);

        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {
        double time = 6.28;

        double xray = 1; //number of prey
        double alpha = 1; //growth rate prey
        double beta = 1; //death rate prey

        double yankee = 1; //number of predator
        double gamma = 1; //growth rate predators
        double delta = 1; //death rate predators

        double xrate;
        double yrate;

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries xSeries = new XYSeries("Prey");
        XYSeries ySeries = new XYSeries("Predators");

        //This is the information that I need from the equations
        for (int i = 0; i < time; i++)
        {
            xrate = alpha*xray - beta*xray*yankee; //integrate this equation
            yrate = delta*xray*yankee - gamma*yankee; //integrate this too
            xSeries.add(xrate, i);
            ySeries.add(yrate,i);
        }

        /* xSeries.add(1.0, 2.0);
        xSeries.add(2.0, 3.0);
        xSeries.add(3.0, 2.5);
        xSeries.add(3.5, 2.8);
        xSeries.add(4.2, 6.0);

        ySeries.add(2.0, 1.0);
        ySeries.add(2.5, 2.4);
        ySeries.add(3.2, 1.2);
        ySeries.add(3.9, 2.8);
        ySeries.add(4.6, 3.0); */

        dataset.addSeries(xSeries);
        dataset.addSeries(ySeries);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Windo().setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}