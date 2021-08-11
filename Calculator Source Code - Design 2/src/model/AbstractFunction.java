package model;
import view.HomeMenu;
import view.ReturnedInput;

/**
 * Abstract Class AbstractFunction acts as a template for concrete functions
 * @author Adekunle Falodun
 */
public abstract class AbstractFunction {
	
	/**
     * Method runFunction runs the general steps of using a function
     */
    public final void runFunction() {
        ReturnedInput returnInput = getInputs();
        if (returnInput.inputWasMade) {
            calculateResult();
            displayResult();
        }
        new HomeMenu().showHomeMenu();
    }
    
    /**
     * Abstract Method getInputs gets user inputs
     * @return ReturnedInput
     */
    public abstract ReturnedInput getInputs();
    
    /**
     * Abstract Method getInputs gets user inputs
     */
    public abstract void calculateResult();

    public abstract void displayResult();

}
