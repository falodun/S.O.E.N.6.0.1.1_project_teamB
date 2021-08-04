package view;
import model.*;
import javax.swing.JOptionPane;

public class HomeMenu {

    public void showHomeMenu() {
        F2 f2 = new F2();
        F3 f3 = new F3();
        F5 f5 = new F5();
        F7 f7 = new F7();

        String message =
            "HOME MENU" +
            "\nEnter the option number to select a function." +
            "\nE.g. Enter 1 for the first" +
            "\n\n[1]    " + f2.functionName +
            "\n[2]    " + f3.functionName +
            "\n[3]    " + f5.functionName +
            "\n[4]    " + f7.functionName;

        String response = JOptionPane.showInputDialog(message);
        if ((response != null) && (response.length() > 0)) {
            try {
                int choice = Integer.parseInt(response);
                if (choice == 1) {
                    f2.runFunction();
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

    private void handleInvalidInput(String message) {
        JOptionPane.showMessageDialog(null, message);
        showHomeMenu();
    }
}
