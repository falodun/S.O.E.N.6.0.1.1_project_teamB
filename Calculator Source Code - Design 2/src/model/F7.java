package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F7 extends AbstractFunction {
    public String functionName = "x^y";
    double x = 0;
    double y = 0;
    double result = 1;

    @Override
    public void getInputs() {
        x = new FunctionInputField().getDoubleInput(functionName, "Enter value for: x");
        y = new FunctionInputField().getDoubleInput(functionName, "Enter value for: y");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x +
                "\ny = " + y + "\n\n";
        new FunctionResultView().showResult(functionName, input, "" + result);
    }

    @Override
    public void calculateResult() {
        		//CASE 1: negative base values with fraction powers
				if(x < 0 && y % 1 != 0) {
					System.out.println("Error: Negative base can not have non-integer powers");
				}else {
					
					//CASE 2: Power is a positive integer
					if(y % 1 == 0 && y > 0) { 
						for(int i = 1; i <= y; i++) {
							result *= x;
						}
					//CASE 3: Power is a negative integer
					}else if(y < 0 && y % 1 == 0) { 
					
						x = 1 / x;
						y = -1 * y;
						
						for(int i = 1; i <= y; i++) {
							result *= x;
						}
					//CASE 4: Power is a fraction e.g. square root, cube root etc.	
					}else if(y % 1 != 0) { 
					
						if(y < 0) {
							x = 1 / x;
							y = -1 * y;
							
							double root = findRoot(x, y);
							
							//formatting up to 5 decimal places
							DecimalFormat df = new DecimalFormat("#.#####");  
							root = Double.parseDouble(df.format(root));
							result = root;
						
						}else if(powerValue >= 0) {
							double root = findRoot(x, y);
							
							//formatting up to 5 decimal places
							DecimalFormat df = new DecimalFormat("#.#####");  
							root = Double.parseDouble(df.format(root));
							result = root;	
						}
					}
				}
       
    }
	
	double findRoot(double base, double power) {
		
		double resultOfRoot = 1;
		
		if(power >= 1) {
			double[] exponentialValue = findExponentialValue(base, power);
			
			resultOfRoot *= exponentialValue[0];
			power = exponentialValue[1]; 
		}
		
		//fraction power remaining
		if(power > 0 && power <1) { 
			
			//formatting up to 5 decimal places
			DecimalFormat df = new DecimalFormat("#.#####");  
			power = Double.parseDouble(df.format(power));
			
			double[] fraction = getFractionPart(power);
			double denominator = root(base, fraction[1]); 
			resultOfRoot *= findExponentialValue(denominator, fraction[0]*fraction[1])[0];
		}
		
		return resultOfRoot;
	}
		
	
	public static double[] getFractionPart(double num) {
		double numerator = num;
		double denominator = 1;
		while(!((numerator*denominator) % 1 == 0)) 
		{
			denominator++;
		}
		double[] parts = {numerator, denominator};
		return parts;
	}
	
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
	
	public static double findClosestRootWithPrecision(double base, double power, double closestRoot, double precision) {
		closestRoot +=precision;
		double[] temp = findExponentialValue(closestRoot, power);
		while(temp[0] < base) {
			closestRoot += precision;
			temp = findExponentialValue(closestRoot, power);
		}
		return closestRoot;
	}
	
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
