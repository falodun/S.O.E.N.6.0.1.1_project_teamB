package model;
import view.FunctionInputField;
import view.FunctionResultView;
import static constants.Constants.EULER;

public class F3 extends AbstractFunction {
    public String functionName = "sinh(x)";
    double x = 0;
    double result = 0;

    @Override
    public void getInputs() {
        x = new FunctionInputField().getDoubleInput(functionName, "Enter value for: x");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(functionName, input, String.format("%.5f", result));
    }

    @Override
    public void calculateResult() {
        result = sinH(x);
    }

    public double sinH(double x) {
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

        double wholePart = (long) exponent;
        double decimalPart = exponent%1;
        double remainingWhole = wholePart;
        double nextWhole;
        double copy;
        boolean firstLoop = true;
        double baseRaisedToNextTenthExponent = base;

        do {
            copy = remainingWhole;
            remainingWhole /= 10;
            nextWhole = copy%10;

            if (!firstLoop) {
                baseRaisedToNextTenthExponent = raise(baseRaisedToNextTenthExponent, 10);
            }

            result *= raise(baseRaisedToNextTenthExponent, nextWhole);
            firstLoop = false;
        } while (remainingWhole > 0);

        double remainingDecimal = decimalPart;
        double nextDecimal;
        double baseRootedToNextTenthRoot = base;

        for (long i = 1; i <= 20; i++) {
            copy = remainingDecimal;
            remainingDecimal = (remainingDecimal%0.1)*10;
            nextDecimal = (long) (copy/0.1);
            baseRootedToNextTenthRoot = nthRoot(baseRootedToNextTenthRoot, 10);
            result *= raise(baseRootedToNextTenthRoot, nextDecimal);
        }

        return isNegativeExponent ? 1/result : result;
    }

    private double raise(double base, double exponent) {
        double result = 1;

        if (exponent == 0) {
            return 1;
        }

        for (long i = 1; i <= exponent; i++) {
            result *= base;
        }

        return result;
    }

    public double nthRoot(double number, long n) {
        double result = 0;

        if (number == 0) {
            return 0;
        }

        double precision = 0.000000000000001;
        double oldGuess;
        double guess = 0;
        boolean endLoop = false;
        long index = 0;

        while (!endLoop) {
            oldGuess = guess;
            guess = precision*raise(10, index);

            if (raise(guess + result, n) < number) {
                index++;
            }
            else {
                if (index == 0) {
                    endLoop = true;
                }
                else {
                    result += oldGuess;
                    index = 0;
                }
            }
        }

        return result;
    }

}
