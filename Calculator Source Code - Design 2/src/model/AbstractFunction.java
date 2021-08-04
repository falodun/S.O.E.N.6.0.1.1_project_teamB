package model;
import view.HomeMenu;

public abstract class AbstractFunction {

    public final void runFunction() {
        getInputs();
        calculateResult();
        displayResult();
        new HomeMenu().showHomeMenu();
    }

    public abstract void getInputs();

    public abstract void calculateResult();

    public abstract void displayResult();

}
