package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F7 extends AbstractFunction {
    public String functionName = "x^y";
    double x = 0;
    double y = 0;

    @Override
    public void getInputsAndDisplayResult() {
        String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
        y = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "y");
        String input =
                "INPUT:" +
                "\nx = " + x +
                "\ny = " + y + "\n\n";
        double result = calculateResult();
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
    }

    @Override
    public double calculateResult() {
        return x*y; //todo: replace with real result after function's implementation
    }

}
