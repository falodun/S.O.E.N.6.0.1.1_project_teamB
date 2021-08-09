package model;
import view.HomeMenu;

public abstract class AbstractFunction {

    public final void runFunction() {
        boolean inputWasMade = getInputs();
        if (inputWasMade) {
            calculateResult();
            displayResult();
        }
        new HomeMenu().showHomeMenu();
    }

    public abstract boolean getInputs();

    public abstract void calculateResult();

    public abstract void displayResult();

}
