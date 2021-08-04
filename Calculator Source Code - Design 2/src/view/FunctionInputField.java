package view;

import javax.swing.*;

public class FunctionInputField {
    double doubleInput = 0;
    int integerInput = 0;

    public double getDoubleInput(String selectedFunctionMessage, String inputLabel) {
        String message = selectedFunctionMessage + "Enter value for: " + inputLabel;
        String response = JOptionPane.showInputDialog(message);
        if ((response != null) && (response.length() > 0)) {
            try {
                doubleInput = Double.parseDouble(response);
            }
            catch (Exception e) {
                //e.printStackTrace();
                message = "ERROR: INVALID INPUT\nA real number is expected";
                JOptionPane.showMessageDialog(null, message);
                getDoubleInput(selectedFunctionMessage, inputLabel);
            }
        }
        return doubleInput;
    }

    public int getIntegerInput(String selectedFunctionMessage, String inputLabel) {
        String message = selectedFunctionMessage + "Enter value for: " + inputLabel;
        String response = JOptionPane.showInputDialog(message);
        if ((response != null) && (response.length() > 0)) {
            try {
                integerInput = Integer.parseInt(response);
            }
            catch (Exception e) {
                //e.printStackTrace();
                message = "ERROR: INVALID INPUT\nAn integer number is expected";
                JOptionPane.showMessageDialog(null, message);
                getIntegerInput(selectedFunctionMessage, inputLabel);
            }
        }
        return integerInput;
    }
}
