package com.github.fiveoak;

import org.apache.log4j.BasicConfigurator;

/**
 * This is a really simple calculator using Swing in Java.
 * @author fiveoak
 *
 */
public final class SimpleCalculator {
    /**
     * Create and show the calculator GUI on the Swing event dispatch thread.
     */
    public static void createCalculatorGUI() {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController =
                new CalculatorController(calculatorView, calculatorModel);
    }

    /**
     * Entry point for the calculator application.
     * @param args Input arguments to the program (currently none).
     */
    public static void main(final String[] args) {
        //need to configure log4j for other class loggers to work
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

