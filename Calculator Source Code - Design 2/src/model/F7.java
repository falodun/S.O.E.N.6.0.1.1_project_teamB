package model;
import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;

/**
 * This class F7 is used to find the power of a number
 * 
 * @author Himani Himani
 * @studentID 40109233
 *
 */

public class F7 extends AbstractFunction {
    public String functionName = "x^y";
    double x = 0;
    double y = 0;
    double result = 1;

	/**
	 * Get inputs from user through UI
	 * 
	 * @return the input from the user
	 */
    @Override
    public boolean getInputs() {
		String inputMessage = "Enter value for: x";
		ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
		x = returnedInput.input;
		if (returnedInput.inputWasMade) {
			inputMessage = "Enter value for: y";
			returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
			y = returnedInput.input;
		}
		return returnedInput.inputWasMade;
    }

	/**
	 * displays result in the UI
	 */
    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x +
                "\ny = " + y + "\n\n";
        if(result != 0) {
        	new FunctionResultView().showResult(functionName, input, "" + result);	
        } else {
        	new FunctionResultView().showResult(functionName, input, "" + "Error: Negative base can not have non-integer powers");
        }
        
    }


	/**
	 * calculate the result of power of a number
	 */
    @Override
    public void calculateResult() {
        		
		double minusY = y;
    	
    			//CASE 1: negative base values with fraction powers
				if(x < 0 && y % 1 != 0) {
					System.out.println("Error: Negative base can not have non-integer powers");
					result = 0;
				}else {
					
					//CASE 2: Power is a positive integer
					if(y % 1 == 0 && y > 0) { 
						for(int i = 1; i <= y; i++) {
							result *= x;
						}
					//CASE 3: Power is a negative integer
					}else if(y < 0 && y % 1 == 0) { 
					
						minusY = -1 * y;
						double root = findRoot(x, minusY);
						result = 1 / root;
						
					//CASE 4: Power is a fraction e.g. square root, cube root etc.	
					}else if(y % 1 != 0) { 
					
						//negative fraction power
						if(y < 0) {
														
							minusY = -1 * y;
															
							double root = findRoot(x, minusY);
													
							String xRoot = String.format("%.5f", root);
							root = Double.parseDouble(xRoot);
							
							result = 1 / root;
							
													
						//positive fraction power
						}else if(y >= 0) {
							
							
							double root = findRoot(x, minusY);
							
							System.out.println("reached here");
							
							String xString = String.format("%.5f", root);
							root = Double.parseDouble(xString);						
							result = root;	
						}
					}
				}
       
    }
    
    /**
	 * Returns the root of the base value
	 * 
	 * @param base whose power is to be calculated
	 * @param power the exponent value
	 * @return the root of the base argument
	 */
	double findRoot(double base, double power) {
		
		double resultOfRoot = 1;
		
		if(power >= 1) {
			double[] exponentialValue = findExponentialValue(base, power);
			
			resultOfRoot *= exponentialValue[0];
			power = exponentialValue[1]; 

		}
		
		//fraction power remaining
		if(power > 0 && power < 1) { 
			
			//formatting up to 5 decimal places
			String xString = String.format("%.5f", power);
			power = Double.parseDouble(xString);
			
			double[] fraction = getFractionPart(power);
						
			double denominator = root(base, fraction[1]); 

			resultOfRoot *= findExponentialValue(denominator, fraction[0]*fraction[1])[0];
		}
		
		return resultOfRoot;
	}
		
	/**
	 * Returns the array with fraction part
	 * 
	 * @param num 
	 * 
	 * @return the array of fraction parts
	 */
	public static double[] getFractionPart(double num) {
		double numerator = num;
		double denominator = 1;
		
		while(!((numerator * denominator) % 1 == 0)) 
		{
			denominator++;
		}
		double[] parts = {numerator, denominator};
		return parts;
	}
	
	/**
	 * Returns the closestRoot with precision
	 * 
	 * @param base
	 * @param denominator
	 * 
	 * @return the closest root 
	 */
	public static double root(double base, double denominator) { 
		double precision = 1;
		double closestRoot = findClosestRootWithPrecision(base, denominator, 0, precision); 
		while(base < findExponentialValue(closestRoot, denominator)[0] && precision > 0.0000000000001) {
			closestRoot -= precision;
			precision *= 0.1;
			closestRoot = findClosestRootWithPrecision(base, denominator, closestRoot, precision);
		}

		return closestRoot;
	}
	
	/**
	 * Returns the closest root with precision
	 * 
	 * @param base
	 * @param power
	 * @param closestRoot
	 * @param precision
	 * 
	 * @return the closest root with precision
	 */
	public static double findClosestRootWithPrecision(double base, double power, double closestRoot, double precision) {
		closestRoot +=precision;
		double[] temp = findExponentialValue(closestRoot, power);
		while(temp[0] < base) {
			closestRoot += precision;
			temp = findExponentialValue(closestRoot, power);
		}
		return closestRoot;
	}
	
	/**
	 * Returns the exponential value
	 * 
	 * @param base
	 * @param power
	 * 
	 * @return the parts of exponential value
	 */
	public static double[] findExponentialValue(double base, double power) {
		double result = 1;
		
		while(power > 0) {
			result *= base;
			power--;
			if(power < 1) {
				break;
			}
		}
		double[] parts = {result , power};
		return parts;
	}

}


