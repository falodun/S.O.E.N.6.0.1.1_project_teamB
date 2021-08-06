package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F5 extends AbstractFunction {
    public String functionName = "ab^x";
    double a = 0;
    double b = 0;
    double x = 0;
    double result = 0;

    @Override
    public void getInputs() {
        a = new FunctionInputField().getDoubleInput(functionName, "Enter value for: a");
        b = new FunctionInputField().getDoubleInput(functionName, "Enter value for: b");
        x = new FunctionInputField().getDoubleInput(functionName, "Enter value for: x");
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
        result = a*b*x; //todo: replace with real result after function's implementation
    }

}
