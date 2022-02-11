package edu.temple.cis3296;

public interface CalculatorView  {	
	
	/**
	 * Register the controller as the listener to the menu items
	 * and the buttons.
	 * @param controller The event handler for the calculator
	 */
	public void registerListener(CalculatorController controller);
	
	public void update(String value);
	
	public void setDigits(int digits);
}
