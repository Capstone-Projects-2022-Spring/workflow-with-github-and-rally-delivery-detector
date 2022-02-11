package edu.temple.cis3296;

import javax.swing.JFrame;

/**
 * The Calculator class along with CalculatorController,
 * CalculatorModel and CalculatorView implements a
 * simple-minded calculator.
 * The implementation is based on the MVC design pattern.
 *
 * @author Tom Bylander
 */
public class Calculator {
    /**
     * Create the model, view and controller objects,
     * and launch the application.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
			
            CalculatorModel model = new CalculatorModel();
            CalculatorViewCli view = new CalculatorViewCli();
            CalculatorController controller = new CalculatorController(model, view);

            /* register controller as listener */
            view.registerListener(controller);

            String commands = args[0];
            for (int i = 0; i < commands.length(); i++) {
                String singleKeyPress = Character.toString(commands.charAt(i));
                controller.modelPerform(singleKeyPress);
            }
            System.out.println(view.getTextDisplayed());

        } else {

            /* create new model, view and controller */
            CalculatorModel model = new CalculatorModel();
            CalculatorViewGui view = new CalculatorViewGui();
            CalculatorController controller = new CalculatorController(model, view);

            /* register controller as listener */
            view.registerListener(controller);

            /* start it up */
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setSize(400, 300);
            view.setVisible(true);
        }
    }
}
