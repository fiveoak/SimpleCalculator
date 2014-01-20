package com.github.fiveoak;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;

/**
 * Contains the calculator's view (in Swing) and view setup.
 * @author fiveoak
 *
 */
public class CalculatorView {

    /**
     * Setup log4j logger for this class.
     */
    private static final Logger LOGGER =
            Logger.getLogger(CalculatorView.class);

    /**
     * expressionTextArea is a JTextArea which
     * shows the calculator's arithmetic expression.
     */
    private JTextPane expressionTextPane;

    /**
     * Represents the entire outer frame of the GUI.
     * Holds the outerPanel immediately inside.
     */
    private JFrame outerFrame;

    /**
     * Takes up the entirety of the outerFrame. Contains the topPanel and
     * bottomPanel.
     */
    private JPanel outerPanel;

    /**
     * Contains the JTextPane showing the current input arithmetic expression.
     */
    private JPanel topPanel;

    /**
     * Contains all of the digit and function buttons controlling the
     * calculator.
     */
    private JPanel bottomPanel;

    /**
     * Order of buttons: {0, 1, 2, 3, 4, 5, 6, 7, 8}.
     */
    private JButton[] calculatorDigitButtons;

    /**
     * Order of buttons: {'/', '*', '-', '.', '=', '+', '(', ')', CLR}.
     */
    private JButton[] calculatorFunctionButtons;

    /**
     * Number of digit buttons.
     */
    private static final int NUM_DIGIT_BUTTONS = 10;

    /**
     * Number of function buttons.
     */
    private static final int NUM_FUNCTION_BUTTONS = 9;

    /**
     * Button representing the period (decimal point) in an input arithmetic
     * expression.
     */
    private JButton periodButton;

    /**
     * Button representing the equal sign which computes the current input
     * arithmetic expression.
     */
    private JButton equalsButton;

    /**
     * Button representing the division sign (/) in an input arithmetic
     * expression.
     */
    private JButton divButton;

    /**
     * Button representing the multiplication sign (*) in an input arithmetic
     * expression.
     */
    private JButton multButton;

    /**
     * Button representing the plus sign (+) in an input arithmetic expression.
     */
    private JButton addButton;

    /**
     * Button representing the minus sign (-) in an input arithmetic expression.
     */
    private JButton subButton;

    /**
     * Button representing the left parenthesis '(' in an input arithmetic
     * expression.
     */
    private JButton leftParensButton;

    /**
     * Button representing the right parenthesis ')' in an input arithmetic
     * expression.
     */
    private JButton rightParensButton;

    /**
     * Button representing the "CLR" button which clears the currently entered
     * arithmetic expression.
     */
    private JButton clearButton;

    /**
     * Default height for the outer JFrame.
     */
    private static final int DEFAULT_FRAME_HEIGHT = 200;

    /**
     * Default width for the outer JFrame.
     */
    private static final int DEFAULT_FRAME_WIDTH = 200;



    /**
     * Get the expression text area associated with the calculator view.
     * @return Returns JTextPane object associated with the calculator
     * view.
     */
    public JTextPane getTextPane() {
        return expressionTextPane;
    }

    /**
     * Constructor for the calculator view - creates the basic Swing GUI.
     */
    public CalculatorView() {
        outerFrame = new JFrame("Simple Calculator");
        outerPanel = new JPanel(new GridBagLayout());
        topPanel = new JPanel();
        bottomPanel = new JPanel(new GridBagLayout());
        setupOuterFrame();
        setupOuterPanel();
        setupTopPanel();
        setupBottomPanel();
        outerFrame.setVisible(true);
    }

    /**
     * Sets up the outer JFrame.
     */
    private void setupOuterFrame() {
        outerFrame.add(outerPanel, BorderLayout.CENTER);
        outerFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
    }

    /**
     * Sets up the outer JPanel.
     */
    private void setupOuterPanel() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        outerPanel.add(topPanel, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        outerPanel.add(bottomPanel, gridBagConstraints);

    }

    /**
     * Sets up the top panel.
     */
    private void setupTopPanel() {
        expressionTextPane = new JTextPane();
        expressionTextPane.setText("1+2");
        topPanel.add(expressionTextPane, BorderLayout.PAGE_START);
    }

    /**
     * Sets up the bottom panel.
     */
    private void setupBottomPanel() {
        setupButtons();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //line things up using the gridBag swing layout
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.5;
        bottomPanel.add(calculatorDigitButtons[7], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        bottomPanel.add(calculatorDigitButtons[8], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        bottomPanel.add(calculatorDigitButtons[9], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        bottomPanel.add(divButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        bottomPanel.add(calculatorDigitButtons[4], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        bottomPanel.add(calculatorDigitButtons[5], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        bottomPanel.add(calculatorDigitButtons[6], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        bottomPanel.add(multButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        bottomPanel.add(calculatorDigitButtons[1], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        bottomPanel.add(calculatorDigitButtons[2], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        bottomPanel.add(calculatorDigitButtons[3], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        bottomPanel.add(subButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        bottomPanel.add(calculatorDigitButtons[0], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        bottomPanel.add(periodButton, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        bottomPanel.add(equalsButton, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        bottomPanel.add(addButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        bottomPanel.add(leftParensButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        bottomPanel.add(rightParensButton, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        bottomPanel.add(clearButton, gridBagConstraints);
    }

    /**
     * Sets up the basic Swing GUI JButtons.
     */
    private void setupButtons() {
        calculatorDigitButtons = new JButton[NUM_DIGIT_BUTTONS];
        calculatorFunctionButtons = new JButton[NUM_FUNCTION_BUTTONS];

        divButton = new JButton("/");
        calculatorFunctionButtons[0] = divButton;
        multButton = new JButton("*");
        calculatorFunctionButtons[1] = multButton;
        subButton = new JButton("-");
        calculatorFunctionButtons[2] = subButton;
        periodButton = new JButton(".");
        calculatorFunctionButtons[3] = periodButton;
        equalsButton = new JButton("=");
        calculatorFunctionButtons[4] = equalsButton;
        addButton = new JButton("+");
        calculatorFunctionButtons[5] = addButton;
        leftParensButton = new JButton("(");
        calculatorFunctionButtons[6] = leftParensButton;
        rightParensButton = new JButton(")");
        calculatorFunctionButtons[7] = rightParensButton;
        clearButton = new JButton("CLR");
        calculatorFunctionButtons[8] = clearButton;


        for (int i = 0; i < NUM_DIGIT_BUTTONS; i++) {
            calculatorDigitButtons[i] = new JButton();
            calculatorDigitButtons[i].setText(Integer.toString(i));
        }
    }

    /**
     * Order of buttons: {0, 1, 2, 3, 4, 5, 6, 7, 8}.
     * @return Array of JButton references to digit buttons.
     */
    public JButton[] getDigitButtons() {
        return calculatorDigitButtons;
    }

    /**
     * Order of buttons: {'/', '*', '-', '.', '=', '+', '(', ')', CLR}.
     * @return Array of JButton references to function buttons.
     */
    public JButton[] getFunctionButtons() {
        return calculatorFunctionButtons;
    }

    /**
     * Get the number of digit buttons.
     * @return Returns the number of digit buttons as an integer.
     */
    public int getNumDigitButtons() {
        return NUM_DIGIT_BUTTONS;
    }

    /**
     * Get the number of function buttons.
     * @return Returns the number of function buttons as an integer.
     */
    public int getNumFunctionButtons() {
        return NUM_FUNCTION_BUTTONS;
    }

}
