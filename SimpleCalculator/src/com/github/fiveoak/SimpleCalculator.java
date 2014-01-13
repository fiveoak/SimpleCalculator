package com.github.fiveoak;


//import org.apache.log4j.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
        LOGGER.info("Loading JFrame");
        JFrame frame = new CalculatorFrame();
        JButton myButton = new JButton("test");
        myButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                LOGGER.info("Button was clicked.");
            }
        });
        frame.add(myButton);

        ButtonsPanel buttonsPanel = new ButtonsPanel();
        frame.add(buttonsPanel.getPanel());

        frame.setVisible(true);
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

