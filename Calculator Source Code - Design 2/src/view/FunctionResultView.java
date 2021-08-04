package view;

import javax.swing.*;

public class FunctionResultView {

    public void showResult(String selectedFunctionMessage, String input, String result) {
        String message = selectedFunctionMessage + input + "RESULT:\n" + result;
        JOptionPane.showMessageDialog(null, message);
    }
}
