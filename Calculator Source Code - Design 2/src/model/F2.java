package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F2 extends AbstractFunction {
    public String functionName = "tan(x)";
    double x = 0;
    double result = 0;

    @Override
    public void getInputs() {
        x = new FunctionInputField().getDoubleInput(functionName, "Enter value for: x");
    }

    @Override
    public void displayResult() {
        String input = "INPUT:" +
                "\nx = " + x + "\n\n";
        new FunctionResultView().showResult(functionName, input, "" + result);
    }

    @Override
    public void calculateResult() {
        result = x*2; //todo: replace with real result after function's implementation
    }

}
