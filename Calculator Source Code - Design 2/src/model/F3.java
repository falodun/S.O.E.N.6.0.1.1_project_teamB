package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F3 extends AbstractFunction {
    public String functionName = "sinh(x)";
    String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
    double x = 0;
    double result = 0;

    @Override
    public void getInputs() {
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
    }

    @Override
    public void calculateResult() {
        result = x*2; //todo: replace with real result after function's implementation
    }

}
