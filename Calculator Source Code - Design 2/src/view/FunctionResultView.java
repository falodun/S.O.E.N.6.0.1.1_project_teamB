package view;

import javax.swing.*;

public class FunctionResultView {

    public void showResult(String functionName, String input, String result) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + input + "RESULT:\n" + result;
        JOptionPane.showMessageDialog(null, message);
    }
}
