package calculator;

/**
 * @author Tony
 */
public enum Operator
{
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	EXPONENT("^");

	public String label;

	private Operator(String label)
	{
		this.label = label;
	}
}