package view;

import javax.swing.*;

public class FunctionInputField {
    double doubleInput = 0;

    public double getDoubleInput(String functionName, String inputMessage) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + inputMessage;
        String response = JOptionPane.showInputDialog(message);
        if ((response != null) && (response.length() > 0)) {
            try {
                doubleInput = Double.parseDouble(response);
            }
            catch (Exception e) {
                //e.printStackTrace();
                message = "ERROR: INVALID INPUT\nA real number is expected";
                JOptionPane.showMessageDialog(null, message);
                getDoubleInput(functionName, inputMessage);
            }
        }
        return doubleInput;
    }
}
