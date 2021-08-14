package model;
import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;
import static constants.Constants.EULER;

/**
 * Class F3 implements the sinh(x) function
 * @author Adekunle Falodun
 */
public class F3 extends AbstractFunction {
	
	/**
     * String variable functionName
     */
    public String functionName = "sinh(x)";
    
    /**
     * double variable input
     */
    private double input = 0;
    
    /**
     * double variable result
     */
    private double result = 0;

    /**
     * Concrete Method getInputs gets user inputs
     * @return ReturnedInput
     */
    @Override
    public ReturnedInput getInputs() {
        String inputMessage = "Enter value for: x";
        ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
        input = returnedInput.input;
        return returnedInput;
    }

    /**
     * Concrete Method displayResult displays result of the function's calculation
     */
    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + this.input + "\n\n";
        new FunctionResultView().showResult(functionName, input, String.format("%.5f", result));
    }

    /**
     * Concrete Method calculateResult calculates the function's result
     */
    @Override
    public void calculateResult() {
        result = sinh(input);
    }

    /**
     * Method sinh, computes the sinh of a variable
     * @param x  variable for sinh
     * @return double
     */
    public double sinh(double x) {
        double eulerRaisedToX = raiseBaseToExponent(EULER, x);
        return (eulerRaisedToX-(1/eulerRaisedToX))/2;
    }

    /**
     * Method raiseBaseToExponent, raises a base number to an exponent
     * @param base   stores value for base
     * @param exponent   stores value for exponent
     * @return double
     */
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
        
        result *= multiplyBaseByItselfNTimes(base, remainingWholes);
        
        if (result == Double.POSITIVE_INFINITY) {
    		return isNegativeExponent ? 1.0/result : result;
    	}

        double nextDecimal;
        double baseRootedToNextTenthRoot = base;
        long lengthOfDecimalPartProcessed = 100;

        for (long i = 1; i <= lengthOfDecimalPartProcessed; i++) {
        	//the decimal part of the exponent is a root of the base
        	//and can be processed one digit at a time.
            nextDecimal = (long) (remainingDecimals/0.1);
            remainingDecimals = modulus(remainingDecimals, 0.1, 14)*10;
            //the root for a decimal digit is the tenth-root for the root for the next decimal digit on its left
            baseRootedToNextTenthRoot = nthRoot(baseRootedToNextTenthRoot, 10);//tenth root
            result *= multiplyBaseByItselfNTimes(baseRootedToNextTenthRoot, nextDecimal);
        }

        return isNegativeExponent ? 1.0/result : result;
    }

    /**
     * Method multiplyBaseByItselfNTimes, multiplies a base number by itself n times
     * @param base   stores value for base
     * @param n   stores value for n
     * @return double
     */
    private double multiplyBaseByItselfNTimes(double base, double n) {
        double result = 1;

        if (n == 0 || base == 1) {
            return 1;
        }

        for (double i = 1; i <= n; i++) {
        	result *= base;
        	if (result == Double.POSITIVE_INFINITY) {
        		return result;
        	}
        }
        

        return result;
    }

    /**
     * Method nthRoot, does the nth-root of a number
     * @param number  stores the number whose nth-root is to be calculated
     * @param n   stores a number that specifies the root
     * @return double
     */
    private double nthRoot(double number, long n) {
        double confirmedGuess = 0;

        if (number == 0) {
            return 0;
        }

        double precision = 0.000000000000001;
        double guess;
        long index = 0;

        while (true) {
            guess = precision* multiplyBaseByItselfNTimes(10, index);//minimum guess when index is 0
            double raisedGuess = multiplyBaseByItselfNTimes(guess + confirmedGuess, n);

            if (raisedGuess < number) {
            	confirmedGuess += guess;
                index++;
            }
            else if (raisedGuess == number) {
                confirmedGuess += guess;
                break;
            }
            else {
                if (index == 0) {
                    break;
                }
                else {
                    index = 0;
                }
            }
        }

        return confirmedGuess;
    }

    /**
     * Method modulus, returns the remainder of a division
     * @param number stores the number to be divided
     * @param divisor   stores the divisor
     * @param decimalPlace   stores the number of decimal places to be used for the result
     * @return double
     */
    private double modulus(double number, double divisor, long decimalPlace) {
    	double wholePart = (long) (number/divisor);
        double confirmedGuess = 0;
        double precision = 1/(multiplyBaseByItselfNTimes(10, decimalPlace));
        double guess;
        long index = 0;

        while (true) {
            guess = precision* multiplyBaseByItselfNTimes(10, index);//minimum guess when index is 0
            double combinedGuess = guess + confirmedGuess + (wholePart*divisor);

            if (combinedGuess < number) {
            	confirmedGuess += guess;
                index++;
            }
            else if (combinedGuess == number) {
                confirmedGuess += guess;
                break;
            }
            else {
                if (index == 0) {
                    break;
                }
                else {
                    index = 0;
                }
            }
        }

        return confirmedGuess;
    }

}
