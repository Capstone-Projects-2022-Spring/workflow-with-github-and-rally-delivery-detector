package edu.temple.cis3296;

/**
 * This is the view part of my MVC implementation of a calculator.
 * The current value is displayed in a JLabel.
 */
public class CalculatorViewCli implements CalculatorView {	
	/**
	 *  the number of fractional digits to show or -1 
	 */
	private int digits;
	private String textDisplayed = "";
	
	/**
	 * Creates the panels and components for the JFrame
	 */
	public CalculatorViewCli() {
	}
	
	public String getTextDisplayed(){
		return textDisplayed;
	}
	/**
	 * Register the controller as the listener to the menu items
	 * and the buttons.
	 * @param controller The event handler for the calculator
	 */
	public void registerListener(CalculatorController controller) {

	}
	
	/**
	 * Display the value in the JLabel of the calculator.
	 * Round off the number of digits if needed.
	 * 
	 * @param value the value to be displayed
	 */
	public void update(String value) {
		if (digits < 0) {
			textDisplayed = value;
			System.out.println(value);
		} else {
			String format = "%." + digits + "f";
			textDisplayed = String.format(format, Double.valueOf(value));
		}
	}
	
	/**
	 * Set the number of fractional digits to display.
	 * -1 means display them all.
	 * 
	 * @param digits the number of fractional digits to display or -1
	 */
	public void setDigits(int digits) {
		this.digits = digits;
	}
}
