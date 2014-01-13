package com.github.fiveoak;

/**
 * Data type for a calculator arithmetic expression, basically something like
 * "3 + 6 * 5 / 2".
 * @author fiveoak
 *
 */
public class CalculatorExpression {
    /**
     * String representing an arithmetic expression,
     * parsable by Dijkstra's Shunting-yard algorithm. Must only contain digits
     * and parenthesis.
     */
    private String inputExpression;

    /**
     * Empty constructor for an empty expression object.
     */
    public CalculatorExpression() {
        this("");
    }

    /**
     * Constructor with an initially provided input expression.
     * @param inputExpression String representing an arithmetic expression,
     * parsable by Dijkstra's Shunting-yard algorithm. Must only contain digits
     * and parenthesis.
     */
    public CalculatorExpression(final String inputExpression) {
        this.inputExpression = inputExpression;
    }

    /**
     * Returns the numerical result of the input arithmetic expression.
     * @return Numerical result of the input expression.
     */
    public double getResult() {
        double result = 0;
        //find rpn notation
        //calculate result using rpn notation
        //return result
        return result;
    }


    @Override
    public String toString() {
        return "CalculatorExpression [inputExpression=" + inputExpression + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((inputExpression == null) ? 0 : inputExpression.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CalculatorExpression other = (CalculatorExpression) obj;
        if (inputExpression == null) {
            if (other.inputExpression != null) {
                return false;
            }
        } else if (!inputExpression.equals(other.inputExpression)) {
            return false;
        }
        return true;
    }

}
