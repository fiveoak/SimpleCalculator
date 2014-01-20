package com.github.fiveoak;


//import org.apache.log4j.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import org.apache.log4j.Logger;
//import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;

/**
 * This is a really simple calculator using Swing in Java.
 * @author fiveoak
 *
 */
public final class SimpleCalculator {
    /**
     * Setup log4j logger object.
     */
    private static final Logger LOGGER =
            Logger.getLogger(SimpleCalculator.class);

    /**
     * Create and show the calculator GUI on the Swing event dispatch thread.
     */
    public static void createCalculatorGUI() {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController =
                new CalculatorController(calculatorView, calculatorModel);

        //some simple tests - remove
        LOGGER.info(calculatorModel.getResult("2+3*2"));
        //LOGGER.info(calculatorModel.getResult("zsdxd"));

    }

    /**
     * Entry point for the calculator application.
     * @param args Input arguments to the program (currently none).
     */
    public static void main(final String[] args) {
        //setup log4j configuration
        BasicConfigurator.configure();

        //event dispatch thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createCalculatorGUI();
            }
        });

    }

    /**
     * Default constructor prevented for utility class.
     */
    private SimpleCalculator() {
        throw new UnsupportedOperationException();
    }


}

