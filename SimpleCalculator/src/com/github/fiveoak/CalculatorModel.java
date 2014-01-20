package com.github.fiveoak;
import org.apache.log4j.Logger;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains the calculator model and model setup.
 * @author fiveoak
 *
 */
public class CalculatorModel {

    /**
     * String representing the arithmetic expression, used in the
     * JEval evaluator.
     */
    private String expressionToCalculate;

    /**
     * JEval evaluator which returns an arithmetic result as a String from an
     * input arithmetic expression in a String object.
     */
    private static Evaluator expressionEvaluator = new Evaluator();

    /**
     * Error to be displayed if the input arithmetic expression is invalid.
     */
    private static final String EVALUATION_EXCEPTION_ERROR =
            "Error: Evaluation Exception";

    /**
     * Setup log4j logger for this class.
     */
    private static final Logger LOGGER =
            Logger.getLogger(CalculatorModel.class);

    /**
     * Empty constructor for the class.
     */
    public CalculatorModel() {
    }

    /**
     * Sets the input expression to the input string.
     * @param inputExpression Input arithmetic expression.
     */
    public void setExpression(final String inputExpression) {
        this.expressionToCalculate = inputExpression;
    }


    /**
     * Returns the numerical result of the input arithmetic expression. If an
     * error is encountered during evaluation, returns evaluationExceptionError.
     * @return Numerical result of the input expression, or
     * evaluationExceptionError.
     */
    public String getResult() {
        try {
            return expressionEvaluator.evaluate(
                    expressionToCalculate);
        } catch (EvaluationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LOGGER.error(EVALUATION_EXCEPTION_ERROR);
            return "Error: Evaluation Exception";
        }
    }

    /**
     * Returns the numerical result of the input arithmetic expression. If an
     * error is encountered during evaluation, returns evaluationExceptionError.
     * @param inputExpression Input arithmetic expression.
     * @return Numerical result of the input expression, or
     * evaluationExceptionError.
     */
    public String getResult(final String inputExpression) {
        this.expressionToCalculate = inputExpression;
        return getResult();
    }

}
