package Controller;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.ScientificCalculatorComponents;

public class CalculationForFunction4 implements ScientificCalculatorComponents.FunctionHandler{

	ScientificCalculatorComponents.FunctionHandler functionalHandler = this;
	JFrame frame;
	double baseValue;
	double powerValue;
	String result = "1.0";
	
	public void updateData(JFrame frame) {
		
		this.frame = frame;
		//JTextField displayedResult = (JTextField) frame.getContentPane().findComponentAt(10, 43);
		JTextField displayedValue = (JTextField) frame.getContentPane().getComponent(1);
		
		if(displayedValue.getText().isEmpty()) {
			displayedValue.setText("Select Base Value first");
			
		}else if(!(displayedValue.getText().equals("ERROR")) && !(displayedValue.getText().equals("-"))) {
			
			baseValue = Double.parseDouble(displayedValue.getText());
			displayedValue.setText("");
		}else {
			baseValue = 0.0;
			displayedValue.setText("");
		}
	}

	public String findResult(JFrame frame) {
		
		JTextField displayedValue = (JTextField) frame.getContentPane().getComponent(1);
		
		if(!displayedValue.getText().isEmpty()) {
			if(!displayedValue.getText().equals("ERROR") && !displayedValue.getText().equals("-")) {
				powerValue = Double.parseDouble(displayedValue.getText());
			}
		}else {
			displayedValue.setText("ERROR");
		}
		
		if(powerValue % 1 == 0 && powerValue > 0) { //for positive integer powers
			for(int i = 1; i <= powerValue; i++) {
				result = ""+(Double.parseDouble(result)*baseValue);
			}
		}else if(powerValue < 0 && powerValue % 1 == 0) { //for negative integer powers
			
			baseValue = 1 / baseValue;
			powerValue = -1 * powerValue;
			
			for(int i = 1; i <= powerValue; i++) {
				result = ""+(Double.parseDouble(result)*baseValue);
			}
		}else if(powerValue % 1 != 0) { //for non-integer powers e.g. square root, cube root etc.
			
			if(powerValue < 0) {
				baseValue = 1 / baseValue;
				powerValue = -1 * powerValue;
				
				double root = findRoot(baseValue, powerValue);
				result = ""+root;
				
			}else if(powerValue >= 0) {
				double root = findRoot(baseValue, powerValue);
				result = ""+root;	
			}
			
		}
		

		
		return result;
	}
	
	double findRoot(double base, double power) {
		
		double resultOfRoot = 1;
		
		if(power >= 1) {
			double[] exponential = doExponentialWithPrecision(base, power);
			resultOfRoot *= exponential[0];
			power = exponential[1]; 
		}
		
		if(power > 0 && power <1) { //fraction power remaining
			
			DecimalFormat df = new DecimalFormat("#.#####");  //formatting upto 5 decimal places
			power = Double.parseDouble(df.format(power));
			
			double[] fraction = getFraction(power);
			double denominator = root(base, fraction[1]); 
			resultOfRoot *= doExponentialWithPrecision(denominator, fraction[0]*fraction[1])[0];
		}
		
		return resultOfRoot;
	}
		
	
	public static double[] getFraction(double num) {
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
		while(base < doExponentialWithPrecision(closestRoot, denominator)[0] && precision > 0.0000000000001) {
			closestRoot -= precision;
			precision *= 0.1;
			closestRoot = findClosestRootWithPrecision(base, denominator, closestRoot, precision);
		}

		return closestRoot;
	}
	
	public static double findClosestRootWithPrecision(double base, double power, double closestRoot, double precision) {
		closestRoot +=precision;
		double[] temp = doExponentialWithPrecision(closestRoot, power);
		while(temp[0] < base) {
			closestRoot += precision;
			temp = doExponentialWithPrecision(closestRoot, power);
		}
		return closestRoot;
	}
	
	public static double[] doExponentialWithPrecision(double base, double power) {
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

