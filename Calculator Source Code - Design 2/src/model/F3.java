package model;
import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;
import static constants.Constants.EULER;

public class F3 extends AbstractFunction {
    public String functionName = "sinh(x)";
    double x = 0;
    double result = 0;

    @Override
    public boolean getInputs() {
        String inputMessage = "Enter value for: x";
        ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
        x = returnedInput.input;
        return returnedInput.inputWasMade;
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(functionName, input, String.format("%.5f", result));
    }

    @Override
    public void calculateResult() {
        result = sinh(x);
    }

    public double sinh(double x) {
        double eulerRaisedToX = raiseBaseToExponent(EULER, x);
        return (eulerRaisedToX-(1/eulerRaisedToX))/2;
    }

    public double raiseBaseToExponent(double base, double exponent) {
        double result = 1;
        boolean isNegativeExponent = false;

        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            exponent *= -1;
            isNegativeExponent = true;
        }
        if (base < 0 && exponent%1 > 0) {
            return Double.NaN;
        }
        if (base == 1) {
            return 1;
        }

        double remainingWholes = (long) exponent;
        double remainingDecimals = modulus(exponent, 1, 14);
        double baseRaisedToNextTenthExponent = base;
        
        result *= raise(baseRaisedToNextTenthExponent, remainingWholes);
        
        if (result == Double.POSITIVE_INFINITY) {
    		return isNegativeExponent ? 1.0/result : result;
    	}

        double nextDecimal;
        double baseRootedToNextTenthRoot = base;
        long lengthOfDecimalPartProcessed = 100;

        for (long i = 1; i <= lengthOfDecimalPartProcessed; i++) {
            nextDecimal = (long) (remainingDecimals/0.1);
            remainingDecimals = modulus(remainingDecimals, 0.1, 14)*10;
            baseRootedToNextTenthRoot = nthRoot(baseRootedToNextTenthRoot, 10);
            result *= raise(baseRootedToNextTenthRoot, nextDecimal);
        }

        return isNegativeExponent ? 1.0/result : result;
    }

    private double raise(double base, double exponent) {
        double result = 1;

        if (exponent == 0 || base == 1) {
            return 1;
        }

        for (double i = 1; i <= exponent; i++) {
        	if (result == Double.POSITIVE_INFINITY) {
        		return result;
        	}
        	result *= base;
        }
        

        return result;
    }

    private double nthRoot(double number, long n) {
        double confirmedGuess = 0;

        if (number == 0) {
            return 0;
        }

        double precision = 0.000000000000001;
        double guess;
        boolean endLoop = false;
        long index = 0;

        while (!endLoop) {
            guess = precision*raise(10, index);
            double raisedGuess = raise(guess + confirmedGuess, n);

            if (raisedGuess < number) {
            	confirmedGuess += guess;
                index++;
            }
            else if (raisedGuess == number) {
                confirmedGuess += guess;
                endLoop = true;
            }
            else {
                if (index == 0) {
                    endLoop = true;
                }
                else {
                    index = 0;
                }
            }
        }

        return confirmedGuess;
    }

    private double modulus(double number, double divisor, long decimalPlace) {
        
    	double wholePart = (long) (number/divisor);
        double confirmedGuess = 0;
        double precision = 1/(raise(10, decimalPlace));
        double guess;
        boolean endLoop = false;
        long index = 0;

        while (!endLoop) {
            guess = precision*raise(10, index);
            double combinedGuess = guess + confirmedGuess + (wholePart*divisor);

            if (combinedGuess < number) {
            	confirmedGuess += guess;
                index++;
            }
            else if (combinedGuess == number) {
                confirmedGuess += guess;
                endLoop = true;
            }
            else {
                if (index == 0) {
                    endLoop = true;
                }
                else {
                    index = 0;
                }
            }
        }

        return confirmedGuess;
    }

}
