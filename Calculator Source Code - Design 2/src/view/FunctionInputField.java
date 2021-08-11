package view;

import javax.swing.*;

/**
 * Class FunctionInputField implements a user-interface for receiving
 * user inputs for a funtion's variables
 * @author Adekunle Falodun
 */
public class FunctionInputField {
	
	/**
	 * ReturnedInput returnedInput
	 */
    ReturnedInput returnedInput = new ReturnedInput();

    /**
     * Method getDoubleInput gets user-input of a double type number
     * @param functionName   holds the name of the current function using the input field
     * @param inputMessage   holds the input's prompt message
     * @return ReturnedInput
     */
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
                    message = "ERROR: INVALID INPUT\nA real number is expected";
                    JOptionPane.showMessageDialog(null, message);
                    getDoubleInput(functionName, inputMessage);
                }
            }
        }
        return returnedInput;
    }
}
