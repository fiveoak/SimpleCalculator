package com.github.fiveoak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;

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

    private JFrame outerFrame;
    private JPanel outerPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;

    /**
     * Order of buttons: {0, 1, 2, 3, 4, 5, 6, 7, 8}
     */
    private JButton[] calculatorDigitButtons;

    /**
     * Order of buttons: {'/', '*', '-', '.', '=', '+', '(', ')', CLR}
     */
    private JButton[] calculatorFunctionButtons;
    private static final int NUM_DIGIT_BUTTONS = 10;
    private static final int NUM_FUNCTION_BUTTONS = 9;
    private JButton periodButton;
    private JButton equalsButton;
    private JButton divButton;
    private JButton multButton;
    private JButton addButton;
    private JButton subButton;
    private JButton leftParensButton;
    private JButton rightParensButton;
    private JButton clearButton;

    private static final int DEFAULT_FRAME_HEIGHT = 200;
    private static final int DEFAULT_FRAME_WIDTH = 200;



    /**
     * Get the expression text area associated with the calculator view.
     * @return Returns JTextPane object associated with the calculator
     * view.
     */
    public JTextPane getTextPane()
    {
        return expressionTextPane;
    }

    public CalculatorView()
    {
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

    private void setupOuterFrame()
    {
        outerFrame.add(outerPanel,BorderLayout.CENTER);
        outerFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
    }

    private void setupOuterPanel()
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        outerPanel.add(topPanel, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        outerPanel.add(bottomPanel, gridBagConstraints);

    }

    private void setupTopPanel()
    {
        expressionTextPane = new JTextPane();
        expressionTextPane.setText("1+2");
        topPanel.add(expressionTextPane, BorderLayout.PAGE_START);
    }

    private void setupBottomPanel()
    {
        setupButtons();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        //temporary to line things up
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

    private void setupButtons()
    {
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
     * Order of buttons: {0, 1, 2, 3, 4, 5, 6, 7, 8}
     * @return Array of JButton references to digit buttons
     */
    public JButton[] getDigitButtons()
    {
        return calculatorDigitButtons;
    }

    /**
     * Order of buttons: {'/', '*', '-', '.', '=', '+', '(', ')', CLR}
     * @return Array of JButton references to function buttons
     */
    public JButton[] getFunctionButtons()
    {
        return calculatorFunctionButtons;
    }

    public int getNumDigitButtons()
    {
        return NUM_DIGIT_BUTTONS;
    }

    public int getNumFunctionButtons()
    {
        return NUM_FUNCTION_BUTTONS;
    }

}
