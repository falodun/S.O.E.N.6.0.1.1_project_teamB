package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F2 extends AbstractFunction {
    public String functionName = "tan(x)";
    double x = 0;

    @Override
    public void getInputsAndDisplayResult() {
        String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
        String input =
                "INPUT:" +
                "\nx = " + x + "\n\n";
        double result = calculateResult();
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
    }

    @Override
    public double calculateResult() {
        return x*2; //todo: replace with real result after function's implementation
    }

}
