package view;

import javax.swing.JOptionPane;

/**
 * 
 * @author Natheepan Ganeshamoorthy (Natt)
 *
 */
public class F5FunctionInputField extends FunctionInputField{
	
	public String errorMsg = "";
	public boolean showDialog = true;
	
	/**
	 * Request user to enter parameter 'a' and ensure it is a real number, and it is not equal to zero
	 * @param functionName
	 * @param inputMessage
	 * @return
	 */
	public ReturnedInput getDoubleInputForA(String functionName, String inputMessage) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + inputMessage;
        String response = getResponseForA(message);
        if (response != null) {
            if (response.length() == 0) {
                errorMsg = "ERROR: NO INPUT RECEIVED\nPlease try again";
                if(showDialog) {
                	JOptionPane.showMessageDialog(null, errorMsg);
                	getDoubleInputForA(functionName, inputMessage);
                	}
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
                        errorMsg = "ERROR: INVALID INPUT\nParameter 'a' cannot be 0.";
                        if(showDialog) {
                        	JOptionPane.showMessageDialog(null, errorMsg);
                        	getDoubleInputForA(functionName, inputMessage);
                        	}
                    }
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    errorMsg = "ERROR: INVALID INPUT\nA real number is expected";
                    if(showDialog) {
                    	JOptionPane.showMessageDialog(null, errorMsg);
                    	getDoubleInputForA(functionName, inputMessage);
                    	}
                }
            }
        }
        return returnedInput;
    }
	
	/**
	 * Get User response for variable a
	 * @param message
	 * @return
	 */
	public String getResponseForA(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	/**
	 * Get User response for variable b
	 * @param message
	 * @return
	 */
	public String getResponseForB(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	/**
	 * Get User response for variable x
	 * @param message
	 * @return
	 */
	public String getResponseForX(String message) {
		return JOptionPane.showInputDialog(message);
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
        String response = getResponseForB(message);
        if (response != null) {
            if (response.length() == 0) {
                errorMsg = "ERROR: NO INPUT RECEIVED\nPlease try again";
                if(showDialog) {
                	JOptionPane.showMessageDialog(null, errorMsg);
                	getDoubleInputForB(functionName, inputMessage);
                }
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
                        errorMsg = "ERROR: INVALID INPUT\nParameter 'b' must be greater than 0, and cannot be 1.";
                        if(showDialog) {
                        	JOptionPane.showMessageDialog(null, errorMsg);
                        	getDoubleInputForB(functionName, inputMessage);
                        }
                    }
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    errorMsg = "ERROR: INVALID INPUT\nA real number is expected";
                    if(showDialog) {
                    	JOptionPane.showMessageDialog(null, errorMsg);
                    	getDoubleInputForB(functionName, inputMessage);
                    }
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
        String response = getResponseForX(message);
        if (response != null) {
            if (response.length() == 0) {
                errorMsg = "ERROR: NO INPUT RECEIVED\nPlease try again";
                if(showDialog) {
                	JOptionPane.showMessageDialog(null, errorMsg);
                    getDoubleInput(functionName, inputMessage);
                }
            }
            else {
                try {
                    returnedInput.input = Double.parseDouble(response);
                    returnedInput.inputWasMade = true;
                }
                catch (Exception e) {
                    errorMsg = "ERROR: INVALID INPUT\nA real number is expected";
                    if(showDialog) {
                    	JOptionPane.showMessageDialog(null, errorMsg);
                        getDoubleInput(functionName, inputMessage);
                    }
                }
            }
        }
        return returnedInput;
    }

}
