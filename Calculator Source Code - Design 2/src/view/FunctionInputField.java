package view;

import javax.swing.*;

public class FunctionInputField {
    ReturnedInput returnedInput = new ReturnedInput();

    public ReturnedInput getDoubleInput(String functionName, String inputMessage) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + inputMessage;
        String response = JOptionPane.showInputDialog(message);
        if (response != null) {
            if (response.length() == 0) {
                message = "ERROR: NO INPUT RECEIVED\nPlease try again";
                JOptionPane.showMessageDialog(null, message);
                getDoubleInput(functionName, inputMessage);
            }
            else {
                try {
                    returnedInput.input = Double.parseDouble(response);
                    returnedInput.inputWasMade = true;
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    message = "ERROR: INVALID INPUT\nA real number is expected";
                    JOptionPane.showMessageDialog(null, message);
                    getDoubleInput(functionName, inputMessage);
                }
            }
        }
        return returnedInput;
    }
}
