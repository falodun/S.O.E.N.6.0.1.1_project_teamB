package model;
import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;

public class F5 extends AbstractFunction {
    public String functionName = "ab^x";
    double a = 0;
    double b = 0;
    double x = 0;
    double result = 0;

    @Override
    public boolean getInputs() {
		String inputMessage = "Enter value for: a";
		ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
		a = returnedInput.input;
		if (returnedInput.inputWasMade) {
			inputMessage = "Enter value for: b";
			returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
			b = returnedInput.input;
		}
		if (returnedInput.inputWasMade) {
			inputMessage = "Enter value for: x";
			returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
			x = returnedInput.input;
		}
		return returnedInput.inputWasMade;
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\na = " + a +
                "\nb = " + b +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(functionName, input, "" + result);
    }

    @Override
    public void calculateResult() {        
        double xClone = x;

		boolean isNegative = xClone < 0;
		if(xClone == 0) {
			result = a;
//			printResult(a, b, xClone, a);
		}
		else if(xClone == 1) {
			result = a*b;
//			printResult(a, b, xClone, a*b);
		}
		else{
			if(isNegative) {
				xClone *= -1;
			}
			double res = a;
			if(xClone >= 1) {
				double[] exponential = doExponential(b, xClone);
				res *= !isNegative ? exponential[0] : 1 / exponential[0];
				xClone = exponential[1];
			}
			if(xClone>0 && xClone<1) {
				String xString = String.format("%.5f", xClone);
				xClone = Double.parseDouble(xString);
				double[] xFrac = getFraction(xClone);
				double expDeno = root(b, xFrac[1]);
				res *= !isNegative ? doExponential(expDeno, xFrac[0]*xFrac[1])[0] : 1 / doExponential(expDeno, xFrac[0]*xFrac[1])[0];
			}
			
			result = res;
//			printResult(a, b, x, result);
		}
    }
    
    public double[] doExponential(double b, double x) {
		double result = 1;
		while(x>0) 
		{
			result*= b;
			x--;
			if(x<1){
				break;
			}
		}
		double[] ret = {result, x};
		return ret;
	}
	
	public boolean isInteger(double num) {
		return num % 1 == 0;
	}
	
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
	
//	public void printResult(double a, double b, double x, double result) {
//		System.out.printf("f(x) = (%.3f)(%.3f)^(%.3f) = %.5f", a,b,x,result);
//	}
	
	public double root(double number, double root) {
		double percision = 1;
		double closestRoot = findClosestRootWithPercision(number, root, 0, percision);
		while(number < doExponential(closestRoot, root)[0] && percision > 0.0000000000001) 
		{
			closestRoot -= percision;
			percision *= 0.1;
			closestRoot = findClosestRootWithPercision(number, root, closestRoot, percision);
		}
//		System.out.println(root + " root of " + number + " is = " + closestRoot);
		return closestRoot;
	}

	public double findClosestRootWithPercision(double number, double root, double closestRoot, double percision) {
		closestRoot += percision;
		double[] temp = doExponential(closestRoot, root);
		while(temp[0] < number) 
		{
			closestRoot += percision;
			temp = doExponential(closestRoot, root);
		}
		return closestRoot;
	}
}