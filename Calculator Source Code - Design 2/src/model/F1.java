package model;

import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;

public class F1 extends AbstractFunction {
	public String functionName = "arccos(x)";
	double x = 0;
	int option = 0;
	double result = 0;
	final static double pi = 3.14159;
	final static double root3 = getSquareRoot(3.0);

	/**
	 * Get inputs from user through UI
	 * @return the input from the user
	 */
	@Override
	public boolean getInputs() {
		String inputMessage = "Enter value of x ";
		ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
		x = returnedInput.input; 
		return returnedInput.inputWasMade;
	}

	/**
	 * displays result in the UI
	 */
	@Override
	public void displayResult() {
		String input = "INPUT:" + "\nx = " + x + "\n\n";
		
		new FunctionResultView().showResult(functionName, input,
			"Radians : "+(String.format("%.5f", this.result)));
	}

	/**
	 * calculate the result of arc cosine of a number
	 */
	@Override
	public void calculateResult() {
		result = arcCosX(x);
	}

	
	/**
	 * Returns the arc cosine of a value. The returned angle is in the
	 * range 0.0 through pi; returns NaN if the argument is not in the
	 * range -1 to 1
	 * 
	 * @param x the value whose arc cosine is to be returned.
	 * @return the arc cosine of the argument
	 */
	public double arcCosX(double x) {
		
		if(x < -1 || x > 1)
		{
		   return Double.NaN;
		}
		double temp = getSquareRoot(1 - (x * x)) / x; // arcsin(x) = arctan(sqrt(1-(x*x)/x)
		result = x < 0 ? pi + arcTanx(temp) : arcTanx(temp); // radians value
		return result;
	}

	
	/**
	 * Returns the square root of a number
	 * 
	 * @param number whose square root is to be found
	 * @return the square root of the argument
	 */
	public static double getSquareRoot(double number) {
		double temp = 0;
		double sqrt = number / 2;
		while (temp != sqrt) {
			temp = sqrt;
			sqrt = (sqrt + (number / sqrt)) / 2;
		}
		return sqrt;
	}

	/**
	 * Returns the arc tangent of a value. 
	 * 
	 * @param x the value whose arc tangent is to be returned.
	 * @return the arc tangent of the argument
	 */
	public double arcTanx(double x) {
		boolean isXNegative = false;

		if (x < 0) {
			x = -x; // Using Symmetry
			isXNegative = true;
		}
		if (x > 1) {
			x = (pi / 2) - arcTanx(1 / x); // Use complementary angle
		} else if (x > 2 - root3) {
			x = pi / 6 + arcTanx((root3 * x - 1) / (root3 + x)); // Use an identity
		} else {
			x = x - (x * x * x) / 3 + (x * x * x * x * x) / 5; // Use the Polynomial
		}
		return isXNegative ? x * -1 : x;
	}
}
