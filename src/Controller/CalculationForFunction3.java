package Controller;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.ScientificCalculatorComponents;
import Model.ScientificCalculatorComponents.FunctionHandler;

public class CalculationForFunction3 implements FunctionHandler{

	ScientificCalculatorComponents.FunctionHandler functionalHandler = this;
	JFrame frame;
	double a;
	double b;
	double x;
	String resultValue = "1.0";
	
	public void updateData(JFrame frame) {
		
		this.frame = frame;
		JTextField displayedValue = (JTextField) frame.getContentPane().getComponent(1);
		
		if(displayedValue.getText().isEmpty()) {
			displayedValue.setText("Select Base Value first");
			
		}else if(!(displayedValue.getText().equals("ERROR")) && !(displayedValue.getText().equals("-"))) {
			
			if(!displayedValue.getText().contains(",")) {
				a = Double.parseDouble(displayedValue.getText());
				displayedValue.setText("please enter values of b,x");
			}else {
				b = Double.parseDouble(displayedValue.getText().substring(0, displayedValue.getText().indexOf(",")));
				x = Double.parseDouble(displayedValue.getText().substring(displayedValue.getText().indexOf(",")+1));
				
			}
			
		}else {
		
			displayedValue.setText("");
		}
	}

	public String findResult(JFrame frame) {
		
		double xClone = x;

		boolean isNegative = x < 0;
		if(x == 0) {
			printResult(a, b, x, a);
		}
		else if(x == 1) {
			printResult(a, b, x, a*b);
		}
		else{
			if(isNegative) {
				x *= -1;
			}
			double result = a;
			if(x >= 1) {
				double[] exponential = doExponential(b, x);
				result *= !isNegative ? exponential[0] : 1 / exponential[0];
				x = exponential[1];
			}
			if(x>0 && x<1) {
				DecimalFormat df = new DecimalFormat("#.#####");
				x = Double.parseDouble(df.format(x));
				double[] xFrac = getFraction(x);
				double expDeno = root(b, xFrac[1]);
				result *= !isNegative ? doExponential(expDeno, xFrac[0]*xFrac[1])[0] : 1 / doExponential(expDeno, xFrac[0]*xFrac[1])[0];
			}
			printResult(a, b, xClone, result);
			resultValue = ""+result;
		}
		
		return resultValue;
	}
	
	public static double[] doExponential(double b, double x) {
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
	
	public static boolean isInteger(double num) {
		return num % 1 == 0;
	}
	
	public static double[] getFraction(double num) {
		double numerator = num;
		double denominator = 1;
		while(!isInteger(numerator*denominator)) 
		{
			denominator++;
		}
		double[] ret = {numerator, denominator};
		return ret;
	}
	
	public static void printResult(double a, double b, double x, double result) {
		System.out.println(a + ", " + b + ", " + x+ ", " + result);
	}
	
	public static double root(double number, double root) {
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

	public static double findClosestRootWithPercision(double number, double root, double closestRoot, double percision) {
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
