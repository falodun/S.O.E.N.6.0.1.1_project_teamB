package functions;
import javax.swing.JOptionPane;

public class F2 extends AbstractFunction {
    public String functionName = "tan(x)";

    @Override
    public void getInputsAndDisplayResult() {
        //todo: modify this basic implementation
        String functionNameMessage = "SELECTED FUNCTION: " + functionName + "\n\n";
        String message = functionNameMessage + "Enter value for x";
        String response = JOptionPane.showInputDialog(message);
        if ((response != null) && (response.length() > 0)) {
            try {
                double x = Double.parseDouble(response);
                double result = calculateF2(x);
                message = functionNameMessage + "Result: " + result;
                JOptionPane.showMessageDialog(null, message);
            }
            catch (Exception e) {
                //e.printStackTrace();
                message = "ERROR: INVALID INPUT\nA real number is expected";
                JOptionPane.showMessageDialog(null, message);
                getInputsAndDisplayResult();
            }
        }
    }

    public double calculateF2(double x) {
        //todo: calculate result
        return 1.1; //todo: replace this with actual calculated result
    }

}
