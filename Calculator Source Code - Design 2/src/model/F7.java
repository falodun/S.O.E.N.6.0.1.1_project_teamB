package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F7 extends AbstractFunction {
    public String functionName = "x^y";
    String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
    double x = 0;
    double y = 0;
    double result = 1;

    @Override
    public void getInputs() {
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
        y = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "y");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x +
                "\ny = " + y + "\n\n";
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
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

}
