package com.github.fiveoak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;

/**
 * Contains the calculator controls and control setup.
 * @author fiveoak
 *
 */
public class CalculatorController {
    /**
     * Setup log4j logger for this class.
     */
    private static final Logger LOGGER =
            Logger.getLogger(CalculatorController.class);

    /**
     * Represents the calculators view, passed from the main method.
     */
    private CalculatorView calculatorView;

    /**
     * Represents the calculator's model, passed from the main method.
     */
    private CalculatorModel calculatorModel;

    /**
     * Index in the calculatorView.getFunctionButtons() returned array for
     * the equals button.
     */
    private static final int EQUAL_BUTTON_INDEX = 4;

    /**
     * Index in the calculatorView.getFunctionButtons() returned array for
     * the CLR button.
     */
    private static final int CLR_BUTTON_INDEX = 8;

    /**
     * Constructs a MVC Calculator controller object using the model and view.
     * @param calculatorView Reference to the calculator's view.
     * @param calculatorModel Reference to the calculator's model.
     */
    public CalculatorController(final CalculatorView calculatorView,
            final CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
        setupFunctionButtonListeners();
        setupDigitButtonListeners();
    }

    /**
     * Sets up the ActionListeners for the digit buttons.
     */
    private void setupDigitButtonListeners() {
        final JButton[] tempDigitButtons = calculatorView.getDigitButtons();
        final JTextPane expressionPane = calculatorView.getTextPane();

        for (final JButton j: tempDigitButtons) {
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent arg0) {
                    expressionPane.setText(
                            expressionPane.getText() + j.getText());
                }
            });
        }
    }

    /**
     * Sets up the ActionListeners for the function buttons.
     */
    private void setupFunctionButtonListeners() {
        final JButton[] tempFunctionButtons =
                calculatorView.getFunctionButtons();
        final JTextPane expressionPane = calculatorView.getTextPane();

        //Order of buttons: {'/', '*', '-', '.', '=', '+', '(', ')', CLR}

        for (final JButton j: tempFunctionButtons) {
            j.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(final ActionEvent arg0) {
                   //kinda hacky but want diff behavior for =/clr button
                   if (!j.getText().equals("CLR") && !j.getText().equals("=")) {
                       expressionPane.setText(
                               expressionPane.getText() + j.getText());
                   }

               }
            });
        }

        //equal button
        tempFunctionButtons[EQUAL_BUTTON_INDEX].addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent arg0) {
                    LOGGER.info("Expression Result: "
                        + calculatorModel.getResult(expressionPane.getText()));

            }
        });


        //clr button
        tempFunctionButtons[CLR_BUTTON_INDEX].addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent arg0) {
                    expressionPane.setText("");

            }
        });
    }


}
