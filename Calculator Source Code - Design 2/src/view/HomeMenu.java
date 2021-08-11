package view;
import model.*;
import javax.swing.JOptionPane;

/**
 * Class HomeMenu implements a user-interface for the program's Home Menu
 * @author Adekunle Falodun
 */
public class HomeMenu {

	/**
     * Method showHomeMenu shows the Home Menu
     */
    public void showHomeMenu() {
        F1 f1 = new F1();
        F3 f3 = new F3();
        F5 f5 = new F5();
        F7 f7 = new F7();

        String message =
            "HOME MENU" +
            "\nEnter the option number to select a function." +
            "\nE.g. Enter 1 for the first" +
            "\n\n[1]    " + f1.functionName +
            "\n[2]    " + f3.functionName +
            "\n[3]    " + f5.functionName +
            "\n[4]    " + f7.functionName;

        String response = JOptionPane.showInputDialog(message);
        if (response != null) {
            if (response.length() == 0) {
                handleInvalidInput("ERROR: NO INPUT RECEIVED\nPlease try again");
            }
            else {
                try {
                    int choice = Integer.parseInt(response);
                    if (choice == 1) {
                        f1.runFunction();
                    }
                    else if(choice == 2) {
                        f3.runFunction();
                    }
                    else if(choice == 3) {
                        f5.runFunction();
                    }
                    else if(choice == 4) {
                        f7.runFunction();
                    }
                    else {
                        handleInvalidInput("ERROR: INVALID OPTION");
                    }
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    handleInvalidInput("ERROR: INVALID INPUT\nAn integer number is expected");
                }
            }
        }
    }

    /**
     * Method handleInvalidInput shows an error message
     * @param message   holds the error message text
     */
    private void handleInvalidInput(String message) {
        JOptionPane.showMessageDialog(null, message);
        showHomeMenu();
    }
}
