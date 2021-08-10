package view;

import javax.swing.JOptionPane;

/**
 * 
 * @author Natheepan Ganeshamoorthy (Natt)
 *
 */
public class FunctionInputFieldForF5 extends FunctionInputField{
	
	/**
	 * Request user to enter parameter 'a' and ensure it is a real number, and it is not equal to zero
	 * @param functionName
	 * @param inputMessage
	 * @return
	 */
	public ReturnedInput getDoubleInputForA(String functionName, String inputMessage) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + inputMessage;
        String response = JOptionPane.showInputDialog(message);
        if (response != null) {
            if (response.length() == 0) {
                message = "ERROR: NO INPUT RECEIVED\nPlease try again";
                JOptionPane.showMessageDialog(null, message);
                getDoubleInputForA(functionName, inputMessage);
            }
            else {
                try {
                	double a = Double.parseDouble(response);
                	try {
                		if(a == 0) {
                			throw new Exception();
                		}
                    	returnedInput.input = a;
                        returnedInput.inputWasMade = true;
                    }
                    catch (Exception e) {
                        //e.printStackTrace();
                        message = "ERROR: INVALID INPUT\nParameter 'a' cannot be 0.";
                        JOptionPane.showMessageDialog(null, message);
                        getDoubleInputForA(functionName, inputMessage);
                    }
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    message = "ERROR: INVALID INPUT\nA real number is expected";
                    JOptionPane.showMessageDialog(null, message);
                    getDoubleInputForA(functionName, inputMessage);
                }
            }
        }
        return returnedInput;
    }

	/**
	 * Request user to enter parameter 'b' and ensure it is a real number, 
	 * and it is not equal to zero or one, and it is greater than zero
	 * @param functionName
	 * @param inputMessage
	 * @return
	 */
	public ReturnedInput getDoubleInputForB(String functionName, String inputMessage) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + inputMessage;
        String response = JOptionPane.showInputDialog(message);
        if (response != null) {
            if (response.length() == 0) {
                message = "ERROR: NO INPUT RECEIVED\nPlease try again";
                JOptionPane.showMessageDialog(null, message);
                getDoubleInputForB(functionName, inputMessage);
            }
            else {
                try {
                	double b = Double.parseDouble(response);
                	try {
                		if(b == 0 || b < 0 || b == 1) {
                			throw new Exception();
                		}
                    	returnedInput.input = b;
                        returnedInput.inputWasMade = true;
                    }
                    catch (Exception e) {
                        //e.printStackTrace();
                        message = "ERROR: INVALID INPUT\nParameter 'b' must be greater than 0, and cannot be 1.";
                        JOptionPane.showMessageDialog(null, message);
                        getDoubleInputForB(functionName, inputMessage);
                    }
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    message = "ERROR: INVALID INPUT\nA real number is expected";
                    JOptionPane.showMessageDialog(null, message);
                    getDoubleInputForB(functionName, inputMessage);
                }
            }
        }
        return returnedInput;
    }
	
	/**
	 * Request user to enter parameter 'x' and ensure it is a real number
	 */
	@Override
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
