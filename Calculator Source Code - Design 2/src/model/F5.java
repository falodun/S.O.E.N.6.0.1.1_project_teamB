package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F5 extends AbstractFunction {
    public String functionName = "ab^x";
    String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
    double a = 0;
    double b = 0;
    double x = 0;
    double result = 0;

    @Override
    public void getInputs() {
        a = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "a");
        b = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "b");
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\na = " + a +
                "\nb = " + b +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
    }

    @Override
    public void calculateResult() {
        result = a*b*x; //todo: replace with real result after function's implementation
    }

}
