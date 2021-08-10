package model;
import view.FunctionInputFieldForF5;
import view.FunctionResultView;
import view.ReturnedInput;

/**
 * Implement F5: ab^x function
 * @author Natheepan Ganeshamoorthy (Natt)
 *
 */
public class F5 extends AbstractFunction {
    public String functionName = "ab^x";
    public double a = 0;
    public double b = 0;
    public double x = 0;
    public double result = 0;
    public String errorMsg = "";

    /**
     * Get inputs from user for a, b, and x parameters for ab^x function
     */
    @Override
    public boolean getInputs() {
		String inputMessage = "Enter value for: a";
		ReturnedInput returnedInput = new FunctionInputFieldForF5().getDoubleInputForA(functionName, inputMessage);
		a = returnedInput.input;
		if (returnedInput.inputWasMade) {
			inputMessage = "Enter value for: b";
			returnedInput = new FunctionInputFieldForF5().getDoubleInputForB(functionName, inputMessage);
			b = returnedInput.input;
		}
		if (returnedInput.inputWasMade) {
			inputMessage = "Enter value for: x";
			returnedInput = new FunctionInputFieldForF5().getDoubleInput(functionName, inputMessage);
			x = returnedInput.input;
		}
		return returnedInput.inputWasMade;
    }

    /**
     * Show user the calculated value for ab^x function
     */
    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\na = " + a +
                "\nb = " + b +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(functionName, input, "" + result);
    }

    /**
     * Perform the calculation for ab^x function
     */
    @Override
    public void calculateResult() {
    	if(a == 0) 
    	{
    		errorMsg = "ERROR: INVALID INPUT. Parameter 'a' cannot be 0.";
    		return;
    	}else if(b == 0 || b < 0 || b == 1) 
    	{
    		errorMsg = "ERROR: INVALID INPUT. Parameter 'b' must be greater than 0, and cannot be 1.";
    		return;
    	}
        double xClone = x;
		boolean isNegative = xClone < 0;
		
		//when x = 0, b^0 = 1, therefore ab^x = a
		if(xClone == 0) {
			result = a;
		}
		//when x = 1, b^1 = b, therefore ab^x = ab
		else if(xClone == 1) {
			result = a*b;
		}
		else{
			//we have taken note of whether x is negative or positive.
			//we can now work with x as a positive number, then factor in later if it was negative
			if(isNegative) {
				xClone *= -1;
			}
			double res = a;
			//First we do the calculation for the integer value of x
			if(xClone >= 1) {
				double[] exponential = doExponentialFunctionForIntegerPartOfExponent(b, xClone);
				res *= !isNegative ? exponential[0] : 1 / exponential[0];
				xClone = exponential[1];
			}
			//Next, we do the calculation for the decimal value of x
			if(xClone>0 && xClone<1) {
				String xString = String.format("%.5f", xClone);
				xClone = Double.parseDouble(xString);
				double[] xFrac = getFraction(xClone);
				double expDeno = findNthRootOfY(b, xFrac[1]);
				res *= !isNegative ? doExponentialFunctionForIntegerPartOfExponent(expDeno, xFrac[0]*xFrac[1])[0] : 1 / doExponentialFunctionForIntegerPartOfExponent(expDeno, xFrac[0]*xFrac[1])[0];
			}
			
			result = res;
			printResult(a, b, x, result);
		}
    }
    
    /**
     * perform the Exponential Function for the integer part of exponent
     * @param b
     * @param x
     * @return
     */
    public double[] doExponentialFunctionForIntegerPartOfExponent(double b, double x) {
		double result = 1;
		while(x>0) 
		{
			//multiply b by the number of x's
			result*= b;
			x--;
			//stop when x is less than 1.
			if(x<1){
				break;
			}
		}
		//return result for b^x, and the remaining decimal value of exponent
		double[] ret = {result, x};
		return ret;
	}
	
    /**
     * check if a given number is an integer
     * @param num
     * @return
     */
	public boolean isInteger(double num) {
		return num % 1 == 0;
	}
	
	/**
	 * convert a decimal number into a fraction
	 * @param num
	 * @return
	 */
	public double[] getFraction(double num) {
		double numerator = num;
		double denominator = 1;
		while(!isInteger(numerator*denominator)) 
		{
			denominator++;
		}
		double[] ret = {numerator, denominator};
		return ret;
	}
	
	/**
	 * print the output of f(x) = ab^x
	 * @param a
	 * @param b
	 * @param x
	 * @param result
	 */
	public void printResult(double a, double b, double x, double result) {
		System.out.printf("f(x) = (%.3f)(%.3f)^(%.3f) = %.5f", a,b,x,result);
	}
	
	/**
	 * perform the nth root of a given number y
	 * reference: https://www.wikihow.com/Solve-Decimal-Exponents
	 * @param y
	 * @param n
	 * @return
	 */
	public double findNthRootOfY(double y, double n) {
		double percision = 1;
		double closestRoot = findClosestNthRootOfYWithPercision(y, n, 0, percision);
		while(y < doExponentialFunctionForIntegerPartOfExponent(closestRoot, n)[0] && percision > 0.0000000000001) 
		{
			closestRoot -= percision;
			percision *= 0.1;
			closestRoot = findClosestNthRootOfYWithPercision(y, n, closestRoot, percision);
		}
		return closestRoot;
	}

	/**
	 * perform the nth root of a given number y as close as possible to the precision specified 
	 * reference: https://www.wikihow.com/Solve-Decimal-Exponents
	 * @param number
	 * @param root
	 * @param closestRoot
	 * @param precision
	 * @return
	 */
	public double findClosestNthRootOfYWithPercision(double number, double root, double closestRoot, double precision) {
		closestRoot += precision;
		double[] temp = doExponentialFunctionForIntegerPartOfExponent(closestRoot, root);
		while(temp[0] < number) 
		{
			closestRoot += precision;
			temp = doExponentialFunctionForIntegerPartOfExponent(closestRoot, root);
		}
		return closestRoot;
	}
}