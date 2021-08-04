package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F7 extends AbstractFunction {
    public String functionName = "x^y";
    String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
    double x = 0;
    double y = 0;
    double result = 0;

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
        result = x*y; //todo: replace with real result after function's implementation
    }

}
