package model;
import view.FunctionInputField;
import view.FunctionResultView;

public class F5 extends AbstractFunction implements IFunction {
    public String functionName = "ab^x";
    double a = 0;
    double b = 0;
    double x = 0;

    @Override
    public void getInputsAndDisplayResult() {
        String selectedFunctionMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
        a = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "a");
        b = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "b");
        x = new FunctionInputField().getDoubleInput(selectedFunctionMessage, "x");
        String input =
                "INPUT:" +
                "\na = " + a +
                "\nb = " + b +
                "\nx = " + x + "\n\n";
        double result = calculateResult();
        new FunctionResultView().showResult(selectedFunctionMessage, input, "" + result);
    }

    @Override
    public double calculateResult() {
        return a*b*x; //todo: replace with real result after function's implementation
    }

}
