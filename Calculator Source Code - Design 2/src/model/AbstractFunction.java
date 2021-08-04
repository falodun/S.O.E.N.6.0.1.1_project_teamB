package model;
import view.HomeMenu;

public abstract class AbstractFunction {

    public final void runFunction() {
        getInputsAndDisplayResult();
        new HomeMenu().showHomeMenu();
    }

    public abstract void getInputsAndDisplayResult();

    public abstract double calculateResult();

}
