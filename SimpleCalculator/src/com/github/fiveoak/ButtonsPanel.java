package com.github.fiveoak;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

/**
 * Holds all calculator buttons for inputting digits
 * and controlling the calculator.
 * @author fiveoak
 *
 */
public class ButtonsPanel {
    /**
     * Setup log4j logger object.
     */
    private static final Logger LOGGER =
            Logger.getLogger(ButtonsPanel.class);

    /**
     * Holds the calculator buttons.
     */
    private JPanel buttonsJPanel;

    /**
     * Contains the an array of buttons 0-9 representing the calculator digits.
     */
    private JButton[] calculatorDigitButtons;

    /**
     * Number of digit buttons the calculator has (10 digits for numbers 0-9).
     */
    private static final int NUM_DIGIT_BUTTONS = 10;

    /**
     * Constructor.
     */
    ButtonsPanel() {
        buttonsJPanel = new JPanel();
        setupAndAddDigitButtons();
    }

    /**
     * Sets up the calculator's buttons for digits and adds them to
     * buttonsPanel.
     */
    private void setupAndAddDigitButtons() {
        calculatorDigitButtons = new JButton[NUM_DIGIT_BUTTONS];

        for (int i = 0; i < NUM_DIGIT_BUTTONS; i++) {
            calculatorDigitButtons[i] = new JButton();
            calculatorDigitButtons[i].setText(Integer.toString(i));
            buttonsJPanel.add(calculatorDigitButtons[i]);
        }
    }

    /**
     * Gets a reference to the JPanel containing the calculator buttons.
     * @return Returns a reference to the JPanel containing
     * the calculator buttons.
     */
    public JPanel getPanel() {
        return buttonsJPanel;
    }

    /**
     * Gets a reference to the calculator digit buttons.
     * @return Returns a reference to an array of JButtons representing the
     * digit buttons on the calculator.
     */
    public JButton[] getDigitButtons() {
        return calculatorDigitButtons;
    }
}
