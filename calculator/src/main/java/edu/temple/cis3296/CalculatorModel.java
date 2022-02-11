package edu.temple.cis3296;

/**
 * This is the model of this MVC implementation of a calculator.
 * It performs the functions of the calculator and keeps track
 * of what the user has entered.
 *
 * @author Tom Bylander
 */
public class CalculatorModel {
    /**
     * This is the numeric value of the number the user is entering,
     * or the number that was just calculated.
     */
    private double displayValue;

    /**
     * This is the previous value entered or calculated.
     */
    private double internalValue;

    /**
     * This is the String corresponding to what the user.
     * is entering
     */
    private String displayString;

    /**
     * This is the last operation entered by the user.
     */
    private String operation;

    /**
     * This is true if the next digit entered starts a new value.
     */
    private boolean start;

    /**
     * This is true if a decimal dot has been entered for the current value.
     */
    private boolean dot;

    /**
     * Initializes the instance variables.
     */
    public CalculatorModel() {
        displayValue = 0.0;
        displayString = "" + displayValue;
        internalValue = 0;
        dot = false;
        start = true;
        operation = "";
    }

    /**
     * @return the String value of what was just calculated
     * or what the user is entering
     */
    public String getValue() {
        return displayString;
    }

    /**
     * Updates the values maintained by the calculator based on the
     * button that the user has just clicked.
     *
     * @param text is the name of the button that the user has just clicked
     */
    public void update(String text) {
        if (start) {
            internalValue = displayValue;
            displayValue = 0;
            displayString = "";
            start = false;
            dot = false;
        }
        if (text.length() == 1 && "0123456789".indexOf(text) >= 0) {
            displayString += text;
            displayValue = Double.valueOf(displayString);
        } else if (text.equals(".")) {
            if (!dot) {
                dot = true;
                if (displayString.equals("")) {
                    displayString = "0";
                }
                displayString += ".";
            }
        } else {
            if (operation.equals("+")) {
                displayValue = operationAdd(internalValue, displayValue);
            } else if (operation.equals("-")) {
                displayValue = operationSubst(internalValue, displayValue);
            } else if (operation.equals("*")) {
                displayValue = operationMult(internalValue, displayValue);
            } else if (operation.equals("/")) {
                displayValue = operationDiv(internalValue, displayValue);
            } else if (operation.equals("%")){
                displayValue = operationPercent(displayValue);
            } else if (operation.equals("±")){
                displayValue = operationInverse(displayValue);
            } else if (operation.equals("C")){
                displayValue = operationClear();
            }
            displayString = "" + displayValue;
            internalValue = displayValue;
            operation = text;
            start = true;
        }
    }

    public double operationClear() { return 0.0; }

    public double operationAdd(double rhs, double lhs) {
        return lhs + lhs;
    }

    public double operationSubst(double rhs, double lhs) {
        return (lhs - rhs);
    }

    public double operationMult(double rhs, double lhs) {
        return rhs;
    }

    public double operationDiv(double rhs, double lhs) {
        return rhs;
    }

    public double operationPercent(double value) { return 0.1; }

    public double operationInverse(double value) { return -42.0; }


}
