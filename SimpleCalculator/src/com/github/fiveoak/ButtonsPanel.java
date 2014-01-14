package com.github.fiveoak;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

    private JButton periodButton;
    private JButton equalsButton;
    private JButton divButton;
    private JButton multButton;
    private JButton addButton;
    private JButton subButton;
    private JButton leftParensButton;
    private JButton rightParensButton;
    private JButton clearButton;

    /**
     * Constructor.
     */
    ButtonsPanel() {
        buttonsJPanel = new JPanel(new GridBagLayout());
        setupAndAddDigitButtons();
    }

    /**
     * Sets up the calculator's buttons for digits and adds them to
     * buttonsPanel.
     */
    private void setupAndAddDigitButtons() {
        calculatorDigitButtons = new JButton[NUM_DIGIT_BUTTONS];
        periodButton = new JButton(".");
        equalsButton = new JButton("=");
        divButton = new JButton("/");
        multButton = new JButton("*");
        addButton = new JButton("+");
        subButton = new JButton("-");
        leftParensButton = new JButton("(");
        rightParensButton = new JButton(")");
        clearButton = new JButton("CLR");



        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        for (int i = 0; i < NUM_DIGIT_BUTTONS; i++) {
            calculatorDigitButtons[i] = new JButton();
            calculatorDigitButtons[i].setText(Integer.toString(i));
        }

        //this is really horrible and temporary trying to get things lined up
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[7], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[8], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[9], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(divButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[4], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[5], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[6], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(multButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[1], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[2], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[3], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(subButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(calculatorDigitButtons[0], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(periodButton, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(equalsButton, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(addButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(leftParensButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(rightParensButton, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.5;
        buttonsJPanel.add(clearButton, gridBagConstraints);


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

    /**
     * Returns an array of references to the calculator control buttons.
     * @return Returns the following buttons in order: periodButton,
     * equalsButton, divButton, multButton, addButton,
     * subButton, leftParensButton, rightParensButton, clearButton.
     */
    public JButton[] getControlButtons() {
        return new JButton[]
                {periodButton, equalsButton, divButton, multButton, addButton,
                subButton, leftParensButton, rightParensButton, clearButton};
    }
}
