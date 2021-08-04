package functions;
import utils.HomeMenu;
import javax.swing.JOptionPane;

public abstract class AbstractFunction {

    public final void run() {
        getInputsAndDisplayResult();
        new HomeMenu().run();
    }

    public abstract void getInputsAndDisplayResult();

}
