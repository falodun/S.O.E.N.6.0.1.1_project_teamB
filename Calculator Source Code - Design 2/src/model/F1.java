package model;
import view.FunctionInputField;
import view.FunctionResultView;
import view.ReturnedInput;

public class F1 extends AbstractFunction {
    public String functionName = "arccos(x)";
    double x = 0;
    double result = 0;

    @Override
    public boolean getInputs() {
        String inputMessage = "Enter value for: x";
        ReturnedInput returnedInput = new FunctionInputField().getDoubleInput(functionName, inputMessage);
        x = returnedInput.input;
        return returnedInput.inputWasMade;
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
