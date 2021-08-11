package model;
import view.HomeMenu;
import view.ReturnedInput;

/**
 * Abstract Class AbstractFunction acts as a template for the concrete functions
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
     * Abstract Method getInputs, to get user inputs
     * @return ReturnedInput
     */
    public abstract ReturnedInput getInputs();
    
    /**
     * Abstract Method calculateResult, to calculate result
     */
    public abstract void calculateResult();

    /**
     * Abstract Method displayResult, to display result
     */
    public abstract void displayResult();

}
