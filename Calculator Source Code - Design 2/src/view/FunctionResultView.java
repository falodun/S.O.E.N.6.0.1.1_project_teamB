package view;

import javax.swing.*;

/**
 * Class FunctionResultView implements a user-interface for displaying
 * the result of a function's calculation
 * @author Adekunle Falodun
 */
public class FunctionResultView {

	/**
     * Method showResult show the result of a function's calculation
     * @param functionName   holds the name of the function
     * @param input   holds inputs the user has entered
     * @param result   holds the calculated result
     */
    public void showResult(String functionName, String input, String result) {
        String message = "SELECTED FUNCTION: " + functionName + "\n\n" + input + "RESULT:\n" + result;
        JOptionPane.showMessageDialog(null, message);
    }
}
