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
		
		double temporary;
		double root = base/2.0;
		
		do {
			
			temporary = root;
			root = (temporary + (base/temporary))/2.0 ;
			
		} while((temporary-root)!= 0);
		
		return root;
	}


	
}
